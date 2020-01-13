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

@WebServlet(name = "TaskSenseAnnotationServlet", urlPatterns = "/senseAnnotation.jsp")
public class TaskSenseAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String word = (String) request.getParameter("hWord");
		String description = (String) request.getParameter("hDescription");
		String[] check = ((String[]) request.getParameterValues("check[]"));
		String senses = "";
		for(int i=0; i < check.length; i++)
			senses += check[i]+"; ";
		String email = (String) (request.getSession().getAttribute("username"));
		try
		{
			Connection c = DBConnection.getInstance();
			
			PreparedStatement stm = c.prepareStatement("INSERT INTO senseann (Word, Description, Senses, Email) VALUES (?,?,?,?)");
			stm.setString(1, word);
			stm.setString(2, description);
			stm.setString(3, senses);
			stm.setString(4, email);
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		response.sendRedirect(Redirect.redirect());
	}

}
