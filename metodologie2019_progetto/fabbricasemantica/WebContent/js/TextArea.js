/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto TextArea
     * @author Savino
     * @class
     */
    class TextArea {
        constructor() {
        }
    }
    quickstart.TextArea = TextArea;
    TextArea["__class"] = "quickstart.TextArea";
    (function (TextArea) {
        /**
         * Crea l'oggetto textarea
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class TextAreaBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.ta === undefined)
                    this.ta = null;
                this.ta = document.createElement("textarea");
            }
            /**
             * Assegna un nome alla textArea
             * @param {string} name nome della textarea
             * @return {quickstart.TextArea.TextAreaBuilder} oggetto builder
             */
            setName(name) {
                this.ta.name = name;
                return this;
            }
            /**
             * Assegna un testo all'interno della textarea
             * @param {string} placeholder testo nella textarea
             * @return {quickstart.TextArea.TextAreaBuilder} oggetto builder
             */
            setPlaceholder(placeholder) {
                this.ta.placeholder = placeholder;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.TextArea.TextAreaBuilder}
             */
            setClassName(className) {
                this.ta.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.TextArea.TextAreaBuilder}
             */
            css(property, value) {
                $(this.ta).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLTextAreaElement}
             */
            build() {
                return this.ta;
            }
        }
        TextArea.TextAreaBuilder = TextAreaBuilder;
        TextAreaBuilder["__class"] = "quickstart.TextArea.TextAreaBuilder";
    })(TextArea = quickstart.TextArea || (quickstart.TextArea = {}));
})(quickstart || (quickstart = {}));
