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

@WebServlet(name = "TaskSenseValidationServlet", urlPatterns = "/senseValidation.jsp")
public class TaskSenseValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Inserisce la parola, l'esempio, il senso, la conferma di esso data dall'utente e il nome utente all'interno del database
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Connection c = DBConnection.getInstance();
			
			List<String> parameters = new ArrayList<>();
			parameters.add((String) request.getParameter("hWord"));
			parameters.add((String) request.getParameter("hExample"));
			parameters.add((String) request.getParameter("hSense"));
			parameters.add((String) request.getParameter("radio"));
			parameters.add((String) (request.getSession().getAttribute("username")));
			
			PreparedStatement stm = c.prepareStatement("INSERT INTO senseval (Word, Example, Sense, YesNo, Email) VALUES (?,?,?,?,?)");
			for(int i=0; i<parameters.size(); i++)
				stm.setString(i+1, parameters.get(i));
			
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			ErrorWriter.print(response, "Errore nella connessione al database, riprova pi&ugrave; tardi", "senseValidation.html");
			e.printStackTrace();
		}
		
		response.sendRedirect(Redirect.redirect());
	}

}
