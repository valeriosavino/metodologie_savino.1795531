package it.uniroma1.fabbricasemantica.servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Interfaccia per creazione di una sessione
 * @author Savino
 *
 */
public interface Session 
{
	/**
	 * Crea una sessione per l'utente e reindirizza a home.html
	 * @param request dati spediti dal client
	 * @param response dati inviati al client
	 * @param email email dell'utente
	 * @throws ServletException
	 * @throws IOException
	 */
	static void createSession(HttpServletRequest request, HttpServletResponse response, String email) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.setAttribute("username", email);
		response.sendRedirect("home.html");
	}
	
	/**
	 * Distrugge la sessione per l'utente e reindirizza a login.html
	 * @param request dati spediti dal client
	 * @param response dati inviati al client
	 * @throws ServletException
	 * @throws IOException
	 */
	static void destroySession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.html");
	}
}
