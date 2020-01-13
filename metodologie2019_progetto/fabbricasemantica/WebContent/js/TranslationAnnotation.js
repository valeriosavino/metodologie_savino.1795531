/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TranslationAnnotation extends quickstart.BasePage {
        constructor() {
            super();
            if (this.l1 === undefined)
                this.l1 = null;
            if (this.word === undefined)
                this.word = null;
            if (this.description === undefined)
                this.description = null;
            if (this.translation === undefined)
                this.translation = null;
            if (this.divText === undefined)
                this.divText = null;
            if (this.hWord === undefined)
                this.hWord = null;
            if (this.hDescription === undefined)
                this.hDescription = null;
            if (this.divWordDescr === undefined)
                this.divWordDescr = null;
            this.l1 = new quickstart.Label.LabelBuilder().setTextContent("Data la seguente parola e definizione in inglese, fornire la traduzione nella tua lingua madre").setAttribute("style", "font-weight: bold").setClassName("form-control-plaintext").build();
            this.appendContainer(this.l1);
            this.word = new quickstart.Label.LabelBuilder().build();
            this.description = new quickstart.Label.LabelBuilder().css("display", "block").build();
            this.hWord = this.hidden("hWord");
            this.hDescription = this.hidden("hDescription");
            $.getJSON(quickstart.BasePage.REST_URL, "task=TRANSLATION_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sDescription = (json["description"]);
                $(this.word).text("Parola: " + sWord);
                $(this.hWord).attr("value", sWord);
                $(this.description).text("Descrizione: " + sDescription);
                $(this.hDescription).attr("value", sDescription);
                return null;
            });
            this.translation = new quickstart.TextArea.TextAreaBuilder().setName("translation").setClassName("form-control").setPlaceholder("Inserisci qui la tua risposta...").build();
            this.divWordDescr = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.word, this.description).build();
            this.divText = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.divWordDescr, this.translation).build();
            this.createForm(TranslationAnnotation.__quickstart_TranslationAnnotation_SERVLET_URL, this.divText, this.hWord, this.hDescription);
        }
        static main(args) {
            new TranslationAnnotation();
        }
    }
    TranslationAnnotation.__quickstart_TranslationAnnotation_SERVLET_URL = "translationAnnotation.jsp";
    quickstart.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "quickstart.TranslationAnnotation";
})(quickstart || (quickstart = {}));
quickstart.TranslationAnnotation.main(null);
