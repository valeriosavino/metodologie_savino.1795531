package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;
/**
 * Classe su cui si vuole costruire oggetto Label
 * @author Savino
 *
 */
public class Label 
{
	private Label() {}
	
	/**
	 * Classe per costruzione oggetto Label
	 * @author Savino
	 *
	 */
	public static class LabelBuilder extends Builder<HTMLLabelElement>
	{
		private HTMLLabelElement label;
		
		/**
		 * Costruisce l'elemento label
		 */
		public LabelBuilder()
		{
			label = document.createElement(StringTypes.label);
		}
		
		/**
		 * Assegna un testo alla label
		 * @param textContent testo della label
		 * @return oggetto builder
		 */
		public LabelBuilder setTextContent(String textContent)
		{
			label.textContent = textContent;
			return this;
		}
		
		/**
		 * Modifica un attributo della label
		 * @param name nome attributo
		 * @param value valore dell'attributo
		 * @return oggetto builder
		 */
		public LabelBuilder setAttribute(String name, String value)
		{
			label.setAttribute(name, value);
			return this;
		}
		
		/**
		 * Assegna il nome del componente a cui la label deve riferirsi
		 * @param HTMLFor nome del componente HTML
		 * @return oggetto builder
		 */
		public LabelBuilder setHTMLFor(String HTMLFor)
		{
			label.htmlFor = HTMLFor;
			return this;
		}
		
		@Override
		public LabelBuilder setClassName(String className)
		{
			label.className = className;
			return this;
		}
		
		@Override
		public LabelBuilder css(String property, String value) 
		{
			$(label).css(property, value);
			return this;
		}
		
		@Override
		public HTMLLabelElement build()
		{
			return label;
		}
	}

}
