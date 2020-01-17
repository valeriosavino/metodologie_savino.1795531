package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class WordAnnotation extends BasePage
{
	/**
	 * Indirizzo della servlet per WordAnnotation
	 */
	private static final String SERVLET_URL = "wordAnnotation.jsp";
	/**
	 * Label per la descrizione fornita
	 */
	private HTMLLabelElement description;
	/**
	 * Campo nascosto per la descrizione
	 */
	private HTMLInputElement hDescription;
	/**
	 * Casella di testo per la word
	 */
	private HTMLInputElement word;
	/**
	 * Contenitore per la descrizione
	 */
	private HTMLDivElement splitDescription;
	/**
	 * Contenitore per la word
	 */
	private HTMLDivElement splitWord;
	
	/**
	 * Costruttore
	 */
	private WordAnnotation()
	{
		super("Data la seguente definizione, provare a indovinare il termine definito");
		
		description = new Label.LabelBuilder()
				.setClassName("form-control-plaintext")
				.build();
		
		hDescription = hidden("hDescription");
		
		$.getJSON(REST_URL, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sDescription = json.$get("description");
			$(description).text("Descrizione: "+sDescription);
			$(hDescription).attr("value", sDescription);
			return null;
		});
		
		word = new Input.InputBuilder()
				.setType("text")
				.setClassName("form-control")
				.setName("word")
				.setPlaceholder("Inserisci la parola...")
				.css("margin-top", "30px")
				.css("margin-bottom", "20px")
				.required()
				.build();
		
		splitDescription = new Div.DivBuilder()
				.setClassName("col")
				.append(description, hDescription)
				.css("margin-top", "20px")
				.css("margin-bottom", "20px")
				.build();
		
		splitWord = new Div.DivBuilder()
				.setClassName("col")
				.append(word)
				.build();
		
		HTMLDivElement divRow = new Div.DivBuilder()
				.setClassName("row")
				.append(splitDescription, splitWord)
				.build();
		
		HTMLDivElement container = new Div.DivBuilder()
				.setClassName("container")
				.append(divRow)
				.build();
		
		createForm(SERVLET_URL, container);
	}
	
	public static void main(String[] args)
	{
		new WordAnnotation();
	}
}
