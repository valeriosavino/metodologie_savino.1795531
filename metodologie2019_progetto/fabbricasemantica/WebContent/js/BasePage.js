/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe astratta che fa da base per la pagina home e tutte le pagine dei tasks
     * @author Savino
     * @class
     */
    class BasePage {
        constructor(text) {
            if (((typeof text === 'string') || text === null)) {
                let __args = arguments;
                {
                    let __args = arguments;
                    if (this.request === undefined)
                        this.request = null;
                    if (this.container === undefined)
                        this.container = null;
                    if (this.request === undefined)
                        this.request = null;
                    if (this.container === undefined)
                        this.container = null;
                    (() => {
                        this.checkSession();
                        $("body").append(this.createNavbar());
                        this.container = new quickstart.Div.DivBuilder().setClassName("container").build();
                    })();
                }
                (() => {
                    this.request = new quickstart.Label.LabelBuilder().setTextContent(text).setClassName("form-control-plaintext").setAttribute("style", "font-weight:bold").build();
                    this.appendContainer(this.request);
                })();
            }
            else if (text === undefined) {
                let __args = arguments;
                if (this.request === undefined)
                    this.request = null;
                if (this.container === undefined)
                    this.container = null;
                if (this.request === undefined)
                    this.request = null;
                if (this.container === undefined)
                    this.container = null;
                (() => {
                    this.checkSession();
                    $("body").append(this.createNavbar());
                    this.container = new quickstart.Div.DivBuilder().setClassName("container").build();
                })();
            }
            else
                throw new Error('invalid overload');
        }
        /**
         * Controlla se � stata settata la sessione all'interno delle pagine
         */
        checkSession() {
            $.getJSON(BasePage.AUTHENTICATION_URL, (result, a, ctx) => {
                let json = result;
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(json.toString(), "false"))
                    window.location.href = "login.html";
                return null;
            });
        }
        /**
         * Crea e restituisce la navbar con i collegamenti all'uscita del programma e alla home
         * @return {HTMLDivElement} navbar formattata
         */
        createNavbar() {
            let home = new quickstart.Anchor.AnchorBuilder().setHref("home.html").setClassName("navbar-brand").setText("FabbricaSemantica").build();
            let logout = new quickstart.Anchor.AnchorBuilder().setText("ESCI").setHref(BasePage.SERVLET_URL).setClassName("btn btn-outline-info my-2 my-sm-0").build();
            return new quickstart.Div.DivBuilder().setClassName("navbar navbar-dark bg-dark").append(home).append(logout).build();
        }
        /**
         * Restituisce un indirizzo casuale di uno dei task
         * @return {string} stringa contenente indirizzo di un task
         * @private
         */
        /*private*/ getNextTask() {
            let tasks = ["translationAnnotation.html", "wordAnnotation.html", "definitionAnnotation.html", "senseAnnotation.html", "translationValidation.html", "senseValidation.html", "myAnnotation.html"];
            return tasks[((Math.random() * tasks.length) | 0)];
        }
        /**
         * Crea i bottoni NEXT e SKIP e li formatta in un div
         * @return {HTMLDivElement} div con bottoni NEXT e SKIP al suo interno
         */
        createButtonsNextSkip() {
            let next = new quickstart.Input.InputBuilder().setType("submit").setValue("AVANTI").setName("avanti").setClassName("btn btn-primary btn-lg").build();
            let skip = new quickstart.Input.InputBuilder().setType("button").setValue("SALTA").setName("SALTA").css("margin-left", "10px").setClassName("btn btn-primary btn-lg").onClick((click) => window.location.href = this.getNextTask()).build();
            return new quickstart.Div.DivBuilder().setAlign("right").setClassName("form-group").css("margin-top", "15px").append(next).append(skip).build();
        }
        /**
         * Crea degli input nascosti
         * @param {string} name nome dell'input
         * @return {HTMLInputElement} input nascosto
         */
        hidden(name) {
            return new quickstart.Input.InputBuilder().setType("hidden").setName(name).build();
        }
        /**
         * Crea il form della pagina
         * @param {string} servlet_url indirizzo della servlet a cui inviare i dati del form
         * @param {Array} e elementi da inserire nel form
         */
        createForm(servlet_url, ...e) {
            let card = (o => o.append.apply(o, e))(new quickstart.Div.DivBuilder().setClassName("card").css("background-color", "#D9EDF7")).build();
            let form = new quickstart.Form.FormBuilder().setAction(servlet_url).append(card).setMethod("POST").append(this.createButtonsNextSkip()).build();
            this.appendContainer(form);
        }
        /**
         * Crea il container con gli elementi forniti dalle pagine
         * @param {Array} e elementi della pagina
         */
        appendContainer(...e) {
            $(this.container).append(...e);
            this.appendBody();
        }
        /**
         * Inserisce il container nella navbar
         * @private
         */
        /*private*/ appendBody() {
            $("body").append(this.container);
        }
    }
    /**
     * Contiene l'indirizzo della servlet per effettuare il logout
     */
    BasePage.SERVLET_URL = "logout.jsp";
    /**
     * Contiene l'indirizzo della servlet per il controllo della sessione
     */
    BasePage.AUTHENTICATION_URL = "isLoggedIn.jsp";
    /**
     * Contiene l'indirizzo della servlet dello StandardDataProvider
     */
    BasePage.REST_URL = "nextExample.jsp";
    quickstart.BasePage = BasePage;
    BasePage["__class"] = "quickstart.BasePage";
})(quickstart || (quickstart = {}));
