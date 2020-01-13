/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class DefinitionAnnotation extends quickstart.BasePage {
        constructor() {
            super();
            if (this.l1 === undefined)
                this.l1 = null;
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
            if (this.divText === undefined)
                this.divText = null;
            this.l1 = new quickstart.Label.LabelBuilder().setTextContent("Data la seguente parola e il suo iperonimo, fornire una definizione nella tua lingua").setClassName("form-control-plaintext").setAttribute("style", "font-weight:bold").build();
            this.word = new quickstart.Label.LabelBuilder().setClassName("form-control-plaintext").build();
            this.hypernym = new quickstart.Label.LabelBuilder().setClassName("form-control-plaintext").build();
            this.hWord = this.hidden("hWord");
            this.hHypernym = this.hidden("hHypernym");
            $.getJSON(quickstart.BasePage.REST_URL, "task=DEFINITION_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sHypernym = (json["hypernym"]);
                $(this.word).text(sWord);
                $(this.hypernym).text(sHypernym);
                $(this.hWord).attr("value", sWord);
                $(this.hHypernym).attr("value", sHypernym);
                return null;
            });
            this.definition = new quickstart.TextArea.TextAreaBuilder().setPlaceholder("Inserisci qui la tua risposta").setClassName("form-control").setName("definition").build();
            this.divText = new quickstart.Div.DivBuilder().setClassName("form-group").append(this.l1).append(this.word).append(this.hypernym).append(this.definition).build();
            this.createForm(DefinitionAnnotation.__quickstart_DefinitionAnnotation_SERVLET_URL, this.divText, this.hWord, this.hHypernym);
        }
        static main(args) {
            new DefinitionAnnotation();
        }
    }
    DefinitionAnnotation.__quickstart_DefinitionAnnotation_SERVLET_URL = "definitionAnnotation.jsp";
    quickstart.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "quickstart.DefinitionAnnotation";
})(quickstart || (quickstart = {}));
quickstart.DefinitionAnnotation.main(null);
