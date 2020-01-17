/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto H1
     * @author Savino
     * @class
     */
    class H1 {
        constructor() {
        }
    }
    quickstart.H1 = H1;
    H1["__class"] = "quickstart.H1";
    (function (H1) {
        /**
         * Crea l'oggetto H1
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class HBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.h === undefined)
                    this.h = null;
                this.h = document.createElement("h1");
            }
            /**
             * Modifica il contenuto testuale dell'h1
             * @param {string} text
             * @return
             * @return {quickstart.H1.HBuilder}
             */
            setText(text) {
                this.h.innerText = text;
                return this;
            }
            /**
             * Modifica la posizione del componente nella pagina
             * @param {string} align
             * @return
             * @return {quickstart.H1.HBuilder}
             */
            setAlign(align) {
                this.h.align = align;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.H1.HBuilder}
             */
            setClassName(className) {
                this.h.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.H1.HBuilder}
             */
            css(property, value) {
                $(this.h).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLHeadingElement}
             */
            build() {
                return this.h;
            }
        }
        H1.HBuilder = HBuilder;
        HBuilder["__class"] = "quickstart.H1.HBuilder";
    })(H1 = quickstart.H1 || (quickstart.H1 = {}));
})(quickstart || (quickstart = {}));
