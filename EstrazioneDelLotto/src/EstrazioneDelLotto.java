/**
 * @author savinovalerio
 */
public class EstrazioneDelLotto
{
	static int sommaNumeriEstratti;
	int[] estrazione;					//Contiene i numeri estratti 
	
	/**
	 * Costruttore
	 */
	public EstrazioneDelLotto()
	{
		estrazione = new int[5];
	}
	
	/**
	 * Estrae, memorizzandoli, 5 numeri tra 1 e 90 
	 */
	public void estrai()
	{
		for(int i=0; i<estrazione.length; i++)
		{
			estrazione[i] = (int) (Math.random()*90+1);
			sommaNumeriEstratti += estrazione[i];
		}
	}
	
	/**
	 * Restituisce l'ultima estrazione sotto forma di stringa 
	 */
	public String toString()
	{
		String numeri = "";
		for(int i=0; i<estrazione.length-1; i++)
			numeri += estrazione[i]+", ";
		
		numeri += estrazione[estrazione.length-1];
		return numeri;
	}
	
	/**
	 * Prende in input una giocata (sequenza ﬁno a 10 numeri) e restituisce quanti dei numeri giocati sono anche contenuti nell'ultima estrazione
	 * @param giocata  Array contenente i numeri scelti dal giocatore
	 * @return conto, contenente il numero dei numeri giocati corrispondenti alla giocata, -1 se la lunghezza della giocata non è valida 
	 */
	public int numeriContenuti(int[] giocata)
	{
		if(giocata.length <= 10)
		{
			int conto=0;
		
			for(int i=0; i<giocata.length; i++)
				for(int j=0; j<estrazione.length; j++)
					if(giocata[i] == estrazione[j]) conto++;
			return conto;
		}
		else
			return -1;
	}
	
	/**
	 * Prende in input una giocata e restituisce un booleano che indica se c'è stata una vincita 
	 * @param giocata
	 * @return true se il giocatore ha vinto, false se ha perso
	 */
	public boolean vincita(int[] giocata)
	{
		return (numeriContenuti(giocata) >= 2);
	}
	
	/**
	 * Restituisce la somma totale dei numeri ﬁnora estratti
	 * @return sommaNumeriEstratti
	 */
	public int getTotaleNumeriEstratti()
	{
		return sommaNumeriEstratti;
	}
}
