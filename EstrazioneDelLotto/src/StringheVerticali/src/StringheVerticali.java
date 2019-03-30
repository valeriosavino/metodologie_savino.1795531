/**
 * @author savinovalerio
 */
public class StringheVerticali
{
	/**
	 * Confronta le lunghezze delle 3 stringhe aggiungendo spazi bianchi per ottenere su tutte la stessa lunghezza, e le stampa in verticale
	 * @param stringa1
	 * @param stringa2
	 * @param stringa3
	 */
	public void verticale(String stringa1, String stringa2, String stringa3)
	{
		if(stringa1.length() < stringa2.length() && stringa3.length() < stringa2.length())
		{
			for(int i=stringa1.length(); i<stringa2.length(); i++)
			{
				stringa1 = stringa1.concat(" ");
				stringa3 = stringa3.concat(" ");
			}
		}
		
		for(int i=0; i<stringa1.length(); i++)
		{
			System.out.print(stringa1.charAt(i)+""+stringa2.charAt(i)+""+stringa3.charAt(i)+"\n");
		}
	}
}