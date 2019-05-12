package it.uniroma1.metodologie2019.hw3;
/**
 * Classe che fornisce la mappatura da una WordNet di partenza a una di destinazione
 * @author savinovalerio
 *
 */
public class Mapper
{
	/**
	 * Prende in input due WordNet e restituisce una WordNetMapping che fornisce la mappatura dalla wordnet 
	 * di partenza a quella di destinazione
	 * @param source WordNet sorgente
	 * @param dest WordNet destinazione
	 * @return mappatura tra le due WordNet
	 */
	public static WordNetMapping map(WordNet source, WordNet dest)
	{
		return new WordNetMapping(source, dest);
	}
}
