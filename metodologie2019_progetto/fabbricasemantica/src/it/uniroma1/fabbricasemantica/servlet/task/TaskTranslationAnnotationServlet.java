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

@WebServlet(name = "TaskTranslationAnnotationServlet", urlPatterns = "/translationAnnotation.jsp")
public class TaskTranslationAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String word = (String) request.getParameter("hWord");
		String description = (String) request.getParameter("hDescription");
		String translation = (String) request.getParameter("translation");
		String email = (String) (request.getSession().getAttribute("username"));
		
		try
		{
			Connection c = DBConnection.getInstance();
			
			PreparedStatement stm = c.prepareStatement("INSERT INTO trann (Word, Description, Translation, Email) VALUES (?,?,?,?)");
			stm.setString(1, word);
			stm.setString(2, description);
			stm.setString(3, translation);
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
