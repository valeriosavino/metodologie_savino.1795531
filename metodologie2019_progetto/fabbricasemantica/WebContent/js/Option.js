/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto Option
     * @author Savino
     * @class
     */
    class Option {
        constructor() {
        }
    }
    quickstart.Option = Option;
    Option["__class"] = "quickstart.Option";
    (function (Option) {
        /**
         * Crea l'elemento option
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class OptionBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.option === undefined)
                    this.option = null;
                this.option = document.createElement("option");
            }
            /**
             * Asssegna un valore alla option
             * @param {string} value valore dell'option
             * @return {quickstart.Option.OptionBuilder} oggetto builder
             */
            setValue(value) {
                this.option.value = value;
                return this;
            }
            /**
             * Assegna un testo da visualizzare nell'option
             * @param {string} innerText testo dell'option
             * @return {quickstart.Option.OptionBuilder} oggetto builder
             */
            setInnerText(innerText) {
                this.option.innerText = innerText;
                return this;
            }
            /**
             * Imposta l'option come selezionata
             * @return {quickstart.Option.OptionBuilder} oggetto builder
             */
            selected() {
                this.option.selected = true;
                return this;
            }
            /**
             * Imposta l'option come disabilitata
             * @return {quickstart.Option.OptionBuilder} oggetto builder
             */
            disabled() {
                this.option.disabled = true;
                return this;
            }
            /**
             * Imposta l'option come option nascosta
             * @return {quickstart.Option.OptionBuilder} oggetto builder
             */
            hidden() {
                this.option.hidden = true;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Option.OptionBuilder}
             */
            setClassName(className) {
                this.option.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Option.OptionBuilder}
             */
            css(property, value) {
                $(this.option).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLOptionElement}
             */
            build() {
                return this.option;
            }
        }
        Option.OptionBuilder = OptionBuilder;
        OptionBuilder["__class"] = "quickstart.Option.OptionBuilder";
    })(Option = quickstart.Option || (quickstart.Option = {}));
})(quickstart || (quickstart = {}));
