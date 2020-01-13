package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.DBConnection;

@WebServlet(name="SignupServlet", urlPatterns="/signup.jsp")
public class SignupServlet extends BaseServlet
{
	private static final long serialVersionUID = 8484501789787L;
	
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String p1 = (String) request.getAttribute("input_pass");
		String p2 = (String) request.getAttribute("input_conf_pass");
		if(!(p1.equals(p2)))
		{
			response.sendRedirect("signup.html");
		}
		
		try
		{
			//connessione al database
			Connection c = DBConnection.getInstance();
			
			PreparedStatement prepared = c.prepareStatement("INSERT INTO utenti (Email, Password, LinguaIt, LinguaEn, Livello) VALUES (?,?,?,?,?)");
			prepared.setString(1, (String) request.getParameter("input_email"));
			prepared.setString(2, (String) request.getParameter("input_pass"));
			//correggere per la lingua
			prepared.setString(3, (String) request.getParameter("italiano"));
			prepared.setString(4, (String) request.getParameter("inglese"));
			prepared.setString(5, (String) request.getParameter("livello"));
			prepared.executeUpdate();
			
			//sq inserimento va a buon fine si reindirizza a home.html
			
    	}
    	catch(SQLException e)
    	{
    		//se utente già esistente
    		//ricaricamento signup.html con messaggio "Utente gia esistente nel DB"
    		//altrimenti errore generico del database
    		e.printStackTrace();
    	}
		
	}
}
