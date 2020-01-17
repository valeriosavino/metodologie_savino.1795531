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

@WebServlet(name = "TaskSenseAnnotationServlet", urlPatterns = "/senseAnnotation.jsp")
public class TaskSenseAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Inserisce la parola, la descrizione, i sensi scelti dall'utente e il nome utente all'interno del database
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		try
		{
			Connection c = DBConnection.getInstance();
			
			List<String> parameters = new ArrayList<>();
			parameters.add((String) request.getParameter("hWord"));
			parameters.add((String) request.getParameter("hDescription"));
			
			String[] check = ((String[]) request.getParameterValues("check[]"));
			String senses = "";
			for(int i=0; i<check.length; i++)
				senses += check[i]+"; ";
			
			parameters.add(senses);
			parameters.add((String)(request.getSession().getAttribute("username")));
			
			PreparedStatement stm = c.prepareStatement("INSERT INTO senseann (Word, Description, Senses, Email) VALUES (?,?,?,?)");
			for(int i=0; i<parameters.size(); i++)
				stm.setString(i+1, parameters.get(i));
			
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			ErrorWriter.print(response, "Errore nella connessione al database, riprova pi&ugrave; tardi", "senseAnnotation.html");
			e.printStackTrace();
		}
		
		response.sendRedirect(Redirect.redirect());
	}

}
