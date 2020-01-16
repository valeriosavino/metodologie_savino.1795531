package quickstart;

import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe astratta che fa da base per la pagina home e tutte le pagine dei tasks 
 * @author Savino
 *
 */
abstract public class BasePage 
{	
	/**
	 * Contiene l'indirizzo della servlet per effettuare il logout
	 */
	private static final String SERVLET_URL = "logout.jsp";
	
	/**
	 * Contiene l'indirizzo della servlet per il controllo della sessione
	 */
	private static final String AUTHENTICATION_URL = "isLoggedIn.jsp";
	
	/**
	 * Contiene l'indirizzo della servlet dello StandardDataProvider
	 */
	protected static final String REST_URL = "nextExample.jsp";
	
	/**
	 * Campo che contiene il contenuto della pagina
	 */
	private HTMLDivElement container;
	
	/**
	 * Costruttore
	 */
	protected BasePage()
	{
		checkSession();
		
		$("body").append(createNavbar());
		
		container = new Div.DivBuilder()
				.setClassName("container")
				.build();
	}
	
	/**
	 * Controlla se è stata settata la sessione all'interno delle pagine
	 */
	protected void checkSession()
	{
		$.getJSON(AUTHENTICATION_URL, (Object result, String a, JQueryXHR ctx) -> 
		{
			JSON json = (JSON) result;
			if(json.toString().equals("false"))
				window.location.href = "login.html";
			
			return null;
		});
	}

	
	/**
	 * Crea e restituisce la navbar con i collegamenti all'uscita del programma e alla home
	 * @return navbar formattata
	 */
	protected HTMLDivElement createNavbar()
	{
		HTMLAnchorElement home = new Anchor.AnchorBuilder()
				.setHref("home.html")
				.setClassName("navbar-brand")
				.setText("FabbricaSemantica")
				.build();
		
		HTMLAnchorElement logout = new Anchor.AnchorBuilder()
				.setText("ESCI")
				.setHref(SERVLET_URL)
				.setClassName("btn btn-outline-info my-2 my-sm-0")
				.build();
		
		return new Div.DivBuilder()
				.setClassName("navbar navbar-dark bg-dark")
				.append(home)
				.append(logout)
				.build();
	}
	
	/**
	 * Restituisce un indirizzo casuale di uno dei task
	 * @return stringa contenente indirizzo di un task 
	 */
	private String getNextTask()
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
	
	/**
	 * Crea i bottoni NEXT e SKIP e li formatta in un div
	 * @return div con bottoni NEXT e SKIP al suo interno 
	 */
	protected HTMLDivElement createButtonsNextSkip()
	{
		HTMLInputElement next = new Input.InputBuilder()
				.setType("submit")
				.setValue("AVANTI")
				.setName("avanti")
				.setClassName("btn btn-primary btn-lg")
				.build();
		
		HTMLInputElement skip = new Input.InputBuilder()
				.setType("button")
				.setValue("SALTA")
				.setName("SALTA")
				.css("margin-left", "10px")
				.setClassName("btn btn-primary btn-lg")
				.onClick(click -> window.location.href = getNextTask()) 
				.build();
		
		return new Div.DivBuilder()
				.setAlign("right")
				.setClassName("form-group")
				.append(next)
				.append(skip)
				.build();
	}
	
	/**
	 * Crea degli input nascosti 
	 * @param name nome dell'input
	 * @return input nascosto
	 */
	protected HTMLInputElement hidden(String name)
	{
		return new Input.InputBuilder()
				.setType("hidden")
				.setName(name)
				.build();
	}
	
	/**
	 * Crea il form della pagina
	 * @param servlet_url indirizzo della servlet a cui inviare i dati del form
	 * @param e elementi da inserire nel form
	 */
	protected void createForm(String servlet_url, HTMLElement... e)
	{
		HTMLFormElement form = new Form.FormBuilder()
				.setAction(servlet_url)
				.append(e)
				.setMethod("POST")
				.append(createButtonsNextSkip())
				.build();
		
		appendContainer(form);
	}
	
	/**
	 * Crea il container con gli elementi forniti dalle pagine
	 * @param e elementi della pagina
	 */
	protected void appendContainer(HTMLElement... e)
	{
		$(container).append(e);
		appendBody();
	}
	
	/**
	 * Inserisce il container nella navbar
	 */
	private void appendBody()
	{
		$("body").append(container);
	}
}
