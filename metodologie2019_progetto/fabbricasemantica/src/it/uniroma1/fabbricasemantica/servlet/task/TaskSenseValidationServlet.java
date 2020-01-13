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

@WebServlet(name = "TaskSenseValidationServlet", urlPatterns = "/senseValidation.jsp")
public class TaskSenseValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String word = (String) request.getParameter("hWord");
		String example = (String) request.getParameter("hExample");
		String sense = (String) request.getParameter("hSense");
		String yesNo = (String) request.getParameter("radio");
		String email = (String) (request.getSession().getAttribute("username"));
		try
		{
			Connection c = DBConnection.getInstance();
			
			PreparedStatement stm = c.prepareStatement("INSERT INTO senseval (Word, Example, Sense, YesNo, Email) VALUES (?,?,?,?,?)");
			stm.setString(1, word);
			stm.setString(2, example);
			stm.setString(3, sense);
			stm.setString(4, yesNo);
			stm.setString(5, email);
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		response.sendRedirect(Redirect.redirect());
	}

}
