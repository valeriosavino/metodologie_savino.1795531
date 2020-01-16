package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLOptionElement;
import def.dom.HTMLSelectElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Select
 * @author Savino
 *
 */
public class Select 
{
	private Select() {}
	
	/**
	 * Classe per costruire l'elemento Select
	 * @author Savino
	 *
	 */
	public static class SelectBuilder extends Builder<HTMLSelectElement>
	{
		private HTMLSelectElement select;
		
		/**
		 * Crea l'elemento select
		 */
		public SelectBuilder()
		{
			select = document.createElement(StringTypes.select);
		}
		
		/**
		 * Inserisce una option disabilitata e una sequenza di options nella select
		 * @param options sequenza di options
		 * @return oggetto builder
		 */
		public SelectBuilder add(HTMLOptionElement... options)
		{
			HTMLOptionElement defaultOption = new Option.OptionBuilder()
					.setInnerText("Seleziona un valore...")
					.selected()
					.disabled()
					.hidden()
					.build();
			
			select.add(defaultOption);
			
			for(int i=0; i<options.length; i++)
				select.add(options[i]);
			
			return this;
		}
		
		/**
		 * Assegna un nome alla select
		 * @param name nome della select
		 * @return oggetto builder
		 */
		public SelectBuilder setName(String name)
		{
			select.name = name;
			return this;
		}
		
		@Override
		public SelectBuilder setClassName(String className) 
		{
			select.className = className;
			return this;
		}

		@Override
		public SelectBuilder css(String property, String value) 
		{
			$(select).css(property, value);
			return this;
		}
		
		@Override
		public HTMLSelectElement build()
		{
			return select;
		}
	}
}
