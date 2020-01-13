/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     *
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
         * Istanzia l'elemento div
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
             * Assegna l'id all'elemento div
             * @param {string} id
             * @return {quickstart.Div.DivBuilder} oggetto builder
             */
            setId(id) {
                this.div.id = id;
                return this;
            }
            /**
             * Assegna l'allineamento del div all'interno della pagina
             * @param {string} align
             * @return {quickstart.Div.DivBuilder} oggetto builder
             */
            setAlign(align) {
                this.div.align = align;
                return this;
            }
            /**
             * Permette di aggiungere componenti all'interno del div
             * @param elementi da aggiungere
             * @return {quickstart.Div.DivBuilder} oggetto builder
             * @param {Array} e
             */
            append(...e) {
                $(this.div).append(...e);
                return this;
            }
            /**
             * Assegna degli attributi al div
             * @param {string} name
             * @param {string} value
             * @return
             * @return {quickstart.Div.DivBuilder}
             */
            setAttribute(name, value) {
                this.div.setAttribute(name, value);
                return this;
            }
            /**
             * Modifica lo stile CSS del div
             * @param {string} property
             * @param {string} value
             * @return
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
