/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Crea la pagina iniziale del sito FabbricaSemantica
     * @author Savino
     * @extends quickstart.BasePage
     * @class
     */
    class Home extends quickstart.BasePage {
        constructor() {
            super();
            if (this.fs === undefined)
                this.fs = null;
            if (this.start === undefined)
                this.start = null;
            if (this.divImg1 === undefined)
                this.divImg1 = null;
            if (this.divImg2 === undefined)
                this.divImg2 = null;
            this.checkSession();
            this.fs = new quickstart.Image.ImageBuilder().src("logo.jpg").setAttribute("style", "width:80%;height:50%;").build();
            this.start = new quickstart.Image.ImageBuilder().src("play.jpg").onClick((click) => window.location.href = Home.TASK_URL).setAttribute("style", "width:200px;height:200px;").setClassName("center").build();
            this.divImg1 = new quickstart.Div.DivBuilder().setAlign("center").append(this.fs).build();
            this.divImg2 = new quickstart.Div.DivBuilder().setAlign("center").append(this.start).build();
            this.appendContainer(this.divImg1, this.divImg2);
        }
        static main(args) {
            new Home();
        }
    }
    /**
     * Contiene l'indirizzo di TranslationAnnotation
     */
    Home.TASK_URL = "translationAnnotation.html";
    quickstart.Home = Home;
    Home["__class"] = "quickstart.Home";
})(quickstart || (quickstart = {}));
quickstart.Home.main(null);
