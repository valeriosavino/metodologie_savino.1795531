/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TextArea {
        constructor() {
        }
    }
    quickstart.TextArea = TextArea;
    TextArea["__class"] = "quickstart.TextArea";
    (function (TextArea) {
        class TextAreaBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.ta === undefined)
                    this.ta = null;
                this.ta = document.createElement("textarea");
            }
            setName(name) {
                this.ta.name = name;
                return this;
            }
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
             * @return {quickstart.Builder}
             */
            css(property, value) {
                return null;
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
