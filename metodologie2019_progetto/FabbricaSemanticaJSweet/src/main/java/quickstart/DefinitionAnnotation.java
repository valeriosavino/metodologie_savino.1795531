package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
/**
 * Classe per la pagina definitionAnnotation.html
 * @author Savino
 *
 */
public class DefinitionAnnotation extends BasePage
{
	/**
	 * Label per la word fornita
	 */
	private HTMLLabelElement word;
	/**
	 * Label per l'iperonimo fornito
	 */
	private HTMLLabelElement hypernym;
	/**
	 * Campo nascosto per la word
	 */
	private HTMLInputElement hWord;
	/**
	 * Campo nascosto per l'iperonimo
	 */
	private HTMLInputElement hHypernym;
	/**
	 * Textarea per la definizione
	 */
	private HTMLTextAreaElement definition;
	/**
	 * Contenitore per label word e hypernym
	 */
	private HTMLDivElement divWordHypernym;
	/**
	 * Contenitore per la textarea
	 */
	private HTMLDivElement divText;
	
	/**
	 * Indirizzo della Servlet di definitionAnnotation
	 */
	private static final String SERVLET_URL = "definitionAnnotation.jsp";
	
	/**
	 * Costruttore
	 */
	private DefinitionAnnotation()
	{	
		super("Data la seguente parola e il suo iperonimo, fornire una definizione nella tua lingua");
		
		word = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		hypernym = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		hWord = hidden("hWord");
		hHypernym = hidden("hHypernym");
		
		$.getJSON(REST_URL, "task=DEFINITION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sHypernym = json.$get("hypernym");
			$(word).text("Parola: "+sWord);
			$(hypernym).text("Iperonimo: "+sHypernym);
			$(hWord).attr("value", sWord);
			$(hHypernym).attr("value", sHypernym);
			return null;
		});
		
		definition = new TextArea.TextAreaBuilder()
				.setPlaceholder("Inserisci qui la tua risposta...")
				.setClassName("form-control")
				.setName("definition")
				.build();
		
		divWordHypernym = new Div.DivBuilder()
				.setClassName("form-group")
				.append(word, hypernym)
				.build();
		
		divText = new Div.DivBuilder()
				.setClassName("form-group")
				.append(divWordHypernym, definition)
				.css("margin-left", "15px")
				.css("margin-right", "15px")
				.build();
		
		createForm(SERVLET_URL, divText, hWord, hHypernym);
	}
	
	public static void main(String[] args)
	{
		new DefinitionAnnotation();
	}
}

