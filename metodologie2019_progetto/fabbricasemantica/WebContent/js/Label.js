/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Label {
        constructor() {
        }
    }
    quickstart.Label = Label;
    Label["__class"] = "quickstart.Label";
    (function (Label) {
        class LabelBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.label === undefined)
                    this.label = null;
                this.label = document.createElement("label");
            }
            setTextContent(textContent) {
                this.label.textContent = textContent;
                return this;
            }
            setAttribute(name, value) {
                this.label.setAttribute(name, value);
                return this;
            }
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
