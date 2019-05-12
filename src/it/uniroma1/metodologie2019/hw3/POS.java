package it.uniroma1.metodologie2019.hw3;
/**
 * Enum per la parte del discorso del synset
 * @author savinovalerio
 */
public enum POS
{
	ADVERB("a"),
	ADJECTIVE("r"),
	NOUN("n"),
	VERB("v");
	/**
	 * Valore all'interno dell'enum
	 */
	private String c;
	
	/**
	 * Costruttore dell'enum
	 * @param c rappresenta il valore all'interno del POS
	 */
	POS(String c) { this.c = c;	}
	
	/**
	 * Restituisce il valore all'interno del POS
	 * @return carattere del POS
	 */
	public String getC() { return c; }
	
	/**
	 * Restituisce un'istanza della parte del discorso
	 * @param c Valore del POS
	 * @return un oggetto di tipo POS a seconda del caratttere passato
	 */
	public static POS getPOS(String c)
	{
		switch(c)
		{
			case "a":
			case "s": return POS.ADJECTIVE; 
			case "r": return POS.ADVERB; 
			case "n": return POS.NOUN;
			case "v": return POS.VERB;
			default: return null;
		}
	}
}
