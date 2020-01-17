/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto Form
     * @author Savino
     * @class
     */
    class Form {
        constructor() {
        }
    }
    quickstart.Form = Form;
    Form["__class"] = "quickstart.Form";
    (function (Form) {
        /**
         * Classe per costruire l'elemento Form
         * @author Savino
         * @class
         * @extends quickstart.Builder
         */
        class FormBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.form === undefined)
                    this.form = null;
                this.form = document.createElement("form");
            }
            /**
             * Assegna l'indirizzo della servlet al form
             * @param {string} action indirizzo della servlet
             * @return {quickstart.Form.FormBuilder} oggetto builder
             */
            setAction(action) {
                this.form.action = action;
                return this;
            }
            /**
             * Assegna il metodo di invio dei dati al server
             * @param {string} method metodo invio
             * @return {quickstart.Form.FormBuilder} oggetto builder
             */
            setMethod(method) {
                this.form.method = method;
                return this;
            }
            /**
             * Assegna una function per il controllo campi del form
             * @param {*} f Function
             * @return {quickstart.Form.FormBuilder} oggetto builder
             */
            onSubmit(f) {
                this.form.onsubmit = (f);
                return this;
            }
            /**
             * Aggiunge elementi all'interno del form
             * @param {Array} e elementi da aggiungere
             * @return {quickstart.Form.FormBuilder} oggetto builder
             */
            append(...e) {
                $(this.form).append(...e);
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Builder}
             */
            css(property, value) {
                $(this.form).css(property, value);
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Form.FormBuilder}
             */
            setClassName(className) {
                this.form.className = className;
                return this;
            }
            /**
             *
             * @return {HTMLFormElement}
             */
            build() {
                return this.form;
            }
        }
        Form.FormBuilder = FormBuilder;
        FormBuilder["__class"] = "quickstart.Form.FormBuilder";
    })(Form = quickstart.Form || (quickstart.Form = {}));
})(quickstart || (quickstart = {}));
