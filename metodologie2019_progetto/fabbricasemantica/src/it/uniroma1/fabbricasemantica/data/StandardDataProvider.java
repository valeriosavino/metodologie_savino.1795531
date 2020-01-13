package it.uniroma1.fabbricasemantica.data;

/**
 * Questa classe restituisce i dati necessari per il task ricevuto in input.
 * Il metodo {@link #getData(Task)} restituira' una stringa in formato JSON
 * che le pagine in JSweet andranno a formattare.
 * N.B. Il proprio {@link DataProvider} dovrebbe evitare di avere stringhe codificate, questo e' solo un esempio.
 * */
public class StandardDataProvider implements DataProvider<String> {

	@Override 
	public String getData(Task task) 
	{
		if (task == StandardTask.TRANSLATION_ANNOTATION) 
		{
			return "{" +
					"\"word\": \"Apple\"," +
					"\"description\": \"It's one of the most common fruits you mention in examples but that you rarely eat\"" +
					"}";
		}
		else if (task == StandardTask.WORD_ANNOTATION) 
		{
			return "{\"description\": \"A motor vehicle with four wheels; usually propelled by an internal combustion engine\"}";
		}
		else if (task == StandardTask.DEFINITION_ANNOTATION) 
		{
			return "{" + 
					"\"word\": \"Car\"," +
					"\"hypernym\": \"Motor vehicle\"" +
					"}";
		}
		else if (task == StandardTask.SENSE_ANNOTATION) 
		{
			return "{" + 
					"\"word\":\"Mouse\"," +
					"\"description\":\"A mouse takes much more room than a trackball\"," + 
					"\"senses\": [\"Any of numerous small rodents typically resembling diminutive rats having pointed snouts and small ears on elongated bodies with slender usually hairless tails\", \"A hand-operated electronic device that controls the coordinates of a cursor on your computer screen as you move it around on a pad\", \"Person who is quiet or timid\", \"A swollen bruise caused by a blow to the eye\"]" + 
					"}";
		}
		else if (task == StandardTask.MY_ANNOTATION) 
		{
			return "{" + 
					"\"words\": [\"Animal\", \"Emigration\", \"Mistake\"], " +
					"\"synonyms\": [\"Nutrient\", \"Leveling\", \"Fauna\", \"Lapse\", \"Expatriation\", \"Boomerang\", \"Error\", \"Jailbreak\", \"Reversion\"]"+
					"}";
		}
		else if (task == StandardTask.TRANSLATION_VALIDATION) 
		{
			return "{" +
					"\"word\": \"Rock\"," +
					"\"description\": \"A lump or mass of hard consolidated mineral matter\"," + 
					"\"translations\": [\"Un grumo o una massa di materia minerale consolidata dura\"," +
										"\"Un genere della musica sviluppatosi negli anni cinquanta\"," +
										"\"Materiale costituito dall'aggregato di minerali come quelli che formano la crosta terrestre\"," +
										"\"Un'associazione non ufficiale di persone o gruppi\"]" +
					"}";
		}
		else if (task == StandardTask.SENSE_VALIDATION)
		{
			return "{" + 
					"\"word\": \"Bank\"," +
					"\"example\": \"He cashed a check at the bank\"," +
					"\"sense\": \"Sloping land (especially the slope beside a body of water)\"" +
					"}";
		}
		return null; 
	}
	

}
