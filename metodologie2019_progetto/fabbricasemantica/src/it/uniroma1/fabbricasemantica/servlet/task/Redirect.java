package it.uniroma1.fabbricasemantica.servlet.task;

/**
 * Interfaccia per ottenere url dei task randomicamente
 * @author Savino
 *
 */
public interface Redirect 
{
	String[] tasks = {"translationAnnotation.html",
			"wordAnnotation.html", 
			"definitionAnnotation.html",
			"senseAnnotation.html",
			"translationValidation.html",
			"senseValidation.html",
			"myAnnotation.html"};
	
	/**
	 * Restituisce una stringa contenente un indirizzo randomico a un task
	 * @return
	 */
	static String redirect()
	{
		return tasks[(int)(Math.random()*tasks.length)];
	}
}
