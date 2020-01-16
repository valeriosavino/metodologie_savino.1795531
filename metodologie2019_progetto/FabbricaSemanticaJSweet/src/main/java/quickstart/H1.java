package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLHeadingElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto H1
 * @author Savino
 *
 */
public class H1 
{
	private H1() {}
	
	/**
	 * Classe per costruire l'elemento H1
	 * @author Savino
	 *
	 */
	public static class HBuilder extends Builder<HTMLHeadingElement>
	{
		private HTMLHeadingElement h;
		
		/**
		 * Crea l'oggetto H1
		 */
		public HBuilder()
		{
			h = document.createElement(StringTypes.h1);
		}
		
		/**
		 * Modifica il contenuto testuale dell'h1
		 * @param text
		 * @return
		 */
		public HBuilder setText(String text)
		{
			h.innerText = text;
			return this;
		}
		
		/**
		 * Modifica la posizione del componente nella pagina
		 * @param align
		 * @return
		 */
		public HBuilder setAlign(String align) 
		{
			h.align = align;
			return this;
		}
		
		@Override
		public HBuilder setClassName(String className) 
		{
			h.className = className;
			return this;
		}

		@Override
		public HBuilder css(String property, String value) 
		{
			$(h).css(property, value);
			return this;
		}
		
		@Override
		public HTMLHeadingElement build()
		{
			return h;
		}		
	}
}
