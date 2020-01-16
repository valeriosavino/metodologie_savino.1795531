package quickstart;

import def.dom.HTMLElement;

/**
 * Classe modello per i vari builder dei componenti
 * @author Savino
 *
 */
abstract public class Builder<T extends HTMLElement>
{
	/**
	 * Modifica il classname del componente
	 * @param className 
	 * @return oggetto builder
	 */
	abstract public Builder<T> setClassName(String className);
	/**
	 * Modifica il css del componente
	 * @param property proprieta' da modificare
	 * @param value valore assunto dalla proprieta'
	 * @return oggetto builder
	 */
	abstract public Builder<T> css(String property, String value);
	/**
	 * Restituisce il componente creato
	 * @return componente
	 */
	abstract public T build();
}
