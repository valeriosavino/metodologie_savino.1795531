package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import java.util.function.Function;

import def.dom.HTMLInputElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Input
 * @author Savino
 *
 */
public class Input 
{
	private Input() {}
	
	/**
	 * Classe per costruire l'elemento Input
	 * @author Savino
	 *
	 */
	public static class InputBuilder extends Builder<HTMLInputElement>
	{
		private HTMLInputElement input;
		
		/**
		 * Costruisce l'elemento input
		 */
		public InputBuilder()
		{
			input = document.createElement(StringTypes.input);
		}
		
		/**
		 * Modifica il tipo dell'input
		 * @param type tipo dell'input
		 * @return oggetto builder
		 */
		public InputBuilder setType(String type)
		{
			input.type = type;
			return this;
		}
		
		/**
		 * Modifica il nome dell'input
		 * @param name nome dell'input
		 * @return oggetto builder
		 */
		public InputBuilder setName(String name)
		{
			input.name = name;
			return this;
		}
		
		/**
		 * Modifica la grandezza del testo da inserire
		 * @param size grandezza dell'input
		 * @return oggetto builder
		 */
		public InputBuilder setSize(double size)
		{
			input.size = size;
			return this;
		}
		
		/**
		 * Assegna un valore all'input
		 * @param value valore dell'input
		 * @return oggetto builder
		 */
		public InputBuilder setValue(String value)
		{
			input.value = value;
			return this;
		}
		
		/**
		 * Assegna un id all'input
		 * @param id id dell'input
		 * @return oggetto builder
		 */
		public InputBuilder setId(String id)
		{
			input.id = id;
			return this;
		}
		
		/**
		 * Permette all'input di non essere modificato
		 * @return oggetto builder
		 */
		public InputBuilder readOnly() 
		{
			input.readOnly = true;
			return this;
		}
		
		/**
		 * Permette all'input di essere in stato di check (da usare solo su input type = checkbox)
		 * @return oggetto builder
		 */
		public InputBuilder checked()
		{
			if(input.type.equals("checked"))
				input.checked = true;
			
			return this;
		}
		
		/**
		 * Applica una funzione al click dell'oggetto
		 * @param f funzione da applicare
		 * @return oggetto builder
		 */
		public InputBuilder onClick(Function<def.dom.MouseEvent, Object> f)
		{
			input.onclick = f;
			return this;
		}
		
		/**
		 * Assegna un testo all'interno dell'input 
		 * @param placeholder testo da visualizzare
		 * @return oggetto builder
		 */
		public InputBuilder setPlaceholder(String placeholder)
		{
			input.placeholder = placeholder;
			return this;
		}
		
		/**
		 * Richiede la compilazione dell'input all'utente
		 * @return oggetto builder
		 */
		public InputBuilder required()
		{
			input.required = true;
			return this;
		}
		
		@Override
		public InputBuilder setClassName(String className)
		{
			input.className = className;
			return this;
		}
		
		@Override
		public InputBuilder css(String property, String value) 
		{
			$(input).css(property, value);
			return this;
		}
		
		@Override
		public HTMLInputElement build()
		{
			return input;
		}
	}
}
