/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Anchor {
        constructor() {
        }
    }
    quickstart.Anchor = Anchor;
    Anchor["__class"] = "quickstart.Anchor";
    (function (Anchor) {
        /**
         * Crea l'elemento anchor
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class AnchorBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.a === undefined)
                    this.a = null;
                this.a = document.createElement("a");
            }
            /**
             * Assegna un indirizzo all'anchor
             * @param {string} href
             * @return
             * @return {quickstart.Anchor.AnchorBuilder}
             */
            setHref(href) {
                this.a.href = href;
                return this;
            }
            /**
             * Modifica il contenuto testuale dell'anchor
             * @param {string} text
             * @return
             * @return {quickstart.Anchor.AnchorBuilder}
             */
            setText(text) {
                this.a.text = text;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Anchor.AnchorBuilder}
             */
            setClassName(className) {
                this.a.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Anchor.AnchorBuilder}
             */
            css(property, value) {
                $(this.a).css(property, value);
                return this;
            }
            /**
             * Restituisce l'anchor
             * @return {HTMLAnchorElement}
             */
            build() {
                return this.a;
            }
        }
        Anchor.AnchorBuilder = AnchorBuilder;
        AnchorBuilder["__class"] = "quickstart.Anchor.AnchorBuilder";
    })(Anchor = quickstart.Anchor || (quickstart.Anchor = {}));
})(quickstart || (quickstart = {}));
