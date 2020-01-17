/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che crea la pagina SenseAnnotation
     * @author Savino
     * @extends quickstart.BasePage
     * @class
     */
    class SenseAnnotation extends quickstart.BasePage {
        constructor() {
            super();
            if (this.request1 === undefined)
                this.request1 = null;
            if (this.word === undefined)
                this.word = null;
            if (this.request2 === undefined)
                this.request2 = null;
            if (this.description === undefined)
                this.description = null;
            if (this.checks === undefined)
                this.checks = null;
            if (this.lChecks === undefined)
                this.lChecks = null;
            if (this.divChecks === undefined)
                this.divChecks = null;
            if (this.divWord === undefined)
                this.divWord = null;
            if (this.checkContainer === undefined)
                this.checkContainer = null;
            if (this.hWord === undefined)
                this.hWord = null;
            if (this.hDescription === undefined)
                this.hDescription = null;
            this.request1 = new quickstart.Label.LabelBuilder().setTextContent("Seleziona il significato corretto della parola \"").setAttribute("style", "font-weight:bold").build();
            this.word = new quickstart.Label.LabelBuilder().setAttribute("style", "font-weight:bold").build();
            this.request2 = new quickstart.Label.LabelBuilder().setTextContent("\" nella seguente frase").setAttribute("style", "font-weight:bold").build();
            this.description = new quickstart.Label.LabelBuilder().css("display", "block").css("text-align", "center").build();
            this.hWord = this.hidden("hWord");
            this.hDescription = this.hidden("hDescription");
            this.checks = ([]);
            this.lChecks = ([]);
            this.divChecks = ([]);
            this.createCheck("check1");
            this.createCheck("check2");
            this.createCheck("check3");
            this.createCheck("check4");
            $.getJSON(quickstart.BasePage.REST_URL, "task=SENSE_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sDescription = (json["description"]);
                let senses = (json["senses"]);
                $(this.word).text(sWord);
                $(this.hWord).attr("value", sWord);
                $(this.description).text(sDescription);
                $(this.hDescription).attr("value", sDescription);
                for (let i = 0; i < this.checks.length; i++) {
                    {
                        $(/* get */ this.lChecks[i]).text(senses[i]);
                        $(/* get */ this.checks[i]).attr("value", senses[i]);
                    }
                    ;
                }
                return null;
            });
            this.divWord = new quickstart.Div.DivBuilder().setClassName("form-inline").append(this.request1).append(this.word).append(this.request2).build();
            this.appendContainer(this.divWord);
            this.checkContainer = (o => o.append.apply(o, (this.divChecks.slice(0))))(new quickstart.Div.DivBuilder().setClassName("form-check")).css("margin-top", "10px").css("margin-right", "15px").build();
            this.createForm(SenseAnnotation.__quickstart_SenseAnnotation_SERVLET_URL, this.hWord, this.hDescription, this.description, this.checkContainer);
        }
        /**
         * Crea una checkbox con la sua label e li formatta all'interno di un div
         * @param {string} id id della checkbox
         */
        createCheck(id) {
            let check = new quickstart.Input.InputBuilder().setType("checkbox").setName("check[]").setId(id).build();
            let lCheck = new quickstart.Label.LabelBuilder().setHTMLFor(id).setClassName("form-control").css("height", "100%").build();
            let inputGroupText = new quickstart.Div.DivBuilder().setClassName("input-group-text").append(check).build();
            let prepend = new quickstart.Div.DivBuilder().setClassName("input-group-prepend").append(inputGroupText).build();
            let divCheck = new quickstart.Div.DivBuilder().setClassName("input-group mb-3").append(prepend).append(lCheck).build();
            /* add */ (this.checks.push(check) > 0);
            /* add */ (this.lChecks.push(lCheck) > 0);
            /* add */ (this.divChecks.push(divCheck) > 0);
        }
        static main(args) {
            new SenseAnnotation();
        }
    }
    /**
     * Indirizzo per la servlet di senseAnnotation
     */
    SenseAnnotation.__quickstart_SenseAnnotation_SERVLET_URL = "senseAnnotation.jsp";
    quickstart.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "quickstart.SenseAnnotation";
})(quickstart || (quickstart = {}));
quickstart.SenseAnnotation.main(null);
