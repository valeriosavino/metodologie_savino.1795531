package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.DBConnection;

@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet
{
	private static final long serialVersionUID = 8484501789787L;
    
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//prendo username e password dal frontend
		String username = (String) request.getParameter("input_email");
		String password = (String) request.getParameter("input_pass");
		
		try
		{
			//connessione e prelievo dati
			Connection c = DBConnection.getInstance();
			
			PreparedStatement stm = c.prepareStatement("SELECT Email, Password FROM Utenti WHERE Email = ? AND Password = ?");
			stm.setString(1, username);
			stm.setString(2, password);
			
    		ResultSet rs = stm.executeQuery();
    		if(rs.next())
    		{
    			//creazione sessione con username
    			HttpSession session = request.getSession();
    			session.setAttribute("username", rs.getString("Email"));
    			response.sendRedirect("home.html");
    		}
    		else
    		{
    			//inserire reindirizzamento a login.html
    			response.setContentType("text/html");
    			PrintWriter out = response.getWriter();
    			out.print("<H1>Utente non trovato nel sistema</H1>");
    			out.print("<a href=\"login.html\">Torna al login</a>");
    		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
