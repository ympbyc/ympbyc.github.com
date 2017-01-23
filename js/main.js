var slideImgs = [
    "images/bike.jpg",
    "images/nakaurawa.jpg",
    "images/painting/kounumakawa.png",
    "images/painting/nakaurawa.png",
    "images/painting/tajimahikawa.png",
    "images/smalltalk.jpg"
];

var slideTimeout = 7000;
var slidesSizes = [];

//get image sizes
slideImgs.forEach(function (src, i) {
    var img = new Image();
    img.addEventListener("load", function () {
        slidesSizes[i] = {width: img.width, height: img.height};
    });
    img.src = src;
});

document.addEventListener("DOMContentLoaded", function () {
    var slidesEl = document.getElementById("header-slides");
    var t = 0;
    var rectsGen = {
        slides: function () { return slidesEl.getBoundingClientRect(); }
    };
    var rects = genAllRects();
    var slideIdx = 0;

    //resize
    window.addEventListener("resize", function () {
        rects = genAllRects();
    });
    setInterval(function () {
        slideIdx = (slideIdx + 1) % slideImgs.length;
        slidesEl.style.backgroundImage = "url(" + slideImgs[slideIdx] + ")";
    }, slideTimeout);
    requestAnimationFrame(function loop () {
        requestAnimationFrame(loop);
        var sin = (Math.sin(t)/2 + 1/2);
        var size = slidesSizes[slideIdx];
        var hCorrection = rects.slides.width / size.width;
        var amplitude = size.height * hCorrection - rects.slides.height;
        slidesEl.style.backgroundPosition = "0 " + -(amplitude * sin) + "px";
        t += 1/100;
    });


    function genAllRects () {
        var rects = {};
        _.each(rectsGen, function (gen, k) {
            rects[k] = gen();
        });
        return rects;
    }
});
