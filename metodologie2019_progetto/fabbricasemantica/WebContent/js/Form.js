/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Form {
        constructor() {
        }
    }
    quickstart.Form = Form;
    Form["__class"] = "quickstart.Form";
    (function (Form) {
        class FormBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.form === undefined)
                    this.form = null;
                this.form = document.createElement("form");
            }
            setAction(action) {
                this.form.action = action;
                return this;
            }
            setMethod(method) {
                this.form.method = method;
                return this;
            }
            onSubmit(f) {
                this.form.onsubmit = (f);
                return this;
            }
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
