package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Div
 * @author Savino
 *
 */
public class Div 
{
	private Div() {}
	
	/**
	 * Costruisce il componente div
	 * @author Savino
	 *
	 */
	public static class DivBuilder extends Builder<HTMLDivElement>
	{
		private HTMLDivElement div;
		
		/**
		 * Crea l'elemento div
		 */
		public DivBuilder()
		{
			div = document.createElement(StringTypes.div);
		}
		
		/**
		 * Assegna l'allineamento del div all'interno della pagina 
		 * @param align posizione nella pagina
		 * @return oggetto builder
		 */
		public DivBuilder setAlign(String align)
		{
			div.align = align;
			return this;
		}
		
		/**
		 * Permette di aggiungere componenti all'interno del div
		 * @param e elementi da aggiungere
		 * @return oggetto builder
		 */
		public DivBuilder append(HTMLElement... e)
		{
			$(div).append(e);
			return this;
		}
		
		/**
		 * Assegna degli attributi al div
		 * @param name nome dell'attributo
		 * @param value valore dell'attributo
		 * @return
		 */
		public DivBuilder setAttribute(String name, String value)
		{
			div.setAttribute(name, value);
			return this;
		}
		
		@Override
		public DivBuilder css(String property, String value)
		{
			$(div).css(property, value);
			return this;
		}
		
		@Override
		public DivBuilder setClassName(String className)
		{
			div.className = className;
			return this;
		}
		
		@Override
		public HTMLDivElement build()
		{
			return div;
		}
	}
}
