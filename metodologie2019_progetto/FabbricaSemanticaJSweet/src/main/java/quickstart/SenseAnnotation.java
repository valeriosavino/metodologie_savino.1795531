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
 * Classe che crea la pagina SenseAnnotation
 * @author Savino
 *
 */
public class SenseAnnotation extends BasePage
{
	/**
	 * ?
	 */
	private HTMLLabelElement l1;
	/**
	 * Label per la parola fornita
	 */
	private HTMLLabelElement word;
	/**
	 * ?
	 */
	private HTMLLabelElement l2;
	/**
	 * Label per la descrizione fornita
	 */
	private HTMLLabelElement description;
	/**
	 * Lista di checkbox dei sensi
	 */
	private List<HTMLInputElement> checks;
	/**
	 * Lista di label per le checkbox dei sensi
	 */
	private List<HTMLLabelElement> lChecks;
	/**
	 * Lista di contenitori per le checkbox
	 */
	private List<HTMLDivElement> divChecks;
	/**
	 * Contenitore per le label per titolo
	 */
	private HTMLDivElement divWord;
	/**
	 * Contenitore per tutti i contenitori di checkBox
	 */
	private HTMLDivElement checkContainer;
	/**
	 * Campo nascosto per word
	 */
	private HTMLInputElement hWord;
	/**
	 * Campo nascosto per description
	 */
	private HTMLInputElement hDescription;
	
	/**
	 * Indirizzo per la servlet di senseAnnotation
	 */
	private static final String SERVLET_URL = "senseAnnotation.jsp";
	
	/**
	 * Costruttore
	 */
	private SenseAnnotation()
	{
		super();
				
		l1 = new Label.LabelBuilder()
				.setTextContent("Seleziona il significato corretto della parola \"")
				.setAttribute("style", "font-weight:bold")
				.build();
		
		word = new Label.LabelBuilder()
				.setAttribute("style", "font-weight:bold")
				.build();
		
		l2 = new Label.LabelBuilder()
				.setTextContent("\" nella seguente frase")
				.setAttribute("style", "font-weight:bold")
				.build();
		
		description = new Label.LabelBuilder()
				.build();
		
		hWord = hidden("hWord");
		hDescription = hidden("hDescription");
		
		checks = new ArrayList<>();
		lChecks = new ArrayList<>();
		divChecks = new ArrayList<>();
		createCheck("check1");
		createCheck("check2");
		createCheck("check3");
		createCheck("check4");
			
		$.getJSON(REST_URL, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("description");
			String[] senses = json.$get("senses");
			$(word).text(sWord);
			$(hWord).attr("value", sWord);
			$(description).text(sDescription);
			$(hDescription).attr("value", sDescription);
			for(int i=0; i<checks.size(); i++)
			{
				$(lChecks.get(i)).text(senses[i]);
				$(checks.get(i)).attr("value", senses[i]);
			}
			return null;
		});
		
		divWord = new Div.DivBuilder()
				.setClassName("form-inline")
				.append(l1)
				.append(word)
				.append(l2)
				.build();
		
		appendContainer(divWord, description);
		
		checkContainer = new Div.DivBuilder()
				.setClassName("form-check")
				.append((HTMLElement[]) (divChecks.toArray()))
				.build();
		
		createForm(SERVLET_URL, hWord, hDescription, checkContainer);
	}
	
	/**
	 * Crea una checkbox con la sua label e li formatta all'interno di un div
	 * @param id
	 */
	protected void createCheck(String id)
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
		new SenseAnnotation();
	}
}
