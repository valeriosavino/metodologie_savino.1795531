package quickstart;

import static def.dom.Globals.alert;
import static def.dom.Globals.document;

import def.dom.Event;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLParagraphElement;
import def.dom.HTMLInputElement;

/**
 * Crea la pagina per efettuare il login
 * @author Savino
 *
 */
public class Login extends BasePageUser
{
	/**
	 * Indirizzo della servlet per il login
	 */
	private static final String SERVLET_URL = "login.jsp";
	/**
	 * Bottone per effettuare il login
	 */
	private HTMLInputElement login;

	/**
	 * Contenitore per il bottone di login
	 */
	private HTMLDivElement divLogin;

	/**
	 * Contenitore per email e password
	 */
	private HTMLDivElement divEmailPassword;
	
	/**
	 * Link per la pagina signup
	 */
	private HTMLAnchorElement signup;
	
	/**
	 * Paragrafo per il collegamento alla pagina signup
	 */
	private HTMLParagraphElement psignup;
	
	/**
	 * Costruttore
	 */
	private Login()
	{			
		divEmailPassword = getDivEmailPassword();
		
		login = new Input.InputBuilder()
				.setType("submit")
				.setName("login")
				.setValue("Entra!")
				.setClassName("btn btn-default col-md-12")
				.build();
		
		divLogin = new Div.DivBuilder()
				.setClassName("form-group")
				.append(login)
				.build();
		
		signup = new Anchor.AnchorBuilder()
				.setHref("signup.html")
				.setClassName("ml-2")
				.setText("Non hai un account? Registrati!")
				.build();
		
		psignup = new Paragraph.ParagraphBuilder()
				.setClassName("text-center")
				.append(signup)
				.build();
		
		HTMLFormElement form = new Form.FormBuilder()
				.setAction(SERVLET_URL)
				.setMethod("POST")
				.append(divEmailPassword, divLogin, psignup)
				.onSubmit(Login::onSubmit)
				.build();	
		
		createPanelForm(form);
	}
	
	/**
	 * Controlla nel form al momento dell'invio se la email è scritta in modo corretto
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
		
		return send;
	}
	
	public static void main(String[] args)
	{
		new Login();
	}
}
