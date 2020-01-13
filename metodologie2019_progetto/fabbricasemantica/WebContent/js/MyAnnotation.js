/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe per pagina myAnnotation.html
     * @author Savino
     * @extends quickstart.BasePage
     * @class
     */
    class MyAnnotation extends quickstart.BasePage {
        constructor() {
            super();
            if (this.l1 === undefined)
                this.l1 = null;
            if (this.words === undefined)
                this.words = null;
            if (this.selected === undefined)
                this.selected = null;
            if (this.synonyms === undefined)
                this.synonyms = null;
            if (this.hWords === undefined)
                this.hWords = null;
            if (this.sections === undefined)
                this.sections = null;
            if (this.reset === undefined)
                this.reset = null;
            if (this.divBox === undefined)
                this.divBox = null;
            this.l1 = new quickstart.Label.LabelBuilder().setTextContent("Scegli i sinonimi corretti per le seguenti parole").setAttribute("style", "font-weight:bold").setClassName("form-control-plaintext").build();
            this.appendContainer(this.l1);
            this.words = ([]);
            for (let i = 0; i < 3; i++) {
                this.createWords();
            }
            this.selected = ([]);
            this.createSelected("selected1");
            this.createSelected("selected2");
            this.createSelected("selected3");
            this.synonyms = ([]);
            this.createSynonym("synonym1", /* get */ this.selected[0]);
            this.createSynonym("synonym2", /* get */ this.selected[0]);
            this.createSynonym("synonym3", /* get */ this.selected[0]);
            this.createSynonym("synonym4", /* get */ this.selected[1]);
            this.createSynonym("synonym5", /* get */ this.selected[1]);
            this.createSynonym("synonym6", /* get */ this.selected[1]);
            this.createSynonym("synonym7", /* get */ this.selected[2]);
            this.createSynonym("synonym8", /* get */ this.selected[2]);
            this.createSynonym("synonym9", /* get */ this.selected[2]);
            this.sections = ([]);
            this.createSection(/* get */ this.words[0], /* get */ this.selected[0], /* get */ this.synonyms[0], /* get */ this.synonyms[1], /* get */ this.synonyms[2]);
            this.createSection(/* get */ this.words[1], /* get */ this.selected[1], /* get */ this.synonyms[3], /* get */ this.synonyms[4], /* get */ this.synonyms[5]);
            this.createSection(/* get */ this.words[2], /* get */ this.selected[2], /* get */ this.synonyms[6], /* get */ this.synonyms[7], /* get */ this.synonyms[8]);
            this.hWords = ([]);
            /* add */ (this.hWords.push(this.hidden("hWord1")) > 0);
            /* add */ (this.hWords.push(this.hidden("hWord2")) > 0);
            /* add */ (this.hWords.push(this.hidden("hWord3")) > 0);
            this.divBox = (o => o.append.apply(o, (this.hWords.slice(0))))((o => o.append.apply(o, (this.sections.slice(0))))(new quickstart.Div.DivBuilder().setClassName("card-deck mb-3 text-center"))).build();
            $.getJSON(quickstart.BasePage.REST_URL, "task=MY_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let words = (json["words"]);
                let synonyms = (json["synonyms"]);
                for (let i = 0; i < this.words.length; i++) {
                    $(/* get */ this.words[i]).text(words[i]);
                }
                for (let i = 0; i < this.synonyms.length; i++) {
                    $(/* get */ this.synonyms[i]).attr("value", synonyms[i]);
                }
                for (let i = 0; i < this.hWords.length; i++) {
                    $(/* get */ this.hWords[i]).attr("value", words[i]);
                }
                return null;
            });
            this.reset = new quickstart.Input.InputBuilder().setType("reset").setClassName("btn btn-outline-danger").build();
            this.createForm(MyAnnotation.__quickstart_MyAnnotation_SERVLET_URL, this.divBox, this.reset);
        }
        /**
         * Crea i bottoni per i vari sinonimi
         * @param {string} id
         * @param {HTMLInputElement} field
         */
        createSynonym(id, field) {
            let synonym = new quickstart.Input.InputBuilder().setClassName("btn btn-outline-dark").setType("button").setId(id).onClick((click) => MyAnnotation.buttonClick(id, field)).build();
            /* add */ (this.synonyms.push(synonym) > 0);
        }
        /**
         * Crea le caselle di testo dove verranno inseriti i sinonimi
         * @param {string} name
         */
        createSelected(name) {
            let selected = new quickstart.Input.InputBuilder().setType("text").setName(name).readOnly().build();
            /* add */ (this.selected.push(selected) > 0);
        }
        /**
         * Crea le label per le words
         */
        createWords() {
            let word = new quickstart.Label.LabelBuilder().build();
            /* add */ (this.words.push(word) > 0);
        }
        createSection(word, selected, ...buttons) {
            let div = new quickstart.Div.DivBuilder().setClassName("card mb-4 shadow-sm").append(word).append(selected).append(...buttons).build();
            /* add */ (this.sections.push(div) > 0);
        }
        /**
         * Inserisce il valore del sinonimo selezionato nella casella di testo
         * @param {string} id
         * @param {HTMLInputElement} field
         * @return
         * @return {*}
         */
        static buttonClick(id, field) {
            field.value = document.getElementById(id).value;
            return null;
        }
        static main(args) {
            new MyAnnotation();
        }
    }
    MyAnnotation.__quickstart_MyAnnotation_SERVLET_URL = "myAnnotation.jsp";
    quickstart.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "quickstart.MyAnnotation";
})(quickstart || (quickstart = {}));
quickstart.MyAnnotation.main(null);
