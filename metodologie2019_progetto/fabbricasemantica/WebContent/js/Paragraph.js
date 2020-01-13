/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Paragraph {
        constructor() {
        }
    }
    quickstart.Paragraph = Paragraph;
    Paragraph["__class"] = "quickstart.Paragraph";
    (function (Paragraph) {
        class ParagraphBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.p === undefined)
                    this.p = null;
                this.p = document.createElement("p");
            }
            append(e) {
                $(this.p).append(e);
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Paragraph.ParagraphBuilder}
             */
            setClassName(className) {
                this.p.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Paragraph.ParagraphBuilder}
             */
            css(property, value) {
                $(this.p).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLParagraphElement}
             */
            build() {
                return this.p;
            }
        }
        Paragraph.ParagraphBuilder = ParagraphBuilder;
        ParagraphBuilder["__class"] = "quickstart.Paragraph.ParagraphBuilder";
    })(Paragraph = quickstart.Paragraph || (quickstart.Paragraph = {}));
})(quickstart || (quickstart = {}));
