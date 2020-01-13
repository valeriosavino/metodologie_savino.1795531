package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.DBConnection;

@WebServlet(name = "TaskDefinitionAnnotationServlet", urlPatterns = "/definitionAnnotation.jsp")
public class TaskDefinitionAnnotationServlet extends BaseServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String word = (String) request.getParameter("hWord");
		String hypernym = (String) request.getParameter("hHypernym");
		String definition = (String) request.getParameter("definition");
		String email = (String) (request.getSession().getAttribute("username"));
		
		PrintWriter out = response.getWriter();
		out.append(word);
		out.append(hypernym);
		out.append(definition);
		
		try
		{
			Connection c = DBConnection.getInstance();
			
			PreparedStatement stm = c.prepareStatement("INSERT INTO defann (Word, Hypernym, Definition, Email) VALUES (?,?,?,?)");
			stm.setString(1, word);
			stm.setString(2, hypernym);
			stm.setString(3, definition);
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
