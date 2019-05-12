package it.uniroma1.metodologie2019.hw3;
/**
 * Enum per il tipo di relazione tra i synset
 * @author savinovalerio
 */
public enum WordNetRelation implements WordNetRelationInterface
{
	ANTONYM("!"),
	HYPERNYM("@"),
	INSTANCE_HYPERNYM("@i"),
	HYPONYM("~"), 
	INSTANCE_HYPONYM("~i"),
	MEMBER_HOLONYM("#m"), 
	SUBSTANCE_HOLONYM("#s"),
	PART_HOLONYM("#p"),
	MEMBER_MERONYM("%m"),
	SUBSTANCE_MERONYM("%s"),
	PART_MERONYM("%p"),
	ATTRIBUTE("="),
	DERIVATIONALLY_RELATED_FORM("+"),
	DOMAIN_OF_SYNSET_TOPIC(";c"),
	MEMBER_OF_THIS_DOMAIN_TOPIC("-c"),
	DOMAIN_OF_SYNSET_REGION(";r"),
	MEMBER_OF_THIS_DOMAIN_REGION("-r"),
	DOMAIN_OF_SYNSET_USAGE(";u"),
	MEMBER_OF_THIS_DOMAIN_USAGE("-u"),
	ENTAILMENT("*"),
	CAUSE(">"),
	ALSO_SEE("^"),
	VERB_GROUP("$"),
	SIMILAR_TO("&"),
	PARTICIPLE_OF_VERB("<"),
	PERTAINYM("\\");			
	private final String wnr;
	
	WordNetRelation(String wnr) { this.wnr = wnr; }
	
	public String getWNR() { return wnr; }
	
}
