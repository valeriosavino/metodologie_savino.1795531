package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLSpanElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Span
 * @author Savino
 *
 */
public class Span
{
	private Span() {} 
	
	/**
	 * Classe su cui si vuole costruire elemento span
	 * @author Savino
	 *
	 */
	public static class SpanBuilder extends Builder<HTMLSpanElement>
	{
		private HTMLSpanElement span;
		
		/**
		 * Crea l'elemento span
		 */
		public SpanBuilder()
		{
			span = document.createElement(StringTypes.span);
		}
		
		/**
		 * Assegna un testo allo span
		 * @param text testo dello span
		 * @return oggetto builder
		 */
		public SpanBuilder setText(String text)
		{
			span.innerText = text;
			return this;
		}
		
		@Override
		public SpanBuilder setClassName(String className) 
		{
			span.className = className;
			return this;
		}
		
		@Override
		public SpanBuilder css(String property, String value)
		{
			$(span).css(property, value);
			return this;
		}

		@Override
		public HTMLSpanElement build() 
		{
			return span;
		}
		
	}
}
