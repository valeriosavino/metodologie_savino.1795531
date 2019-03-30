/**
 * @author savinovalerio
 */
public class CorniceAvanzata
{
	/**
	 * Permette di creare una cornice NxN con una stringa al suo interno
	 * @param n  
	 * @param s
	 * @return matrice la matrice NxN sotto forma di stringa
	 */
	public String corniciato(int n, String s)
	{
		String matrice = "";		
		int indiceStringa = 0;
		
		for(int i=0; i<n; i++)
		{
			if(i==0 || i==n-1)
				for(int j=0; j<n; j++)	
					matrice += "*";
			
			else
			{
				 
				matrice += "*";
				for(int j=1; j<n-1; j++)
					if(indiceStringa < s.length())
					{
						matrice += s.charAt(indiceStringa);
						indiceStringa++;
					}
					else
						matrice += " ";
				
				matrice += "*";
			}
			matrice += "\n";
		}
		
		return matrice;
	}
}