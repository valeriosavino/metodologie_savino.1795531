package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLTextAreaElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto TextArea
 * @author Savino
 *
 */
public class TextArea 
{
	private TextArea() {}
	
	/**
	 * Classe per costruire elemento TextArea
	 * @author Savino
	 *
	 */
	public static class TextAreaBuilder extends Builder<HTMLTextAreaElement>
	{
		private HTMLTextAreaElement ta;
		
		/**
		 * Crea l'oggetto textarea
		 */
		public TextAreaBuilder()
		{
			ta = document.createElement(StringTypes.textarea);
		}

		/**
		 * Assegna un nome alla textArea
		 * @param name nome della textarea
		 * @return oggetto builder
		 */
		public TextAreaBuilder setName(String name)
		{
			ta.name = name;
			return this;
		}
		
		/**
		 * Assegna un testo all'interno della textarea
		 * @param placeholder testo nella textarea
		 * @return oggetto builder
		 */
		public TextAreaBuilder setPlaceholder(String placeholder)
		{
			ta.placeholder = placeholder;
			return this;
		}
		
		@Override
		public TextAreaBuilder setClassName(String className)
		{
			ta.className = className;
			return this;
		}
		
		@Override
		public TextAreaBuilder css(String property, String value) 
		{
			$(ta).css(property, value);
			return this;
		}
		
		@Override
		public HTMLTextAreaElement build()
		{
			return ta;
		}
	}
}
