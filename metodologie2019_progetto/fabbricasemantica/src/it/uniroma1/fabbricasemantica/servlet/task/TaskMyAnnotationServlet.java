package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.service.DBConnection;
import it.uniroma1.fabbricasemantica.servlet.service.ErrorWriter;

@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Inserisce le parole, i sinonimi delle parole scelti dall'utente e il nome utente all'interno del database
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Connection c = DBConnection.getInstance();
			
			List<String> parameters = new ArrayList<>();
			parameters.add((String) request.getParameter("hWord1"));
			parameters.add((String) request.getParameter("selected1"));
			parameters.add((String) request.getParameter("hWord2"));
			parameters.add((String) request.getParameter("selected2"));
			parameters.add((String) request.getParameter("hWord3"));
			parameters.add((String) request.getParameter("selected3"));
			parameters.add((String) (request.getSession().getAttribute("username")));
			
			PreparedStatement stm = c.prepareStatement("INSERT INTO myann (Word1, Selected1, Word2, Selected2, Word3, Selected3, Email) VALUES (?,?,?,?,?,?,?)");
			for(int i=0; i<parameters.size(); i++)
				stm.setString(i+1, parameters.get(i));
			
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			ErrorWriter.print(response, "Errore nella connessione al database, riprova pi&ugrave; tardi", "myAnnotation.html");
			e.printStackTrace();
		}
		
		response.sendRedirect(Redirect.redirect());
	}

}
