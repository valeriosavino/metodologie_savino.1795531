/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe per creazione della pagina senseValidation.html
     * @author Savino
     * @extends quickstart.BasePage
     * @class
     */
    class SenseValidation extends quickstart.BasePage {
        constructor() {
            super("Data la seguente parola e frase in inglese, verificare se il senso fornito \u00e8 appropriato");
            if (this.word === undefined)
                this.word = null;
            if (this.example === undefined)
                this.example = null;
            if (this.sense === undefined)
                this.sense = null;
            if (this.si === undefined)
                this.si = null;
            if (this.no === undefined)
                this.no = null;
            if (this.lSi === undefined)
                this.lSi = null;
            if (this.lNo === undefined)
                this.lNo = null;
            if (this.divRadioSi === undefined)
                this.divRadioSi = null;
            if (this.divRadioNo === undefined)
                this.divRadioNo = null;
            if (this.divRadio === undefined)
                this.divRadio = null;
            if (this.hWord === undefined)
                this.hWord = null;
            if (this.hExample === undefined)
                this.hExample = null;
            if (this.hSense === undefined)
                this.hSense = null;
            this.word = new quickstart.Label.LabelBuilder().css("display", "block").css("text-align", "center").build();
            this.example = new quickstart.Label.LabelBuilder().css("display", "block").css("text-align", "center").build();
            this.sense = new quickstart.Label.LabelBuilder().css("display", "block").css("text-align", "center").build();
            this.si = new quickstart.Input.InputBuilder().setClassName("form-check-input").setType("radio").setName("radio").setId("si").setValue("si").build();
            this.lSi = new quickstart.Label.LabelBuilder().setClassName("form-check-label").setHTMLFor("si").setTextContent("SI").build();
            this.no = new quickstart.Input.InputBuilder().setClassName("form-check-input").setType("radio").setName("radio").setId("no").setValue("no").build();
            this.lNo = new quickstart.Label.LabelBuilder().setClassName("form-check-label").setHTMLFor("si").setTextContent("NO").build();
            this.hWord = this.hidden("hWord");
            this.hExample = this.hidden("hExample");
            this.hSense = this.hidden("hSense");
            $.getJSON(quickstart.BasePage.REST_URL, "task=SENSE_VALIDATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sExample = (json["example"]);
                let sSense = (json["sense"]);
                $(this.word).text("Parola: " + sWord);
                $(this.example).text("Esempio: " + sExample);
                $(this.sense).text("Senso: " + sSense);
                $(this.hWord).attr("value", sWord);
                $(this.hExample).attr("value", sExample);
                $(this.hSense).attr("value", sSense);
                return null;
            });
            this.divRadioSi = new quickstart.Div.DivBuilder().setClassName("form-check").append(this.si, this.lSi).build();
            this.divRadioNo = new quickstart.Div.DivBuilder().setClassName("form-check").append(this.no, this.lNo).build();
            this.divRadio = new quickstart.Div.DivBuilder().setClassName("form-check form-check-inline").append(this.divRadioSi, this.divRadioNo).css("margin", "auto").build();
            this.createForm(SenseValidation.__quickstart_SenseValidation_SERVLET_URL, this.word, this.example, this.sense, this.divRadio, this.hWord, this.hExample, this.hSense);
        }
        static main(args) {
            new SenseValidation();
        }
    }
    /**
     * Indirizzo della servlet per SenseValidation
     */
    SenseValidation.__quickstart_SenseValidation_SERVLET_URL = "senseValidation.jsp";
    quickstart.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "quickstart.SenseValidation";
})(quickstart || (quickstart = {}));
quickstart.SenseValidation.main(null);
