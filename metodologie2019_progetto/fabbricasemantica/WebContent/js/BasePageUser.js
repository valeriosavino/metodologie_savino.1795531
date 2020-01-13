/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che fa da base per le pagine Login e Signup
     * @author Savino
     * @class
     */
    class BasePageUser {
        /**
         * Crea un div contenente i campi email e password con le rispettive label
         * @return {HTMLDivElement} Elemento div
         */
        getDivEmailPassword() {
            let labelEmail = new quickstart.Label.LabelBuilder().setTextContent("Email (*): ").setClassName("form-control-plaintext").setAttribute("style", "font-weight:bold").build();
            let email = new quickstart.Input.InputBuilder().setType("email").setName("input_email").setId("input_email").setSize(20).setClassName("form-control").build();
            let labelPassword = new quickstart.Label.LabelBuilder().setTextContent("Password (*): ").setClassName("form-control-plaintext").setAttribute("style", "font-weight:bold").build();
            let password = new quickstart.Input.InputBuilder().setType("password").setName("input_pass").setId("input_pass").setSize(32).setClassName("form-control").build();
            return new quickstart.Div.DivBuilder().append(labelEmail, email, labelPassword, password).setClassName("form-group").build();
        }
        /**
         * Crea il form e lo formatta all'interno di un pannello
         * @param {string} SERVLET_URL
         * @param {Array} e
         */
        createForm(SERVLET_URL, ...e) {
            let form = (o => o.append.apply(o, e))(new quickstart.Form.FormBuilder().setAction(SERVLET_URL).setMethod("POST")).onSubmit((e) => { return BasePageUser.onSubmit(e); }).build();
            let panelBody = new quickstart.Div.DivBuilder().setClassName("panel-body").css("color", "#31708f").css("background-color", "#d9edf7").css("border", "1px\tsolid #bce8f1").append(form).build();
            let panelTitle = new quickstart.Label.LabelBuilder().setTextContent("Compila i campi").setClassName("panel-title").build();
            let panelHealing = new quickstart.Div.DivBuilder().setClassName("panel-heading").css("background-color", "#FFFFFF").css("color", "#31708f").css("background-color", "#d9edf7").css("border", "1px\tsolid #bce8f1").append(panelTitle).build();
            let panelDefault = new quickstart.Div.DivBuilder().setClassName("panel panel-default").append(panelHealing).build();
            let colMd4 = new quickstart.Div.DivBuilder().setClassName("col-md-4 col-md-offset-4").append(panelDefault, panelBody).build();
            this.appendBody(colMd4);
        }
        /*private*/ appendBody(...e) {
            let title = new quickstart.H1.HBuilder().setText("BENVENUTO IN FABBRICA SEMANTICA").setAlign("center").build();
            let container = (o => o.append.apply(o, e))(new quickstart.Div.DivBuilder().setClassName("container").append(title)).build();
            $("body").append(container);
        }
        static onSubmit(e) {
            let send = true;
            let email = document.getElementById("input_email").value;
            if (!(email.substring(email.indexOf("@") + 1).indexOf(".") != -1)) {
                alert("L\'email inserita non \u00e8 scritta in modo corretto");
                send = false;
            }
            return send;
        }
    }
    quickstart.BasePageUser = BasePageUser;
    BasePageUser["__class"] = "quickstart.BasePageUser";
})(quickstart || (quickstart = {}));
