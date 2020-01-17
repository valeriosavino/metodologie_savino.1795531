/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto Label
     * @author Savino
     * @class
     */
    class Label {
        constructor() {
        }
    }
    quickstart.Label = Label;
    Label["__class"] = "quickstart.Label";
    (function (Label) {
        /**
         * Costruisce l'elemento label
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class LabelBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.label === undefined)
                    this.label = null;
                this.label = document.createElement("label");
            }
            /**
             * Assegna un testo alla label
             * @param {string} textContent testo della label
             * @return {quickstart.Label.LabelBuilder} oggetto builder
             */
            setTextContent(textContent) {
                this.label.textContent = textContent;
                return this;
            }
            /**
             * Modifica un attributo della label
             * @param {string} name nome attributo
             * @param {string} value valore dell'attributo
             * @return {quickstart.Label.LabelBuilder} oggetto builder
             */
            setAttribute(name, value) {
                this.label.setAttribute(name, value);
                return this;
            }
            /**
             * Assegna il nome del componente a cui la label deve riferirsi
             * @param {string} HTMLFor nome del componente HTML
             * @return {quickstart.Label.LabelBuilder} oggetto builder
             */
            setHTMLFor(HTMLFor) {
                this.label.htmlFor = HTMLFor;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Label.LabelBuilder}
             */
            setClassName(className) {
                this.label.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Label.LabelBuilder}
             */
            css(property, value) {
                $(this.label).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLLabelElement}
             */
            build() {
                return this.label;
            }
        }
        Label.LabelBuilder = LabelBuilder;
        LabelBuilder["__class"] = "quickstart.Label.LabelBuilder";
    })(Label = quickstart.Label || (quickstart.Label = {}));
})(quickstart || (quickstart = {}));
