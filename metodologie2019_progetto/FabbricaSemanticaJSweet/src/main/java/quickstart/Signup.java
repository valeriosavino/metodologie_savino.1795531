package quickstart;

import static def.dom.Globals.alert;
import static def.dom.Globals.document;

import java.util.ArrayList;
import java.util.List;

import def.dom.Event;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLSelectElement;
import def.dom.HTMLSpanElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLParagraphElement;
import def.dom.HTMLInputElement;

/**
 * Crea la pagina per permettere l'iscrizione al sito FabbricaSemantica
 * @author Savino
 *
 */
public class Signup extends BasePageUser
{
	/**
	 * Indirizzo servlet di Signup
	 */
	private static final String SERVLET_URL = "signup.jsp";
	
	/**
	 * Label per la conferma password
	 */
	private HTMLLabelElement labelPassword2;
	/**
	 * Campo di testo per la conferma della password
	 */
	private HTMLInputElement password2;
	/**
	 * Label per le lingue
	 */
	private HTMLLabelElement labelLingue;
	/**
	 * Lista di lingue disponibili nel sistema
	 */
	private List<HTMLInputElement> lingue;
	/**
	 * Lista delle label delle lingue disponibili nel sistema
	 */
	private List<HTMLLabelElement> labelForLingue;
	/**
	 * Lista di contenitori delle lingue disponibili nel sistema
	 */
	private List<HTMLDivElement> divLingue;
	/**
	 * Contenitore per le checkBox
	 */
	private HTMLDivElement divCheckBox;
	/**
	 * Label per la casella delle altre lingue
	 */
	private HTMLLabelElement labelAltreLingue;
	/**
	 * Casella per inserire altre lingue
	 */
	private HTMLInputElement altreLingue;
	/**
	 * Contenitore per le altre lingue
	 */
	private HTMLDivElement divAltreLingue;
	/**
	 * Label per il livello della lingua parlata
	 */
	private HTMLLabelElement labelLivello;
	/**
	 * Span per il livello
	 */
	private HTMLSpanElement span;
	/**
	 * Select per il livello della lingua
	 */
	private HTMLSelectElement livello;
	/**
	 * Lista di opzioni per livello lingua
	 */
	private List<HTMLOptionElement> options;
	/**
	 * Pulsante di conferma di iscrizione
	 */
	private HTMLInputElement signup;
	/**
	 * Conenitore per conferma password
	 */
	private HTMLDivElement divPassword2;
	/**
	 * Contenitore per email e password
	 */
	private HTMLDivElement divEmailPassword;
	/**
	 * Contenitore per la span
	 */
	private HTMLDivElement divSpan;
	/**
	 * Contenitore per livello lingua
	 */
	private HTMLDivElement divLivello;
	/**
	 * Contenitore per bottone signup
	 */
	private HTMLDivElement divSignup;
	/**
	 * Collegamento alla pagina di login
	 */
	private HTMLAnchorElement login;
	/**
	 * Paragrafo per collegamento alla pagina di login
	 */
	private HTMLParagraphElement plogin;
	/**
	 * Form della pagina
	 */
	private HTMLFormElement form;
	/**
	 * Costruttore
	 */
	private Signup()
	{		
		labelPassword2 = new Label.LabelBuilder()
				.setTextContent("Conferma Password (*): ")
				.setClassName("form-control-plaintext")
				.setAttribute("style", "font-weight:bold")
				.build();
				
		password2 = new Input.InputBuilder()
				.setType("password")
				.setClassName("form-control")
				.setName("input_conf_pass")
				.setId("input_conf_pass")
				.setSize(32)
				.required()
				.build();
		
		labelLingue = new Label.LabelBuilder()
				.setTextContent("Lingue Parlate (*): ")
				.setClassName("form-control-plaintext")
				.setAttribute("style", "font-weight:bold")
				.build();
		
		lingue = new ArrayList<>();
		labelForLingue = new ArrayList<>();
		divLingue = new ArrayList<>();
		addLingue("Italiano", 1);
		addLingue("Inglese" , 2);
		
		labelAltreLingue = new Label.LabelBuilder()
				.setTextContent("Altre lingue parlate: ")
				.setAttribute("style", "font-weight:bold")
				.build();
		
		altreLingue = new Input.InputBuilder()
				.setType("text")
				.setPlaceholder("Lingua1, Lingua2, ...")
				.setName("altre_lingue")
				.setClassName("form-control")
				.build();
		
		divAltreLingue = new Div.DivBuilder()
				.setClassName("form-group")
				.append(labelAltreLingue, altreLingue)
				.build();
		
		labelLivello = new Label.LabelBuilder()
				.setTextContent("Livello altre lingue: ")
				.setAttribute("style", "font-weight:bold")
				.build();
		
		options = new ArrayList<>();
		addOptions("A1");
		addOptions("A2");
		addOptions("B1");
		addOptions("B2");
		addOptions("C1");
		addOptions("C2");
		
		livello = new Select.SelectBuilder()
				.setName("livello")
				.add((HTMLOptionElement[]) options.toArray())
				.setClassName("form-control")
				.build();
		
		signup = new Input.InputBuilder()
				.setType("submit")
				.setName("signup")
				.setValue("Registrati!")
				.setClassName("btn btn-default col-md-12")
				.build();
		
		divEmailPassword = getDivEmailPassword();
		
		divPassword2 = new Div.DivBuilder()
				.setClassName("form-group")
				.append(labelPassword2, password2)
				.build();
		
		divCheckBox = new Div.DivBuilder()
				.setClassName("form-group")
				.append(labelLingue)
				.append((HTMLElement[])(divLingue.toArray()))
				.build();
	
		span = new Span.SpanBuilder()
				.setClassName("input-group-addon")
				.setText("Livello")
				.build();
		
		divSpan = new Div.DivBuilder()
				.setClassName("input-group")
				.append(span, livello)
				.build();
		
		divLivello = new Div.DivBuilder()
				.setClassName("form-group")
				.append(labelLivello, divSpan)
				.build();				
		
		divSignup = new Div.DivBuilder()
				.setClassName("form-group")
				.append(signup)
				.build();
	
		login = new Anchor.AnchorBuilder()
				.setHref("login.html")
				.setClassName("ml-2")
				.setText("Hai già un account? Accedi!")
				.build();		
		
		plogin = new Paragraph.ParagraphBuilder()
				.setClassName("text-center")
				.append(login)
				.build();
		
		form = new Form.FormBuilder()
				.setAction(SERVLET_URL)
				.setMethod("POST")
				.append(divEmailPassword, divPassword2, divCheckBox, divAltreLingue, divLivello, divSignup, plogin)
				.onSubmit(Signup::onSubmit)
				.build();
		
		createPanelForm(form);
	}
	
