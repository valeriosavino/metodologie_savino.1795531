/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto Input
     * @author Savino
     * @class
     */
    class Input {
        constructor() {
        }
    }
    quickstart.Input = Input;
    Input["__class"] = "quickstart.Input";
    (function (Input) {
        /**
         * Costruisce l'elemento input
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class InputBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.input === undefined)
                    this.input = null;
                this.input = document.createElement("input");
            }
            /**
             * Modifica il tipo dell'input
             * @param {string} type tipo dell'input
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            setType(type) {
                this.input.type = type;
                return this;
            }
            /**
             * Modifica il nome dell'input
             * @param {string} name nome dell'input
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            setName(name) {
                this.input.name = name;
                return this;
            }
            /**
             * Modifica la grandezza del testo da inserire
             * @param {number} size grandezza dell'input
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            setSize(size) {
                this.input.size = size;
                return this;
            }
            /**
             * Assegna un valore all'input
             * @param {string} value valore dell'input
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            setValue(value) {
                this.input.value = value;
                return this;
            }
            /**
             * Assegna un id all'input
             * @param {string} id id dell'input
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            setId(id) {
                this.input.id = id;
                return this;
            }
            /**
             * Permette all'input di non essere modificato
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            readOnly() {
                this.input.readOnly = true;
                return this;
            }
            /**
             * Permette all'input di essere in stato di check (da usare solo su input type = checkbox)
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            checked() {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(this.input.type, "checked"))
                    this.input.checked = true;
                return this;
            }
            /**
             * Applica una funzione al click dell'oggetto
             * @param {*} f funzione da applicare
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            onClick(f) {
                this.input.onclick = (f);
                return this;
            }
            /**
             * Assegna un testo all'interno dell'input
             * @param {string} placeholder testo da visualizzare
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
            setPlaceholder(placeholder) {
                this.input.placeholder = placeholder;
                return this;
            }
            /**
             * Richiede la compilazione dell'input all'utente
             * @return {quickstart.Input.InputBuilder} oggetto builder
             */
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
