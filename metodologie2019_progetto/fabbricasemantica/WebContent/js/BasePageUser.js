/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe astratta che fa da base per le pagine Login e Signup
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
            let email = new quickstart.Input.InputBuilder().setType("email").setName("input_email").setId("input_email").setSize(20).setClassName("form-control").required().build();
            let divEmail = new quickstart.Div.DivBuilder().append(labelEmail, email).setClassName("form-group").build();
            let labelPassword = new quickstart.Label.LabelBuilder().setTextContent("Password (*): ").setClassName("form-control-plaintext").setAttribute("style", "font-weight:bold").build();
            let password = new quickstart.Input.InputBuilder().setType("password").setName("input_pass").setId("input_pass").setSize(32).setClassName("form-control").required().build();
            let divPassword = new quickstart.Div.DivBuilder().append(labelPassword, password).setClassName("form-group").build();
            return new quickstart.Div.DivBuilder().append(divEmail, divPassword).setClassName("form-group").build();
        }
        /**
         * Formatta il form all'interno di un pannello
         * @param servlet_url indirizzo della servlet a cui inviare i dati del form
         * @param e elementi da inserire nel form
         * @param {HTMLFormElement} form
         */
        createPanelForm(form) {
            let panelBody = new quickstart.Div.DivBuilder().setClassName("panel-body").css("color", "#31708f").css("background-color", "#d9edf7").css("border", "1px\tsolid #bce8f1").append(form).build();
            let panelTitle = new quickstart.Label.LabelBuilder().setTextContent("Compila i campi").setClassName("panel-title").build();
            let panelHealing = new quickstart.Div.DivBuilder().setClassName("panel-heading").css("background-color", "#FFFFFF").css("color", "#31708f").css("background-color", "#D9EDF7").css("border", "1px\tsolid #BCE8F1").append(panelTitle).build();
            let panelDefault = new quickstart.Div.DivBuilder().setClassName("panel panel-default").append(panelHealing, panelBody).build();
            let colMd4 = new quickstart.Div.DivBuilder().setClassName("col-md-4 col-md-offset-4").append(panelDefault).build();
            this.appendBody(colMd4);
        }
        /**
         * Inserisce nel body gli elementi passati in input
         * @param {Array} e elementi da inserire nel body
         * @private
         */
        /*private*/ appendBody(...e) {
            let title = new quickstart.H1.HBuilder().setText("BENVENUTO IN FABBRICA SEMANTICA").setAlign("center").css("font-weight", "bold").css("font-size", "40px").build();
            let container = (o => o.append.apply(o, e))(new quickstart.Div.DivBuilder().setClassName("container").append(title)).build();
            $("body").append(container);
        }
    }
    quickstart.BasePageUser = BasePageUser;
    BasePageUser["__class"] = "quickstart.BasePageUser";
})(quickstart || (quickstart = {}));
