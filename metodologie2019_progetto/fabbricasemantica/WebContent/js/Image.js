/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Image {
        constructor() {
        }
    }
    quickstart.Image = Image;
    Image["__class"] = "quickstart.Image";
    (function (Image) {
        class ImageBuilder extends quickstart.Builder {
            constructor() {
                super();
                if (this.img === undefined)
                    this.img = null;
                this.img = document.createElement("img");
            }
            src(src) {
                this.img.src = src;
                return this;
            }
            setAttribute(name, value) {
                this.img.setAttribute(name, value);
                return this;
            }
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
