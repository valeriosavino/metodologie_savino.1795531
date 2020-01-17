package quickstart;

import static def.dom.Globals.window;

import def.dom.HTMLDivElement;
import def.dom.HTMLImageElement;


/**
 * Crea la pagina iniziale del sito FabbricaSemantica
 * @author Savino
 *
 */
public class Home extends BasePage
{
	/**
	 * Contiene il logo di FabbricaSemantica
	 */
	private HTMLImageElement fs;
	/**
	 * Contiene il logo di avvio di FabbricaSemantica
	 */
	private HTMLImageElement start;
	/**
	 * Contenitore del logo
	 */
	private HTMLDivElement divImg1;
	/**
	 * Contenitore dello start
	 */
	private HTMLDivElement divImg2;
	
	/**
	 * Contiene l'indirizzo di TranslationAnnotation
	 */
	private static final String TASK_URL = "translationAnnotation.html";
	
	/**
	 * Costruttore
	 */
	private Home()
	{	
		super();
		
		fs = new Image.ImageBuilder()
				.src("logo_fs.png")
				.setAttribute("style", "width:80%;height:60%;")
				.build();
		
		start = new Image.ImageBuilder()
				.src("logo_play.png")
				.onClick(click -> window.location.href = TASK_URL)
				.setAttribute("style", "width:200px;height:200px;")
				.setClassName("center")
				.build();
		
		divImg1 = new Div.DivBuilder()
				.setAlign("center")
				.append(fs)
				.build();
		
		divImg2 = new Div.DivBuilder()
				.setAlign("center")
				.append(start)
				.build();
		
		appendContainer(divImg1, divImg2);
	}
	
	public static void main(String[] args)
	{
		new Home();
	}
}
