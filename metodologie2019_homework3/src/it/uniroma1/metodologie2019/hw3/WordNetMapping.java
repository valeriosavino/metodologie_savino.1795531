package it.uniroma1.metodologie2019.hw3;

import java.util.*;
/**
 * Crea la mappatura tra due versioni di WordNet (una sorgente e una di destinazione)
 * @author savinovalerio
 *
 */
public class WordNetMapping
{
	private WordNet wordNetSorgente;
	private WordNet wordNetDestinazione;
	private SynsetPairing sp;
	
	/**
	 * Costruttore della classe WordNetMapping
	 * @param wordNetSorgente WordNet sorgente
	 * @param wordNetDestinazione WordNet destinazione
	 */
	public WordNetMapping(WordNet wordNetSorgente, WordNet wordNetDestinazione)
	{
		this.wordNetSorgente = wordNetSorgente;
		this.wordNetDestinazione = wordNetDestinazione;
	}
	
	/**
	 * Restituisce un Optional contenente il SynsetPairing che mappa il 
	 * synset sorgente con il miglior synset nella versione di destinazione
	 * @param src Synset sorgente
	 * @return SynsetPairing che possiede il punteggio migliore
	 */
	public Optional<SynsetPairing> getMapping(Synset src)
	{
		if(wordNetDestinazione.getVersion() != wordNetSorgente.getVersion())
		{
			for(Synset s : wordNetDestinazione)
			{
				sp = new SynsetPairing(src, s);
				if(sp.getScore() == 1.0)
					return Optional.ofNullable(sp);
			}
			return Optional.empty();
		}
		else
		{
			sp = new SynsetPairing(src, src);
			return Optional.ofNullable(sp);
		}		
	}
}
