/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class WordAnnotation extends quickstart.BasePage {
        constructor() {
            super();
            if (this.title === undefined)
                this.title = null;
            if (this.description === undefined)
                this.description = null;
            if (this.hDescription === undefined)
                this.hDescription = null;
            if (this.word === undefined)
                this.word = null;
            if (this.splitDescription === undefined)
                this.splitDescription = null;
            if (this.splitWord === undefined)
                this.splitWord = null;
            this.title = new quickstart.Label.LabelBuilder().setTextContent("Data la seguente definizione, provare a indovinare il termine definito").setClassName("form-control-plaintext").setAttribute("style", "font-weight: bold").build();
            this.appendContainer(this.title);
            this.description = new quickstart.Label.LabelBuilder().setClassName("form-control-plaintext").build();
            this.hDescription = this.hidden("hDescription");
            $.getJSON(quickstart.BasePage.REST_URL, "task=WORD_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sDescription = (json["description"]);
                $(this.description).text(sDescription);
                $(this.hDescription).attr("value", sDescription);
                return null;
            });
            this.word = new quickstart.Input.InputBuilder().setType("text").setClassName("form-control").setName("word").required().build();
            this.splitDescription = new quickstart.Div.DivBuilder().setClassName("col").append(this.description, this.hDescription).build();
            this.splitWord = new quickstart.Div.DivBuilder().setClassName("col").append(this.word).build();
            let divRow = new quickstart.Div.DivBuilder().setClassName("row").append(this.splitDescription, this.splitWord).build();
            let container = new quickstart.Div.DivBuilder().setClassName("container").append(divRow).build();
            this.createForm(WordAnnotation.__quickstart_WordAnnotation_SERVLET_URL, container);
        }
        static main(args) {
            new WordAnnotation();
        }
    }
    WordAnnotation.__quickstart_WordAnnotation_SERVLET_URL = "wordAnnotation.jsp";
    quickstart.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "quickstart.WordAnnotation";
})(quickstart || (quickstart = {}));
quickstart.WordAnnotation.main(null);
