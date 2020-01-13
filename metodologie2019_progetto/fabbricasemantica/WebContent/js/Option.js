/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Option {
        constructor() {
        }
    }
    quickstart.Option = Option;
    Option["__class"] = "quickstart.Option";
    (function (Option) {
        class OptionBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.option === undefined)
                    this.option = null;
                this.option = document.createElement("option");
            }
            setValue(value) {
                this.option.value = value;
                return this;
            }
            setInnerText(innerText) {
                this.option.innerText = innerText;
                return this;
            }
            selected() {
                this.option.selected = true;
                return this;
            }
            disabled() {
                this.option.disabled = true;
                return this;
            }
            hidden() {
                this.option.hidden = true;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Option.OptionBuilder}
             */
            setClassName(className) {
                this.option.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Option.OptionBuilder}
             */
            css(property, value) {
                $(this.option).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLOptionElement}
             */
            build() {
                return this.option;
            }
        }
        Option.OptionBuilder = OptionBuilder;
        OptionBuilder["__class"] = "quickstart.Option.OptionBuilder";
    })(Option = quickstart.Option || (quickstart.Option = {}));
})(quickstart || (quickstart = {}));
