package it.uniroma1.fabbricasemantica.servlet.task;

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

@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String word1 = (String) request.getParameter("hWord1");
		String word2 = (String) request.getParameter("hWord2");
		String word3 = (String) request.getParameter("hWord3");
		
		String selected1 = (String) request.getParameter("selected1");
		String selected2 = (String) request.getParameter("selected2");
		String selected3 = (String) request.getParameter("selected3");
		
		String email = (String) (request.getSession().getAttribute("username"));
		
		try
		{
			Connection c = DBConnection.getInstance();
			
			PreparedStatement stm = c.prepareStatement("INSERT INTO myann (Word1, Selected1, Word2, Selected2, Word3, Selected3, Email) VALUES (?,?,?,?,?,?,?)");
			stm.setString(1, word1);
			stm.setString(2, selected1);
			stm.setString(3, word2);
			stm.setString(4, selected2);
			stm.setString(5, word3);
			stm.setString(6, selected3);
			stm.setString(7, email);
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		response.sendRedirect(Redirect.redirect());
	}

}
