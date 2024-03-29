/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Crea la pagina per efettuare il login
     * @author Savino
     * @extends quickstart.BasePageUser
     * @class
     */
    class Login extends quickstart.BasePageUser {
        constructor() {
            super();
            if (this.login === undefined)
                this.login = null;
            if (this.divLogin === undefined)
                this.divLogin = null;
            if (this.divEmailPassword === undefined)
                this.divEmailPassword = null;
            if (this.signup === undefined)
                this.signup = null;
            if (this.psignup === undefined)
                this.psignup = null;
            this.divEmailPassword = this.getDivEmailPassword();
            this.login = new quickstart.Input.InputBuilder().setType("submit").setName("login").setValue("Entra!").setClassName("btn btn-default col-md-12").build();
            this.divLogin = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.login).build();
            this.signup = new quickstart.Anchor.AnchorBuilder().setHref("signup.html").setClassName("ml-2").setText("Non hai un account? Registrati!").build();
            this.psignup = new quickstart.Paragraph.ParagraphBuilder().setClassName("text-center").append(this.signup).build();
            let form = new quickstart.Form.FormBuilder().setAction(Login.SERVLET_URL).setMethod("POST").append(this.divEmailPassword, this.divLogin, this.psignup).onSubmit((e) => { return Login.onSubmit(e); }).build();
            this.createPanelForm(form);
        }
        /**
         * Controlla nel form al momento dell'invio se la email � scritta in modo corretto
         * @param {Event} e evento che attiva l'onSubmit
         * @return {boolean} false se il form non � corretto, true altrimenti
         */
        static onSubmit(e) {
            let send = true;
            let email = document.getElementById("input_email").value;
            if (!(email.substring(email.indexOf("@") + 1).indexOf(".") != -1)) {
                alert("L\'email inserita non \u00e8 scritta in modo corretto");
                send = false;
            }
            return send;
        }
        static main(args) {
            new Login();
        }
    }
    /**
     * Indirizzo della servlet per il login
     */
    Login.SERVLET_URL = "login.jsp";
    quickstart.Login = Login;
    Login["__class"] = "quickstart.Login";
})(quickstart || (quickstart = {}));
quickstart.Login.main(null);
