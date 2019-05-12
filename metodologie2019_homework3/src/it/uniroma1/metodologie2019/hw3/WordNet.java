package it.uniroma1.metodologie2019.hw3;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * Classe contente le informazioni riguardanti le versioni di WordNet
 * @author savinovalerio
 */
public class WordNet implements Iterable<Synset>
{
	/**
	 * Percorso in cui sono memorizzate le release di WordNet  
	 */
	public static final String PERCORSO_CARTELLA = "wordnet-releases"+File.separator+"releases";
	/**
	 * Contiene le versioni WordNet
	 */
	private static HashMap<String, WordNet> mappaVersioni = new HashMap<>();
	/**
	 * Versione corrente di WordNet
	 */
	private String version;
	/**
	 * Contiene tutti i synset identificati per ID
	 */
	private Map<String, Synset> mappaSynset;
	/**
	 * Costruttore di WordNet
	 * @param version Versione di WordNet
	 */
	private WordNet(String version)
	{
		this.version = version;
		mappaSynset = new HashMap<>();
		try
		{
			Path pAdj = Paths.get(PERCORSO_CARTELLA+File.separator+"WordNet-"+version+File.separator+"dict"+File.separator+"data.adj");
			Path pAdv = Paths.get(PERCORSO_CARTELLA+File.separator+"WordNet-"+version+File.separator+"dict"+File.separator+"data.adv");
			Path pNoun = Paths.get(PERCORSO_CARTELLA+File.separator+"WordNet-"+version+File.separator+"dict"+File.separator+"data.noun");
			Path pVerb = Paths.get(PERCORSO_CARTELLA+File.separator+"WordNet-"+version+File.separator+"dict"+File.separator+"data.verb"); 
			
			
			Stream<String> righe = Files.lines(pAdj).filter(riga -> !(riga.startsWith(" ")));
			righe.forEach(l -> 	{String id = l.substring(0, 8)+l.charAt(12);
								List<String> lSplit = List.of(l.split("\\|"));
								mappaSynset.put(id, new Synset(lSplit));
								});

			righe = Files.lines(pAdv).filter(riga -> !(riga.startsWith(" ")));
			righe.forEach(l -> 	{String id = l.substring(0, 8)+l.charAt(12);
								List<String> lSplit = List.of(l.split("\\|"));
								mappaSynset.put(id, new Synset(lSplit));
								});
			
			righe = Files.lines(pNoun).filter(riga -> !(riga.startsWith(" ")));
			righe.forEach(l -> {String id = l.substring(0, 8)+l.charAt(12);
								List<String> lSplit = List.of(l.split("\\|"));
								mappaSynset.put(id, new Synset(lSplit));
								});
			
			righe = Files.lines(pVerb).filter(riga -> !(riga.startsWith(" ")));
			righe.forEach(l -> 	{String id = l.substring(0, 8)+l.charAt(12);
								List<String> lSplit = List.of(l.split("\\|"));
								mappaSynset.put(id, new Synset(lSplit));
								});
			
			righe.close();
		}
		catch(IOException e)
		{
			System.out.println("C'è stato un errore nella lettura dei files");
		}
	}
	/**
	 * Restituisce un'unica istanza di WordNet a partire da una versione esistente
	 * @param version Versione di WordNet
	 * @return istanza di WordNet
	 */
	public static WordNet getInstance(String version)
	{
		if(new File(PERCORSO_CARTELLA+File.separator+"WordNet-"+version).exists()) 
		{
			if(mappaVersioni.containsKey(version))
				return mappaVersioni.get(version);
			else
			{
				mappaVersioni.put(version, new WordNet(version));
				return mappaVersioni.get(version);
			}
		}
		return null;
	}  
	/**
	 * Restituisce una lista di sysnet dato un lemma 
	 * @param word Lemma
	 * @return lista di Synset 
	 */
	public List<Synset> getSynsets(String word)
	{
		List<Synset> listaSynsetWord = new ArrayList<>();
		listaSynsetWord.addAll(getSynsets(word, POS.ADJECTIVE));
		listaSynsetWord.addAll(getSynsets(word, POS.ADVERB));
		listaSynsetWord.addAll(getSynsets(word, POS.NOUN));
		listaSynsetWord.addAll(getSynsets(word, POS.VERB));
		
		return listaSynsetWord;
	}
	
	/**
	 * Restituisce una lista di synset dato un lemma e la parte del discorso
	 * @param word Lemma
	 * @param p	parte del discorso
	 * @return lista di Synset
	 */
	public List<Synset> getSynsets(String word, POS p)
	{
		List<Synset> listaSynsetWordId = new ArrayList<>();
		for(Synset s : mappaSynset.values())
		{
			if(s.getSynonyms().contains(word) && s.getPOS() == p)
				listaSynsetWordId.add(s);
		}
		return listaSynsetWordId;
	}
	
	/**
	 * Restituisce un Synset dato il suo ID 
	 * @param id ID
	 * @return synset
	 */
	public Synset getSynsetFromID(String id) { return mappaSynset.get(id); }
	
	/**
	 * Restituisce uno stream di Synset
	 * @return Stream di synset
	 */
	public Stream<Synset> stream() { return mappaSynset.values().stream(); }
	/**
	 * Restituisce la versione corrente dell'oggetto WordNet
	 * @return versione corrente di WordNet
	 */
	public String getVersion() { return version; }
	
	/**
	 * Restituisce un insieme di Synset relazionati al synset dato in input 
	 * @param sourceSynset Synset sorgente
	 * @param r Tipo di relazione con altri synset sottoforma di WordNetRelation
	 * @return Insieme di Synset, vuoto se il Synset non è in relazione con nessuno
	*/ 
	public Set<Synset> getRelatedSynsets(Synset sourceSynset, WordNetRelation r)
	{
		Set<Synset> relatedSynset = getRelatedSynsets(sourceSynset, r.getWNR());
		return relatedSynset;
	}
	
	/**
	 * Restituisce un insieme di Synset relazionati al synset dato in input
	 * @param sourceSynset Synset 
	 * @param wnr Tipo di relazione con gli altri Synset sottoforma di stringa
	 * @return Insieme di Synset, vuoto se il Synset non è in relazione con nessuno
	 */
	public Set<Synset> getRelatedSynsets(Synset sourceSynset, String wnr)
	{
		Set<Synset> relatedSynset = new HashSet<>();
		if(sourceSynset.getRelatedOffset() != null)
		{
			List<String> filtro = sourceSynset.getRelatedOffset().stream().filter(s -> s.startsWith(wnr)).collect(Collectors.toList());
			for(String s : filtro)
			{
				s = s.substring(1, s.length());
				relatedSynset.add(getSynsetFromID(s));
			}
		}
		return relatedSynset;
	}
	
	@Override
	public Iterator<Synset> iterator()
	{
		return mappaSynset.values().iterator();
	}
}
























