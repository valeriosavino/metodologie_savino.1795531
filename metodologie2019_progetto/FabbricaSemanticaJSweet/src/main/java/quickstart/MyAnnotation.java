package quickstart;

import static def.dom.Globals.document;
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
 * Classe per pagina myAnnotation.html
 * @author Savino
 *
 */
public class MyAnnotation extends BasePage
{
	/**
	 * Indirizzo per servlet MyAnnotation
	 */
	private static final String SERVLET_URL = "myAnnotation.jsp";
	/**
	 * ?
	 */
	private HTMLLabelElement l1;
	/**
	 * Lista di parole fornite dal sistema
	 */
	private List<HTMLLabelElement> words;
	/**
	 * Lista di caselle dove i sinonimi selezionate compariranno
	 */
	private List<HTMLInputElement> selected;
	/**
	 * Lista di bottoni dei sinonimi
	 */
	private List<HTMLInputElement> synonyms;
	/**
	 * Lista di input nascosti per parole
	 */
	private List<HTMLInputElement> hWords;
	/**
	 * Lista di contenitori di ogni sezione di parole
	 */
	private List<HTMLDivElement> sections;
	/**
	 * Pulsante di reset
	 */
	private HTMLInputElement reset;
	/**
	 * Contenitore di ogni ?
	 */
	private HTMLDivElement divBox;
	
	/**
	 * Costruttore
	 */
	private MyAnnotation()
	{			
		super();
		
		l1 = new Label.LabelBuilder()
				.setTextContent("Scegli i sinonimi corretti per le seguenti parole")
				.setAttribute("style", "font-weight:bold")
				.setClassName("form-control-plaintext")
				.build();
		
		appendContainer(l1);
		
		words = new ArrayList<>();
		for(int i=0; i<3; i++)
			createWords();
		
		selected = new ArrayList<>();
		createSelected("selected1");
		createSelected("selected2");
		createSelected("selected3");
		
		synonyms = new ArrayList<>();
		createSynonym("synonym1", selected.get(0));
		createSynonym("synonym2", selected.get(0));
		createSynonym("synonym3", selected.get(0));
		createSynonym("synonym4", selected.get(1));
		createSynonym("synonym5", selected.get(1));
		createSynonym("synonym6", selected.get(1));
		createSynonym("synonym7", selected.get(2));
		createSynonym("synonym8", selected.get(2));
		createSynonym("synonym9", selected.get(2));
		
		sections = new ArrayList<>();
		createSection(words.get(0), selected.get(0), synonyms.get(0),synonyms.get(1),synonyms.get(2));
		createSection(words.get(1), selected.get(1), synonyms.get(3), synonyms.get(4), synonyms.get(5));
		createSection(words.get(2), selected.get(2), synonyms.get(6), synonyms.get(7), synonyms.get(8));
		
		hWords = new ArrayList<>();
		hWords.add(hidden("hWord1"));
		hWords.add(hidden("hWord2"));
		hWords.add(hidden("hWord3"));
		
		divBox = new Div.DivBuilder()
				.setClassName("card-deck mb-3 text-center")
				.append((HTMLElement[])(sections.toArray()))
				.append((HTMLElement[])(hWords.toArray()))
				.build();
		
		$.getJSON(REST_URL, "task=MY_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String[] words = json.$get("words");
			String[] synonyms = json.$get("synonyms");
			
			for(int i=0; i<this.words.size(); i++)
				$(this.words.get(i)).text(words[i]);
			for(int i=0; i<this.synonyms.size(); i++)
				$(this.synonyms.get(i)).attr("value", synonyms[i]);
			for(int i=0; i<this.hWords.size(); i++)
				$(hWords.get(i)).attr("value", words[i]);
			return null;
		});
		
		reset = new Input.InputBuilder()
				.setType("reset")
				.setClassName("btn btn-outline-danger")
				.build();
		
		createForm(SERVLET_URL, divBox, reset);
	}
	
	/**
	 * Crea i bottoni per i vari sinonimi
	 * @param id 
	 * @param field
	 */
	protected void createSynonym(String id, HTMLInputElement field)
	{
		HTMLInputElement synonym = new Input.InputBuilder()
				.setClassName("btn btn-outline-dark")
				.setType("button")
				.setId(id)
				.onClick(click -> buttonClick(id, field))
				.build();
		
		synonyms.add(synonym);
	}
	
	/**
	 * Crea le caselle di testo dove verranno inseriti i sinonimi
	 * @param name
	 */
	protected void createSelected(String name)
	{
		HTMLInputElement selected = new Input.InputBuilder()
				.setType("text")
				.setName(name)
				.readOnly()
				.build();
		
		this.selected.add(selected);
	}
	
	/**
	 * Crea le label per le words
	 */
	protected void createWords()
	{
		HTMLLabelElement word = new Label.LabelBuilder()
				.build();
		
		words.add(word);
	}
	
	/**
	 * Crea un contenitore per ogni sezione di parole
	 * @param word
	 * @param selected
	 * @param buttons
	 */
	protected void createSection(HTMLLabelElement word, HTMLInputElement selected, HTMLInputElement... buttons)
	{
		HTMLDivElement div = new Div.DivBuilder()
				.setClassName("card mb-4 shadow-sm")
				.append(word)
				.append(selected)
				.append(buttons)
				.build();
		
		sections.add(div);
	}
	/**
	 * Inserisce il valore del sinonimo selezionato nella casella di testo
	 * @param id
	 * @param field
	 * @return
	 */
	public static Object buttonClick(String id, HTMLInputElement field)
	{		
		field.value = ((HTMLInputElement) document.getElementById(id)).value;
		return null;
	}
	
	public static void main(String[] args)
	{
		new MyAnnotation();
	}
}