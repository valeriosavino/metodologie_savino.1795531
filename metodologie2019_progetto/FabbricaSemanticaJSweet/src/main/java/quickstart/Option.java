package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLOptionElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Option
 * @author Savino
 *
 */
public class Option 
{
	private Option() {}
	
	/**
	 * Classe per costruire l'elemento Option
	 * @author Savino
	 *
	 */
	public static class OptionBuilder extends Builder<HTMLOptionElement>
	{
		private HTMLOptionElement option;
		
		/**
		 * Crea l'elemento option
		 */
		public OptionBuilder() 
		{
			option = document.createElement(StringTypes.option);
		}
		
		/**
		 * Asssegna un valore alla option
		 * @param value valore dell'option
		 * @return oggetto builder
		 */
		public OptionBuilder setValue(String value)
		{
			option.value = value;
			return this;
		}
		
		/**
		 * Assegna un testo da visualizzare nell'option
		 * @param innerText testo dell'option
		 * @return oggetto builder
		 */
		public OptionBuilder setInnerText(String innerText)
		{
			option.innerText = innerText;
			return this;
		}
		
		/**
		 * Imposta l'option come selezionata
		 * @return oggetto builder
		 */
		public OptionBuilder selected()
		{
			option.selected = true;
			return this;
		}
		
		/**
		 * Imposta l'option come disabilitata
		 * @return oggetto builder
		 */
		public OptionBuilder disabled() 
		{
			option.disabled = true;
			return this;
		}
		
		/**
		 * Imposta l'option come option nascosta
		 * @return oggetto builder
		 */
		public OptionBuilder hidden() 
		{
			option.hidden = true;
			return this;
		}
		
		@Override
		public OptionBuilder setClassName(String className)
		{
			option.className = className;
			return this;
		}
		
		@Override
		public OptionBuilder css(String property, String value) 
		{
			$(option).css(property, value);
			return this;
		}
		
		@Override
		public HTMLOptionElement build()
		{
			return option;
		}
	}
}
