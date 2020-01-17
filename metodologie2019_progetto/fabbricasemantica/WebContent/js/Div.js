/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto Div
     * @author Savino
     * @class
     */
    class Div {
        constructor() {
        }
    }
    quickstart.Div = Div;
    Div["__class"] = "quickstart.Div";
    (function (Div) {
        /**
         * Crea l'elemento div
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class DivBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.div === undefined)
                    this.div = null;
                this.div = document.createElement("div");
            }
            /**
             * Assegna l'allineamento del div all'interno della pagina
             * @param {string} align posizione nella pagina
             * @return {quickstart.Div.DivBuilder} oggetto builder
             */
            setAlign(align) {
                this.div.align = align;
                return this;
            }
            /**
             * Permette di aggiungere componenti all'interno del div
             * @param {Array} e elementi da aggiungere
             * @return {quickstart.Div.DivBuilder} oggetto builder
             */
            append(...e) {
                $(this.div).append(...e);
                return this;
            }
            /**
             * Assegna degli attributi al div
             * @param {string} name nome dell'attributo
             * @param {string} value valore dell'attributo
             * @return
             * @return {quickstart.Div.DivBuilder}
             */
            setAttribute(name, value) {
                this.div.setAttribute(name, value);
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Div.DivBuilder}
             */
            css(property, value) {
                $(this.div).css(property, value);
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Div.DivBuilder}
             */
            setClassName(className) {
                this.div.className = className;
                return this;
            }
            /**
             *
             * @return {HTMLDivElement}
             */
            build() {
                return this.div;
            }
        }
        Div.DivBuilder = DivBuilder;
        DivBuilder["__class"] = "quickstart.Div.DivBuilder";
    })(Div = quickstart.Div || (quickstart.Div = {}));
})(quickstart || (quickstart = {}));