	/**
	 * Crea e aggiunge un'opzione alla lista di opzioni per il livello lingua
	 * @param value valore dell'opzione
	 */
	public void addOptions(String value)
	{
		HTMLOptionElement op = new Option.OptionBuilder()
				.setValue(value)
				.setInnerText(value)
				.build();
		
		options.add(op);
	}
	
	/**
	 * Crea e formatta una checkbox per le lingue, in seguito la aggiunge alla lista di checkbox 
	 * @param value valore della checkbox
	 */
	public void addLingue(String value, int numeroCheck)
	{
		HTMLInputElement check = new Input.InputBuilder()
					.setType("checkbox")
					.setName("check[]")
					.setValue(value)
					.setClassName("form-check-input")
					.setId("check"+numeroCheck)
					.build();
		
		HTMLLabelElement labelForCheck = new Label.LabelBuilder()
				.setTextContent(value)
				.setClassName("form-check-label")
				.setHTMLFor(value)
				.build();
		
		HTMLDivElement divCheck = new Div.DivBuilder()
				.setClassName("form-check")
				.append(check, labelForCheck)
				.build();
		
		lingue.add(check);
		labelForLingue.add(labelForCheck);
		divLingue.add(divCheck);
	}
	
	/**
	 * Controlla nel form al momento dell'invio se la email è scritta in modo corretto
	 * e se almeno una checkbox per la lingua è stata selezionata
	 * @param e evento che attiva l'onSubmit
	 * @return false se il form non è corretto, true altrimenti
	 */
	public static boolean onSubmit(Event e)
	{
		boolean send = true;
		
		String email = ((HTMLInputElement) document.getElementById("input_email")).value;
		if(!email.substring(email.indexOf("@")+1).contains("."))
		{
			alert("L'email inserita non è scritta in modo corretto");
			send = false;
		}
	
		HTMLInputElement check;
		String lingue = "";
		for(int i=1; i<=2; i++)
		{
			check = (HTMLInputElement) document.getElementById("check"+i);
			if(check.checked)
				lingue = lingue+check.value;
		}
		if(lingue.equals(""))
		{
			alert("Devi selezionare almeno una lingua");
			send = false;
		}
		
		return send;
	}
	
	public static void main(String[] args)
	{		
		new Signup();
	}
}