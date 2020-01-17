package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import it.uniroma1.fabbricasemantica.servlet.service.Session;

@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet
{
	private static final long serialVersionUID = 8484501789787L;
    
	@Override
	/**
	 * Preleva dal database il valore dell'email e della password, se corretti crea la sessione 
	 * altrimenti stampa un messaggio di non presenza nel database
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Connection c = DBConnection.getInstance();
			
			List<String> parameters = new ArrayList<>();
			parameters.add((String) request.getParameter("input_email"));
			parameters.add((String) request.getParameter("input_pass"));
			
			
			PreparedStatement stm = c.prepareStatement("SELECT Email, Password FROM Utenti WHERE Email = ? AND Password = ?");
			for(int i=0; i<parameters.size(); i++)
				stm.setString(i+1, parameters.get(i));
			
    		ResultSet rs = stm.executeQuery();
    		if(rs.next())
    			Session.createSession(request, response, rs.getString("Email"));
    		else
    			ErrorWriter.print(response, "Utente non presente nel sistema", "login.html");
		}
		catch(SQLException e)
		{
			ErrorWriter.print(response, "Errore nella connessione al database, riprova pi&ugrave; tardi", "login.html");
			e.printStackTrace();
		}
	}
}
