/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Input {
        constructor() {
        }
    }
    quickstart.Input = Input;
    Input["__class"] = "quickstart.Input";
    (function (Input) {
        class InputBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.input === undefined)
                    this.input = null;
                this.input = document.createElement("input");
            }
            setType(type) {
                this.input.type = type;
                return this;
            }
            setName(name) {
                this.input.name = name;
                return this;
            }
            setSize(size) {
                this.input.size = size;
                return this;
            }
            setValue(value) {
                this.input.value = value;
                return this;
            }
            setId(id) {
                this.input.id = id;
                return this;
            }
            readOnly() {
                this.input.readOnly = true;
                return this;
            }
            checked(checked) {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(this.input.type, "checked"))
                    this.input.checked = checked;
                return this;
            }
            onClick(f) {
                this.input.onclick = (f);
                return this;
            }
            required() {
                this.input.required = true;
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Input.InputBuilder}
             */
            setClassName(className) {
                this.input.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Input.InputBuilder}
             */
            css(property, value) {
                $(this.input).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLInputElement}
             */
            build() {
                return this.input;
            }
        }
        Input.InputBuilder = InputBuilder;
        InputBuilder["__class"] = "quickstart.Input.InputBuilder";
    })(Input = quickstart.Input || (quickstart.Input = {}));
})(quickstart || (quickstart = {}));
