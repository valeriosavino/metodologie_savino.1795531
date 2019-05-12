package it.uniroma1.metodologie2019.hw3;
/**
 * Classe che rappresenta la coppia Synset sorgente e corrispondente Synset destinazione con associato lo score di confidenza della coppia
 * @author savinovalerio
 */
public class SynsetPairing
{
	/**
	 * Rappresenta lo score di confidenza
	 */
	public double score;
	/**
	 * Rappresenta il synset sorgente
	 */
	public Synset synsetSorgente;
	/**
	 * Rappresenta il synset destinazione
	 */
	public Synset synsetDestinazione;
	
	/**
	 * Costruttore della classe SynsetPairing
	 * @param synsetSorgente Synset sorgente
	 * @param synsetDestinazione Synset destinazione
	 */
	public SynsetPairing(Synset synsetSorgente, Synset synsetDestinazione)
	{
		this.synsetSorgente = synsetSorgente;
		this.synsetDestinazione = synsetDestinazione;
		if(synsetSorgente.getSynonyms().stream().allMatch(s -> synsetDestinazione.getSynonyms().contains(s)))
		{
			if(synsetSorgente.getGloss().equals(synsetDestinazione.getGloss()))
				score = 1;
			else
				score = 0.5;
		}
		else
			score = 0.0;
	}
	
	/**
	 * Restituisce il Synset della versione WordNet sorgente
	 * @return Synset sorgente
	 */
	public Synset getSource() { return synsetSorgente; }
	
	/**
	 * Restituisce il Synset della versione WordNet di destinazione
	 * @return Synset destinazione
	 */
	public Synset getTarget() { return synsetDestinazione; }
	
	/**
	 * Restituisce un valore (double) di confidenza della coppia compreso tra 0.0 e 1.0
	 * @return Score dei due Synset
	 */
	public double getScore() { return score; }
}
