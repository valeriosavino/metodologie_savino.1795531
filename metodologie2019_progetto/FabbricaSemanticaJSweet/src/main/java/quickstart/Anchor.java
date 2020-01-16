package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Anchor
 * @author Savino
 *
 */
public class Anchor 
{
	private Anchor() {}
	
	/**
	 * Classe per costruire l'elemento Anchor
	 * @author Savino
	 *
	 */
	public static class AnchorBuilder extends Builder<HTMLAnchorElement>
	{
		private HTMLAnchorElement a;
		
		/**
		 * Crea l'elemento anchor
		 */
		public AnchorBuilder()
		{
			a = document.createElement(StringTypes.a);
		}

		/**
		 * Assegna un indirizzo all'anchor
		 * @param href Stringa contenente indirizzo
		 * @return oggetto builder
		 */
		public AnchorBuilder setHref(String href)
		{
			a.href = href;
			return this;
		}

		/**
		 * Assegna un contenuto testuale all'anchor
		 * @param text il testo da visualizzare
		 * @return
		 */
		public AnchorBuilder setText(String text)
		{
			a.text = text;
			return this;
		}
		
		@Override
		public AnchorBuilder setClassName(String className) 
		{
			a.className = className;
			return this;
		}
		
		@Override
		public AnchorBuilder css(String property, String value) 
		{
			$(a).css(property, value);
			return this;
		}
		
		@Override
		public HTMLAnchorElement build()
		{
			return a;
		}
	}
}
