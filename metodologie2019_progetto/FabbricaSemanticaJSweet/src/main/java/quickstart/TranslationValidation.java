package quickstart;

import static def.jquery.Globals.$;

import java.util.ArrayList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
/**
 * Classe per creazione della pagina translationValidation.html
 * @author Savino
 *
 */
public class TranslationValidation extends BasePage
{
	/**
	 * Label per la parola fornita
	 */
	private HTMLLabelElement word;
	/**
	 * Label per la descrizione fornita
	 */
	private HTMLLabelElement description;
	/**
	 * Lista di checkBox
	 */
	private List<HTMLInputElement> checks;
	/**
	 * Lista di label per le checkbox
	 */
	private List<HTMLLabelElement> lChecks;
	/**
	 * Lista di contenitori per le checkbox
	 */
	private List<HTMLDivElement> divChecks;
	/**
	 * Campo nascosto per la word
	 */
	private HTMLInputElement hWord;
	/**
	 * Campo nascosto per la description
	 */
	private HTMLInputElement hDescription;
	/**
	 * Contenitore di tutti i contenitori per le checkbox
	 */
	private HTMLDivElement divCheckBox;
	
	private static final String SERVLET_URL = "translationValidation.jsp";
	
	private TranslationValidation()
	{
		super("Data la seguente parola e la sua definizione, scegliere la miglior traduzione");
		
		word = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		hWord = hidden("hWord");
		
		description = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		hDescription = hidden("hDescription");
		
		checks = new ArrayList<>();
		lChecks = new ArrayList<>();
		divChecks = new ArrayList<>();
		for(int i=0; i<5; i++)
			createCheckForLists("check"+i);
	
		
		$.getJSON(REST_URL, "task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("description");
			String[] translations = json.$get("translations");
			$(word).text("Parola: "+sWord);
			$(hWord).attr("value", sWord);
			$(description).text("Descrizione: "+sDescription);
			$(hDescription).attr("value", sDescription);
			for(int i=0; i<checks.size()-1; i++)
			{
				$(checks.get(i)).attr("value", translations[i]);
				$(lChecks.get(i)).text(translations[i]);
			}
			$(checks.get(checks.size()-1)).attr("value", "Nessuna delle precedenti");
			$(lChecks.get(lChecks.size()-1)).text("Nessuna delle precedenti");
			return null;
		});
		
		divCheckBox = new Div.DivBuilder()
				.setClassName("form-check")
				.append((HTMLElement[])(divChecks.toArray()))
				.css("margin-top", "10px")
				.css("margin-right", "15px")
				.append(hWord, hDescription)
				.build();
		
		createForm(SERVLET_URL, word, description, divCheckBox);
	}
	
	/**
	 * Crea una checkbox con la sua label e li formatta all'interno di un div
	 * @param id
	 */
	protected void createCheckForLists(String id)
	{	
		HTMLInputElement check = new Input.InputBuilder()
				.setType("checkbox")
				.setName("check[]")
				.setId(id)
				.build();
		
		HTMLLabelElement lCheck = new Label.LabelBuilder()
				.setHTMLFor(id)
				.setClassName("form-control")
				.css("height", "100%")
				.build();
		
		HTMLDivElement inputGroupText = new Div.DivBuilder()
				.setClassName("input-group-text")
				.append(check)
				.build();
		
		HTMLDivElement prepend = new Div.DivBuilder()
				.setClassName("input-group-prepend")
				.append(inputGroupText)
				.build();
		
		HTMLDivElement divCheck = new Div.DivBuilder()
				.setClassName("input-group mb-3")
				.append(prepend)
				.append(lCheck)
				.build();
		
		checks.add(check);
		lChecks.add(lCheck);
		divChecks.add(divCheck);
	}
	
	public static void main(String[] args)
	{
		new TranslationValidation();
	}
}