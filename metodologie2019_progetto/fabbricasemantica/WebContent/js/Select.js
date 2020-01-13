/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Select {
        constructor() {
        }
    }
    quickstart.Select = Select;
    Select["__class"] = "quickstart.Select";
    (function (Select) {
        class SelectBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.select === undefined)
                    this.select = null;
                this.select = document.createElement("select");
            }
            add(...options) {
                let defaultOption = new quickstart.Option.OptionBuilder().setInnerText("Seleziona un valore...").selected().disabled().hidden().build();
                this.select.add(defaultOption);
                for (let i = 0; i < options.length; i++) {
                    this.select.add(options[i]);
                }
                return this;
            }
            setName(name) {
                this.select.name = name;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Select.SelectBuilder}
             */
            setClassName(className) {
                this.select.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Select.SelectBuilder}
             */
            css(property, value) {
                $(this.select).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLSelectElement}
             */
            build() {
                return this.select;
            }
        }
        Select.SelectBuilder = SelectBuilder;
        SelectBuilder["__class"] = "quickstart.Select.SelectBuilder";
    })(Select = quickstart.Select || (quickstart.Select = {}));
})(quickstart || (quickstart = {}));
