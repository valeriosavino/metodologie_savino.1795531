package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;

/**
 * Classe astratta che fa da base per le pagine Login e Signup
 * @author Savino
 *
 */
abstract public class BasePageUser 
{	
	/**
	 * Crea un div contenente i campi email e password con le rispettive label
	 * @return Elemento div
	 */
	protected HTMLDivElement getDivEmailPassword()
	{	
		HTMLLabelElement labelEmail = new Label.LabelBuilder()
				.setTextContent("Email (*): ")
				.setClassName("form-control-plaintext")
				.setAttribute("style", "font-weight:bold")
				.build();
		
		HTMLInputElement email = new Input.InputBuilder()
				.setType("email")
				.setName("input_email")
				.setId("input_email")
				.setSize(20)
				.setClassName("form-control")
				.required()
				.build();
		
		HTMLDivElement divEmail = new Div.DivBuilder()
				.append(labelEmail, email)
				.setClassName("form-group")
				.build();
		
		HTMLLabelElement labelPassword = new Label.LabelBuilder()
				.setTextContent("Password (*): ")
				.setClassName("form-control-plaintext")
				.setAttribute("style", "font-weight:bold")
				.build();
				
		HTMLInputElement password = new Input.InputBuilder()
				.setType("password")
				.setName("input_pass")
				.setId("input_pass")
				.setSize(32)
				.setClassName("form-control")
				.required()
				.build();
		
		HTMLDivElement divPassword = new Div.DivBuilder()
				.append(labelPassword, password)
				.setClassName("form-group")
				.build();
		
		return new Div.DivBuilder()
				.append(divEmail, divPassword)
				.setClassName("form-group")
				.build();		
	}
	
	/**
	 * Formatta il form all'interno di un pannello
	 * @param servlet_url indirizzo della servlet a cui inviare i dati del form
	 * @param e elementi da inserire nel form
	 */
	protected void createPanelForm(HTMLFormElement form)
	{
		HTMLDivElement panelBody = new Div.DivBuilder()
				.setClassName("panel-body")
				.css("color", "#31708f")
				.css("background-color", "#d9edf7")
				.css("border", "1px	solid #bce8f1")
				.append(form)
				.build();
		
		HTMLLabelElement panelTitle = new Label.LabelBuilder()
				.setTextContent("Compila i campi")
				.setClassName("panel-title")
				.build();
		
		HTMLDivElement panelHealing = new Div.DivBuilder()
				.setClassName("panel-heading")
				.css("background-color", "#FFFFFF")
				.css("color", "#31708f")
				.css("background-color", "#D9EDF7")
				.css("border", "1px	solid #BCE8F1")
				.append(panelTitle)
				.build();
		
		HTMLDivElement panelDefault = new Div.DivBuilder()
				.setClassName("panel panel-default")
				.append(panelHealing, panelBody)
				.build();
		
		HTMLDivElement colMd4 = new Div.DivBuilder()
				.setClassName("col-md-4 col-md-offset-4")
				.append(panelDefault)
				.build();
		
		appendBody(colMd4);
	}
	
	/**
	 * Inserisce nel body gli elementi passati in input
	 * @param e elementi da inserire nel body
	 */
	private void appendBody(HTMLElement... e)
	{	
		HTMLHeadingElement title = new H1.HBuilder()
				.setText("BENVENUTO IN FABBRICA SEMANTICA")
				.setAlign("center")
				.css("font-weight", "bold")
				.css("font-size", "40px")
				.build();
		
		HTMLDivElement container = new Div.DivBuilder()
				.setClassName("container")
				.append(title)
				.append(e)
				.build();
				
		$("body").append(container);
	}
}
