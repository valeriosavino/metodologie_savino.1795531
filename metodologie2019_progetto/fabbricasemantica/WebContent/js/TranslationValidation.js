/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TranslationValidation extends quickstart.BasePage {
        constructor() {
            super();
            if (this.l1 === undefined)
                this.l1 = null;
            if (this.word === undefined)
                this.word = null;
            if (this.description === undefined)
                this.description = null;
            if (this.checks === undefined)
                this.checks = null;
            if (this.lChecks === undefined)
                this.lChecks = null;
            if (this.divChecks === undefined)
                this.divChecks = null;
            if (this.hWord === undefined)
                this.hWord = null;
            if (this.hDescription === undefined)
                this.hDescription = null;
            if (this.divCheckBox === undefined)
                this.divCheckBox = null;
            this.l1 = new quickstart.Label.LabelBuilder().setTextContent("Data la seguente parola e la sua definizione, scegliere la miglior traduzione").setClassName("form-control-plaintext").setAttribute("style", "font-weight:bold").build();
            this.appendContainer(this.l1);
            this.word = new quickstart.Label.LabelBuilder().setClassName("form-control-plaintext").build();
            this.hWord = this.hidden("hWord");
            this.description = new quickstart.Label.LabelBuilder().setClassName("form-control-plaintext").build();
            this.hDescription = this.hidden("hDescription");
            this.checks = ([]);
            this.lChecks = ([]);
            this.divChecks = ([]);
            for (let i = 0; i < 5; i++) {
                this.createCheckForLists("check" + i);
            }
            $.getJSON(quickstart.BasePage.REST_URL, "task=TRANSLATION_VALIDATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sDescription = (json["description"]);
                let translations = (json["translations"]);
                $(this.word).text(sWord);
                $(this.hWord).attr("value", sWord);
                $(this.description).text(sDescription);
                $(this.hDescription).attr("value", sDescription);
                for (let i = 0; i < this.checks.length - 1; i++) {
                    {
                        $(/* get */ this.checks[i]).attr("value", translations[i]);
                        $(/* get */ this.lChecks[i]).text(translations[i]);
                    }
                    ;
                }
                $(/* get */ this.checks[this.checks.length - 1]).attr("value", "Nessuna delle precedenti");
                $(/* get */ this.lChecks[this.lChecks.length - 1]).text("Nessuna delle precedenti");
                return null;
            });
            this.divCheckBox = (o => o.append.apply(o, (this.divChecks.slice(0))))(new quickstart.Div.DivBuilder()).append(this.hWord, this.hDescription).build();
            this.createForm(TranslationValidation.__quickstart_TranslationValidation_SERVLET_URL, this.word, this.description, this.divCheckBox);
        }
        /**
         * Crea una checkbox con la sua label e li formatta all'interno di un div
         * @param {string} id
         */
        createCheckForLists(id) {
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
            new TranslationValidation();
        }
    }
    TranslationValidation.__quickstart_TranslationValidation_SERVLET_URL = "translationValidation.jsp";
    quickstart.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "quickstart.TranslationValidation";
})(quickstart || (quickstart = {}));
quickstart.TranslationValidation.main(null);
