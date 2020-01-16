package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLElement;
import def.dom.HTMLParagraphElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Paragraph
 * @author Savino
 *
 */
public class Paragraph 
{
	private Paragraph() {}
	
	/**
	 * Classe per costruire l'elemento Paragraph
	 * @author Savino
	 *
	 */
	public static class ParagraphBuilder extends Builder<HTMLParagraphElement>
	{
		private HTMLParagraphElement p;
		
		/**
		 * Crea l'elemento paragraph
		 */
		public ParagraphBuilder()
		{
			p = document.createElement(StringTypes.p);
		}
		
		/**
		 * Inserisce un componente all'interno del paragraph
		 * @param e elemento da inserire
		 * @return oggetto builder
		 */
		public ParagraphBuilder append(HTMLElement e)
		{
			$(p).append(e);
			return this;
		}
		
		@Override
		public ParagraphBuilder setClassName(String className) 
		{
			p.className = className;
			return this;
		}
		
		@Override
		public ParagraphBuilder css(String property, String value) 
		{
			$(p).css(property, value);
			return this;
		}
		
		@Override
		public HTMLParagraphElement build()
		{
			return p;
		}
	}
}
