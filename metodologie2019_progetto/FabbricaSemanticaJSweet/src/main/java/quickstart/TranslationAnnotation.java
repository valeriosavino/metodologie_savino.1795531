package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
/**
 * Classe per la pagina translationAnnotation.html
 * @author Savino
 *
 */
public class TranslationAnnotation extends BasePage
{
	/**
	 * Indirizzo della servlet per transationAnnotation
	 */
	private static final String SERVLET_URL = "translationAnnotation.jsp";
	
	/**
	 * Label per la parola fornita
	 */
	private HTMLLabelElement word;
	/**
	 * Label per la descrizione fornita
	 */
	private HTMLLabelElement description;
	/**
	 * TextArea per inserire la traduzione
	 */
	private HTMLTextAreaElement translation;
	/**
	 * Contenitore per la textarea
	 */
	private HTMLDivElement divText;
	/**
	 * Input nascosto per la word
	 */
	private HTMLInputElement hWord;
	/**
	 * Input nascosto per la description
	 */
	private HTMLInputElement hDescription;
	/**
	 * Contenitore per word e description
	 */
	private HTMLDivElement divWordDescr;
	
	/**
	 * Costruttore
	 */
	private TranslationAnnotation()
	{
		super("Data la seguente parola e definizione in inglese, fornire la traduzione nella tua lingua madre");
		
		word = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		description = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		hWord = hidden("hWord");
		hDescription = hidden("hDescription");
		
		$.getJSON(REST_URL, "task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description");
			$(word).text("Parola: "+sWord);
			$(hWord).attr("value", sWord);
			$(description).text("Descrizione: "+sDescription);
			$(hDescription).attr("value", sDescription);
			return null;
		});
		
		translation = new TextArea.TextAreaBuilder()
				.setName("translation")
				.setClassName("form-control")
				.setPlaceholder("Inserisci qui la tua risposta...")
				.build();
		
		divWordDescr = new Div.DivBuilder()
				.setClassName("form-group")
				.append(word, description)
				.build();
		
		divText = new Div.DivBuilder()
				.setClassName("form-group")
				.append(divWordDescr, translation)
				.css("margin-left", "15px")
				.css("margin-right", "15px")
				.build();
		
		createForm(SERVLET_URL, divText, hWord, hDescription);	
	}
	
	public static void main(String[] args)
	{
		new TranslationAnnotation();
	}
}
