package it.uniroma1.fabbricasemantica.servlet.task;

public interface Redirect 
{
	static String redirect()
	{
		String[] tasks = {"translationAnnotation.html",
				"wordAnnotation.html", 
				"definitionAnnotation.html",
				"senseAnnotation.html",
				"translationValidation.html",
				"senseValidation.html",
				"myAnnotation.html"};
		return tasks[(int)(Math.random()*tasks.length)];
	}
}
