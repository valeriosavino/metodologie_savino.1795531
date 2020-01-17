/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe su cui si vuole costruire oggetto Image
     * @author Savino
     * @class
     */
    class Image {
        constructor() {
        }
    }
    quickstart.Image = Image;
    Image["__class"] = "quickstart.Image";
    (function (Image) {
        /**
         * Crea l'oggetto image
         * @class
         * @extends quickstart.Builder
         * @author Savino
         */
        class ImageBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.img === undefined)
                    this.img = null;
                this.img = document.createElement("img");
            }
            /**
             * Assegna un indirizzo URL all'immagine
             * @param {string} src URL dell'immagine
             * @return {quickstart.Image.ImageBuilder} oggetto builder
             */
            src(src) {
                this.img.src = src;
                return this;
            }
            /**
             * Modifica gli attributi dell'immagine
             * @param {string} name nome dell'attributo
             * @param {string} value valore dell'attributo
             * @return {quickstart.Image.ImageBuilder} oggetto builder
             */
            setAttribute(name, value) {
                this.img.setAttribute(name, value);
                return this;
            }
            /**
             * Applica una funzione al click dell'immagine
             * @param {*} f funzione da applicare
             * @return {quickstart.Image.ImageBuilder} oggetto builder
             */
            onClick(f) {
                this.img.onclick = (f);
                return this;
            }
            /**
             *
             * @param {string} className
             * @return {quickstart.Image.ImageBuilder}
             */
            setClassName(className) {
                this.img.className = className;
                return this;
            }
            /**
             *
             * @param {string} property
             * @param {string} value
             * @return {quickstart.Image.ImageBuilder}
             */
            css(property, value) {
                $(this.img).css(property, value);
                return this;
            }
            /**
             *
             * @return {HTMLImageElement}
             */
            build() {
                return this.img;
            }
        }
        Image.ImageBuilder = ImageBuilder;
        ImageBuilder["__class"] = "quickstart.Image.ImageBuilder";
    })(Image = quickstart.Image || (quickstart.Image = {}));
})(quickstart || (quickstart = {}));
