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
	private static final String SERVLET_URL = "translationAnnotation.jsp";
	private HTMLLabelElement l1;
	private HTMLLabelElement word;
	private HTMLLabelElement description;
	private HTMLTextAreaElement translation;
	private HTMLDivElement divText;
	private HTMLInputElement hWord;
	private HTMLInputElement hDescription;
	private HTMLDivElement divWordDescr;
	
	private TranslationAnnotation()
	{
		super();
		
		l1 = new Label.LabelBuilder()
				.setTextContent("Data la seguente parola e definizione in inglese, fornire la traduzione nella tua lingua madre")
				.setAttribute("style", "font-weight: bold")
				.setClassName("form-control-plaintext")
				.build();
		
		appendContainer(l1);
		
		word = new Label.LabelBuilder()
				.build();
		
		description = new Label.LabelBuilder()
				.css("display", "block")
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
				.build();
		
		createForm(SERVLET_URL, divText, hWord, hDescription);	
	}
	
	public static void main(String[] args)
	{
		new TranslationAnnotation();
	}
}
