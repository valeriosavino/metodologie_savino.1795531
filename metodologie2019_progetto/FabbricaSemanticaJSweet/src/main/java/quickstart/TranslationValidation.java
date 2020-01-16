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

public class TranslationValidation extends BasePage
{
	private HTMLLabelElement l1;
	private HTMLLabelElement word;
	private HTMLLabelElement description;
	private List<HTMLInputElement> checks;
	private List<HTMLLabelElement> lChecks;
	private List<HTMLDivElement> divChecks;
	private HTMLInputElement hWord;
	private HTMLInputElement hDescription;
	private HTMLDivElement divCheckBox;
	
	private static final String SERVLET_URL = "translationValidation.jsp";
	
	private TranslationValidation()
	{
		super();
		
		l1 = new Label.LabelBuilder()
				.setTextContent("Data la seguente parola e la sua definizione, scegliere la miglior traduzione")
				.setClassName("form-control-plaintext")
				.setAttribute("style", "font-weight:bold")
				.build();
		
		appendContainer(l1);
		
		word = new Label.LabelBuilder()
				.setClassName("form-control-plaintext")
				.build();
		
		hWord = hidden("hWord");
		
		description = new Label.LabelBuilder()
				.setClassName("form-control-plaintext")
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
			$(word).text(sWord);
			$(hWord).attr("value", sWord);
			$(description).text(sDescription);
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
				.append((HTMLElement[])(divChecks.toArray()))
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