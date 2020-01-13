/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Crea la pagina per permettere l'iscrizione al sito FabbricaSemantica
     * @author Savino
     * @extends quickstart.BasePageUser
     * @class
     */
    class Signup extends quickstart.BasePageUser {
        constructor() {
            super();
            if (this.labelPassword2 === undefined)
                this.labelPassword2 = null;
            if (this.password2 === undefined)
                this.password2 = null;
            if (this.labelLingue === undefined)
                this.labelLingue = null;
            if (this.lingue === undefined)
                this.lingue = null;
            if (this.labelForLingue === undefined)
                this.labelForLingue = null;
            if (this.divLingue === undefined)
                this.divLingue = null;
            if (this.divCheckBox === undefined)
                this.divCheckBox = null;
            if (this.labelLivello === undefined)
                this.labelLivello = null;
            if (this.livello === undefined)
                this.livello = null;
            if (this.options === undefined)
                this.options = null;
            if (this.signup === undefined)
                this.signup = null;
            if (this.divPassword2 === undefined)
                this.divPassword2 = null;
            if (this.divEmailPassword === undefined)
                this.divEmailPassword = null;
            if (this.divLivello === undefined)
                this.divLivello = null;
            if (this.divSignup === undefined)
                this.divSignup = null;
            if (this.login === undefined)
                this.login = null;
            if (this.plogin === undefined)
                this.plogin = null;
            this.labelPassword2 = new quickstart.Label.LabelBuilder().setTextContent("Conferma Password (*): ").setClassName("form-control-plaintext").setAttribute("style", "font-weight:bold").build();
            this.password2 = new quickstart.Input.InputBuilder().setType("password").setClassName("form-control").setName("input_conf_pass").setId("input_conf_pass").setSize(32).build();
            this.labelLingue = new quickstart.Label.LabelBuilder().setTextContent("Lingue Parlate (*): ").setClassName("form-control-plaintext").setAttribute("style", "font-weight:bold").build();
            this.lingue = ([]);
            this.labelForLingue = ([]);
            this.divLingue = ([]);
            this.addLingue("Italiano");
            this.addLingue("Inglese");
            this.labelLivello = new quickstart.Label.LabelBuilder().setTextContent("Livello lingua: ").setAttribute("style", "font-weight:bold").build();
            this.options = ([]);
            this.addOptions("A1");
            this.addOptions("A2");
            this.addOptions("B1");
            this.addOptions("B2");
            this.addOptions("C1");
            this.addOptions("C2");
            this.livello = (o => o.add.apply(o, this.options.slice(0)))(new quickstart.Select.SelectBuilder().setName("livello")).setClassName("form-control").build();
            this.signup = new quickstart.Input.InputBuilder().setType("submit").setName("signup").setValue("Registrati!").setClassName("btn btn-default col-md-12").build();
            this.divEmailPassword = this.getDivEmailPassword();
            this.divPassword2 = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.labelPassword2, this.password2).build();
            this.divCheckBox = (o => o.append.apply(o, (this.divLingue.slice(0))))(new quickstart.Div.DivBuilder().setClassName("form-group").append(this.labelLingue)).build();
            let span = new quickstart.Span.SpanBuilder().setClassName("input-group-addon").setText("Livello").build();
            let prova = new quickstart.Div.DivBuilder().setClassName("input-group").append(span, this.livello).build();
            this.divLivello = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.labelLivello, prova).build();
            this.divSignup = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.signup).build();
            this.login = new quickstart.Anchor.AnchorBuilder().setHref("login.html").setClassName("ml-2").setText("Hai gi\u00e0 un account? Accedi!").build();
            this.plogin = new quickstart.Paragraph.ParagraphBuilder().setClassName("text-center").append(this.login).build();
            this.createForm(Signup.SERVLET_URL, this.divEmailPassword, this.divPassword2, this.divCheckBox, this.divLivello, this.divSignup, this.plogin);
        }
        /**
         * Crea e aggiunge un'opzione alla lista di opzioni
         * @param {string} value
         */
        addOptions(value) {
            let op = new quickstart.Option.OptionBuilder().setValue(value).setInnerText(value).build();
            /* add */ (this.options.push(op) > 0);
        }
        /**
         * Crea e formatta una checkbox, in seguito la aggiunge alla lista di checkbox
         * @param {string} name
         */
        addLingue(name) {
            let check = new quickstart.Input.InputBuilder().setType("checkbox").setName(name).setValue(name).setClassName("form-check-input").setId(name).build();
            let labelForCheck = new quickstart.Label.LabelBuilder().setTextContent(name).setClassName("form-check-label").setHTMLFor(name).build();
            let divCheck = new quickstart.Div.DivBuilder().setClassName("form-check").append(check, labelForCheck).build();
            /* add */ (this.lingue.push(check) > 0);
            /* add */ (this.labelForLingue.push(labelForCheck) > 0);
            /* add */ (this.divLingue.push(divCheck) > 0);
        }
        static main(args) {
            new Signup();
        }
    }
    Signup.SERVLET_URL = "signup.jsp";
    quickstart.Signup = Signup;
    Signup["__class"] = "quickstart.Signup";
})(quickstart || (quickstart = {}));
quickstart.Signup.main(null);
