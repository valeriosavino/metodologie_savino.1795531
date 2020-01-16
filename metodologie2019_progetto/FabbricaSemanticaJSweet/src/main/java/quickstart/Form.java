package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import java.util.function.Function;

import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Form
 * @author Savino
 *
 */
public class Form 
{
	private Form() {}
	
	/**
	 * Classe per costruire l'elemento Form
	 * @author Savino
	 *
	 */
	public static class FormBuilder extends Builder<HTMLFormElement>
	{
		private HTMLFormElement form;
		
		public FormBuilder()
		{
			form = document.createElement(StringTypes.form);
		}

		/**
		 * Assegna l'indirizzo della servlet al form
		 * @param action indirizzo della servlet
		 * @return oggetto builder
		 */
		public FormBuilder setAction(String action)
		{
			form.action = action;
			return this;
		}
		
		/**
		 * Assegna il metodo di invio dei dati al server
		 * @param method metodo invio
		 * @return oggetto builder
		 */
		public FormBuilder setMethod(String method)
		{
			form.method = method;
			return this;
		}
		
		/**
		 * Assegna una function per il controllo campi del form 
		 * @param f Function
		 * @return oggetto builder
		 */
		public FormBuilder onSubmit(Function<def.dom.Event, Object> f)
		{
			form.onsubmit = f;
			return this;
		}
		
		/**
		 * Aggiunge elementi all'interno del form
		 * @param e elementi da aggiungere
		 * @return oggetto builder
		 */
		public FormBuilder append(HTMLElement... e)
		{
			$(form).append(e);
			return this;
		}
		
		@Override
		public Builder<HTMLFormElement> css(String property, String value) 
		{
			$(form).css(property, value);
			return this;
		}
		
		@Override
		public FormBuilder setClassName(String className) 
		{
			form.className = className;
			return this;
		}
		
		@Override
		public HTMLFormElement build()
		{
			return form;
		}
	}
}
