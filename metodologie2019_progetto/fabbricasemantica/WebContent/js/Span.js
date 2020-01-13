/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Span {
        constructor() {
        }
    }
    quickstart.Span = Span;
    Span["__class"] = "quickstart.Span";
    (function (Span) {
        class SpanBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.span === undefined)
                    this.span = null;
                this.span = document.createElement("span");
            }
            setText(text) {
                this.span.innerText = text;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Builder}
             */
            setClassName(className) {
                this.span.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Builder}
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
