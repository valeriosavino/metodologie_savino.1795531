package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class WordAnnotation extends BasePage
{
	private static final String SERVLET_URL = "wordAnnotation.jsp";
	private HTMLLabelElement title;
	private HTMLLabelElement description;
	private HTMLInputElement hDescription;
	private HTMLInputElement word;
	private HTMLDivElement splitDescription;
	private HTMLDivElement splitWord;
	private WordAnnotation()
	{
		super();
		
		title = new Label.LabelBuilder()
				.setTextContent("Data la seguente definizione, provare a indovinare il termine definito")
				.setClassName("form-control-plaintext")
				.setAttribute("style", "font-weight: bold") 
				.build();
		
		appendContainer(title);
		
		description = new Label.LabelBuilder()
				.setClassName("form-control-plaintext")
				.build();
		
		hDescription = hidden("hDescription");
		
		$.getJSON(REST_URL, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sDescription = json.$get("description");
			$(description).text(sDescription);
			$(hDescription).attr("value", sDescription);
			return null;
		});
		
		word = new Input.InputBuilder()
				.setType("text")
				.setClassName("form-control")
				.setName("word")
				.required()
				.build();
		
		splitDescription = new Div.DivBuilder()
				.setClassName("col")
				.append(description, hDescription)
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
