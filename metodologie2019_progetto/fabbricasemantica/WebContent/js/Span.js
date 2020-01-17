/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto Span
     * @author Savino
     * @class
     */
    class Span {
        constructor() {
        }
    }
    quickstart.Span = Span;
    Span["__class"] = "quickstart.Span";
    (function (Span) {
        /**
         * Crea l'elemento span
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class SpanBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.span === undefined)
                    this.span = null;
                this.span = document.createElement("span");
            }
            /**
             * Assegna un testo allo span
             * @param {string} text testo dello span
             * @return {quickstart.Span.SpanBuilder} oggetto builder
             */
            setText(text) {
                this.span.innerText = text;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Span.SpanBuilder}
             */
            setClassName(className) {
                this.span.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Span.SpanBuilder}
             */
            css(property, value) {
                $(this.span).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLSpanElement}
             */
            build() {
                return this.span;
            }
        }
        Span.SpanBuilder = SpanBuilder;
        SpanBuilder["__class"] = "quickstart.Span.SpanBuilder";
    })(Span = quickstart.Span || (quickstart.Span = {}));
})(quickstart || (quickstart = {}));
