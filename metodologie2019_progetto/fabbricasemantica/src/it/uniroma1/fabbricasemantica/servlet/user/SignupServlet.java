package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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

@WebServlet(name="SignupServlet", urlPatterns="/signup.jsp")
public class SignupServlet extends BaseServlet
{
	private static final long serialVersionUID = 8484501789787L;
	
	@Override
	/**
	 * Controlla se le due password inserite dall'utente siano corrispondenti
	 * se non corrispondono stampa un messaggio di errore
	 * altrimenti inserisce all'interno del database i dati inseriti dall'utente.
	 * Se l'utente è gia presente nel database, stampa un messaggio di errore 
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String pass = (String) request.getParameter("input_pass");
		String pass2 = (String) request.getParameter("input_conf_pass");
		if(!(pass.equals(pass2)))
			ErrorWriter.print(response, "Attenzione, le due password inserite non coincidono", "signup.html");
		else
		{
			String[] check = ((String[]) request.getParameterValues("check[]"));
			String lingue = "";
			for(int i=0; i<check.length; i++)
				lingue += check[i]+";";
			
			String email = (String) request.getParameter("input_email");
			List<String> parameters = new ArrayList<>();
			parameters.add(email);
			parameters.add(pass);
			parameters.add(lingue);
			parameters.add((String) request.getParameter("altre_lingue"));
			parameters.add((String) request.getParameter("livello"));
			
			try
			{
				Connection c = DBConnection.getInstance();
			
				PreparedStatement stm = c.prepareStatement("INSERT INTO utenti (Email, Password, LingueSistema, AltreLingue, Livello) VALUES (?,?,?,?,?)");
				for(int i=0; i<parameters.size(); i++)
					stm.setString(i+1, parameters.get(i));
				
				stm.executeUpdate();
				
				Session.createSession(request, response, email);	
			}
			catch(SQLIntegrityConstraintViolationException e)
			{
				ErrorWriter.print(response, "&Egrave; gi&agrave; presente nel sistema un utente con questo nome", "signup.html");
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				ErrorWriter.print(response, "Errore nella connessione al database, riprova pi&ugrave; tardi", "signup.html");
				e.printStackTrace();
			}
		}
	}
}
