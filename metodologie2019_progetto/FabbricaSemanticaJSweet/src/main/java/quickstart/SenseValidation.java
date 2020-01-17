package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe per creazione della pagina senseValidation.html
 * @author Savino
 *
 */
public class SenseValidation extends BasePage
{
	/**
	 * Label per parola fornita dal server
	 */
	private HTMLLabelElement word;
	/**
	 * Label per esempio fornito dal server
	 */
	private HTMLLabelElement example;
	/**
	 * Label per senso fornito dal server
	 */
	private HTMLLabelElement sense;
	/**
	 * Pulsante radio per SI
	 */
	private HTMLInputElement si;
	/**
	 * Pulsante radio per NO
	 */
	private HTMLInputElement no;
	/**
	 * Label che rappresenta il SI
	 */
	private HTMLLabelElement lSi;
	/**
	 * Label che rappresenta il NO
	 */
	private HTMLLabelElement lNo;
	/**
	 * Contenitore per formattazione bottone SI
	 */
	private HTMLDivElement divRadioSi;
	/**
	 * Contenitore per formattazione bottone NO
	 */
	private HTMLDivElement divRadioNo;
	/**
	 * Contenitore per formattazione bottoni radio
	 */
	private HTMLDivElement divRadio;
	/**
	 * Campo nascosto per parola
	 */
	private HTMLInputElement hWord;
	/**
	 * Campo nascosto per esempio
	 */
	private HTMLInputElement hExample;
	/**
	 * Campo nascosto per senso
	 */
	private HTMLInputElement hSense;
	/**
	 * Indirizzo della servlet per SenseValidation
	 */
	private static final String SERVLET_URL = "senseValidation.jsp";
	
	/**
	 * Costruttore
	 */
 	private SenseValidation()
 	{
 		super("Data la seguente parola e frase in inglese, verificare se il senso fornito è appropriato");
		
		word = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		example = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		sense = new Label.LabelBuilder()
				.css("display", "block")
				.css("text-align", "center")
				.build();
		
		si = new Input.InputBuilder()
				.setClassName("form-check-input")
				.setType("radio")
				.setName("radio")
				.setId("si")
				.setValue("si")
				.build();
		
		lSi = new Label.LabelBuilder()
				.setClassName("form-check-label")
				.setHTMLFor("si")
				.setTextContent("SI")
				.build();
		
		no = new Input.InputBuilder()
				.setClassName("form-check-input")
				.setType("radio")
				.setName("radio")
				.setId("no")
				.setValue("no")
				.build();
		
		lNo = new Label.LabelBuilder()
				.setClassName("form-check-label")
				.setHTMLFor("si")
				.setTextContent("NO")
				.build();
		
		hWord = hidden("hWord");
		hExample = hidden("hExample");
		hSense = hidden("hSense");
		
		$.getJSON(REST_URL, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sExample = json.$get("example");
			String sSense = json.$get("sense");
			$(word).text("Parola: "+sWord);
			$(example).text("Esempio: "+sExample);
			$(sense).text("Senso: "+sSense);
			$(hWord).attr("value", sWord);
			$(hExample).attr("value", sExample);
			$(hSense).attr("value", sSense);
			return null;
		});
		
		divRadioSi = new Div.DivBuilder()
				.setClassName("form-check")
				.append(si, lSi)
				.build();
		
		divRadioNo = new Div.DivBuilder()
				.setClassName("form-check")
				.append(no, lNo)
				.build();

		divRadio = new Div.DivBuilder()
				.setClassName("form-check form-check-inline")
				.append(divRadioSi, divRadioNo)
				.css("margin", "auto")
				.build();
		
		createForm(SERVLET_URL, word, example, sense, divRadio, hWord, hExample, hSense);
		
 	}
	public static void main(String[] args)
	{
		new SenseValidation();
	}
}