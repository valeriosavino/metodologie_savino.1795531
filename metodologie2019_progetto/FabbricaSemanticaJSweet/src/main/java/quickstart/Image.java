package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import java.util.function.Function;
import def.dom.HTMLImageElement;
import jsweet.util.StringTypes;

/**
 * Classe su cui si vuole costruire oggetto Image
 * @author Savino
 *
 */
public class Image 
{
	private Image() {}
	
	/**
	 * Classe per costruire l'oggetto Image
	 * @author Savino
	 *
	 */
	public static class ImageBuilder extends Builder<HTMLImageElement>
	{
		private HTMLImageElement img;
		
		/**
		 * Crea l'oggetto image
		 */
		public ImageBuilder()
		{
			img = document.createElement(StringTypes.img);
		}

		/**
		 * Assegna un indirizzo URL all'immagine
		 * @param src URL dell'immagine
		 * @return oggetto builder
		 */
		public ImageBuilder src(String src)
		{
			img.src = src;
			return this;
		}
		
		/**
		 * Modifica gli attributi dell'immagine
		 * @param name nome dell'attributo
		 * @param value valore dell'attributo
		 * @return oggetto builder
		 */
		public ImageBuilder setAttribute(String name, String value)
		{
			img.setAttribute(name, value);
			return this;
		}
		
		/**
		 * Applica una funzione al click dell'immagine
		 * @param f funzione da applicare
		 * @return oggetto builder
		 */
		public ImageBuilder onClick(Function<def.dom.MouseEvent, Object> f)
		{
			img.onclick = f;
			return this;
		}
		
		@Override
		public ImageBuilder setClassName(String className) 
		{
			img.className = className;
			return this;
		}
		
		@Override
		public ImageBuilder css(String property, String value) 
		{
			$(img).css(property, value);
			return this;
		}
		
		@Override
		public HTMLImageElement build()
		{
			return img;
		}
	}
}
