package quickstart;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
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
		
		createForm(SERVLET_URL, divEmailPassword, divLogin, psignup);
	}
	
	public static void main(String[] args)
	{
		new Login();
	}
}
