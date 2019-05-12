package it.uniroma1.metodologie2019.hw3;
import java.util.*;
/**
 * Classe che rappresenta le informazioni relative a un Synset
 * @author savinovalerio
 */
public class Synset
{
	/**
	 * Memorizza l'offset
	 */
	private String offset;
	/**
	 * Memorizza la parte del discorso
	 */
	private String pos;
	/**
	 * Memorizza l'insieme di sinonimi
	 */
	private Set<String> sinonimi; 
	/**
	 * Insieme di relazioni con altri offset
	 */
	private Set<String> offsetEsterni;

	/**
	 * Rappresenta la glossa del synset
	 */
	private String glossa;
	/**
	 * Insieme di esempi 
	 */
	private List<String> esempi;

	/**
	 * Costruttore dei Synset
	 * @param riga Riga del file che descrive il synset
	 */
	public Synset(List<String> riga)
	{
		List<String> r1 = List.of(riga.get(0).split(" "));
		this.offset = r1.get(0);
		this.pos = r1.get(2);
		int numeroParoleNelSynset = Integer.parseInt(r1.get(3), 16);
		this.sinonimi = new TreeSet<String>();
		int index = 4;
		
		for(int i=0; i<numeroParoleNelSynset*2; i+=2)
		{
			sinonimi.add(r1.get(4+i));
			index += 2;
		}
		int numeroRelazioniSynset = Integer.parseInt(r1.get(index));
		if(numeroRelazioniSynset >= 1)
		{
			offsetEsterni = new TreeSet<>();
			for(int i=index+1; i<(numeroRelazioniSynset*4)+index+1; i+=4)
			{
				offsetEsterni.add(r1.get(i)+r1.get(i+1)+r1.get(i+2)); //Tipo rel + offset + POS
			}
		}
		
		List<String> r2 = List.of(riga.get(1).split(";"));
		if(r2.get(0).endsWith(" ") && r2.get(0).length() > 1)
			this.glossa = r2.get(0).substring(1, r2.get(0).length()-2);
		else
			this.glossa = r2.get(0).substring(1, r2.get(0).length());
		
		esempi = new ArrayList<>();
		if(r2.size() > 1)
		{
			for(int i=1; i<r2.size(); i++)
			{
				if(r2.get(i).startsWith(" \"") && r2.get(i).length() > 4)
				{
					if(r2.get(i).endsWith("\"  "))
						esempi.add(r2.get(i).substring(2, r2.get(i).length()-3));
					else
						esempi.add(r2.get(i).substring(2, r2.get(i).length()-1));
				}
			}
		}
	}
	/**
	 * Restituisce l'insieme dei sinonimi del synset
	 * @return insieme di sinonimi
	 */
	public Set<String> getSynonyms() { return sinonimi; }
	/**
	 * Verifica se una parola è contenuta nel synset
	 * @param word Parola da verificare
	 * @return true se la parola è contenuta nel synset, false altrimenti
	 */
	public boolean contains(String word) { return sinonimi.contains(word); }

	/**
	 * Restituisce la glossa del synset
	 * @return glossa del synset
	 */
	public String getGloss() { return glossa; }
	
	/**
	 * Restituisce gli esempi del synset, se presenti
	 * @return lista di esempi
	 */
	public List<String> getExamples() {	return esempi; }
	
	/**
	 * Restituisce l'offset del sysnet
	 * @return offset del synset
	 */
	public String getOffset() { return offset; }

	/**
	 * Restituisce un'istanza della parte del discorso 
	 * @return parte del discorso
	 */
	public POS getPOS() { return POS.getPOS(pos); }
	
	/**
	 * Restituisce l'ID del synset, costituito dall'offset e dal POS
	 * @return ID del synset
	 */
	public String getID() { return offset + pos; }
	
	/**
	 * Restituisce l'insieme di Offset dei Synset in relazione
	 * @return insieme di offset
	 */
	public Set<String> getRelatedOffset() { return offsetEsterni; }
	
}




























