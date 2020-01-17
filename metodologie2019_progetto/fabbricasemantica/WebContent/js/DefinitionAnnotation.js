/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe per la pagina definitionAnnotation.html
     * @author Savino
     * @extends quickstart.BasePage
     * @class
     */
    class DefinitionAnnotation extends quickstart.BasePage {
        constructor() {
            super("Data la seguente parola e il suo iperonimo, fornire una definizione nella tua lingua");
            if (this.word === undefined)
                this.word = null;
            if (this.hypernym === undefined)
                this.hypernym = null;
            if (this.hWord === undefined)
                this.hWord = null;
            if (this.hHypernym === undefined)
                this.hHypernym = null;
            if (this.definition === undefined)
                this.definition = null;
            if (this.divWordHypernym === undefined)
                this.divWordHypernym = null;
            if (this.divText === undefined)
                this.divText = null;
            this.word = new quickstart.Label.LabelBuilder().css("display", "block").css("text-align", "center").build();
            this.hypernym = new quickstart.Label.LabelBuilder().css("display", "block").css("text-align", "center").build();
            this.hWord = this.hidden("hWord");
            this.hHypernym = this.hidden("hHypernym");
            $.getJSON(quickstart.BasePage.REST_URL, "task=DEFINITION_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sHypernym = (json["hypernym"]);
                $(this.word).text("Parola: " + sWord);
                $(this.hypernym).text("Iperonimo: " + sHypernym);
                $(this.hWord).attr("value", sWord);
                $(this.hHypernym).attr("value", sHypernym);
                return null;
            });
            this.definition = new quickstart.TextArea.TextAreaBuilder().setPlaceholder("Inserisci qui la tua risposta...").setClassName("form-control").setName("definition").build();
            this.divWordHypernym = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.word, this.hypernym).build();
            this.divText = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.divWordHypernym, this.definition).css("margin-left", "15px").css("margin-right", "15px").build();
            this.createForm(DefinitionAnnotation.__quickstart_DefinitionAnnotation_SERVLET_URL, this.divText, this.hWord, this.hHypernym);
        }
        static main(args) {
            new DefinitionAnnotation();
        }
    }
    /**
     * Indirizzo della Servlet di definitionAnnotation
     */
    DefinitionAnnotation.__quickstart_DefinitionAnnotation_SERVLET_URL = "definitionAnnotation.jsp";
    quickstart.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "quickstart.DefinitionAnnotation";
})(quickstart || (quickstart = {}));
quickstart.DefinitionAnnotation.main(null);
