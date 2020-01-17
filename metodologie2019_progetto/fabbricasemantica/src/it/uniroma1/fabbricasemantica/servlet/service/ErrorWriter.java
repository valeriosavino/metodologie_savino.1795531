package it.uniroma1.fabbricasemantica.servlet.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * Interfaccia per la stampa di errori nelle pagine
 * @author Savino
 *
 */
public interface ErrorWriter 
{
	/**
	 * Stampa un messaggio di errore e un link per il ritorno alla pagina precedente
	 * @param response Dati da inviare al client
	 * @param errorMessage messaggio di errore 
	 * @param linkGoBack url della pagina precedente 
	 * @throws IOException 
	 */
	static void print(HttpServletResponse response, String errorMessage, String linkGoBack) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		out.print("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js\"></script>");
		out.print("<center><div class=\"alert alert-danger\" role=\"alert\"><H1>" + errorMessage +"</H1></div>");
		out.print("<a href= \""+ linkGoBack +"\">Torna indietro...</a></center>");
	}
}
