function alternate (e) {
    if (! e.target.classList.contains("alternate"))
        return true;
    var src = e.target.getAttribute("data-src");
    var alt = e.target.getAttribute("data-src-alt");
    e.target.style.backgroundImage = "url(" + alt + ")";
    e.target.setAttribute("data-src-alt", src);
    e.target.setAttribute("data-src", alt);
    return true;
}

document.addEventListener("mouseover", alternate);
document.addEventListener("mouseout", alternate);


var images = ["images/outdoor-cooking.jpg",
              "images/outdoor-electronics.jpg",
              "images/tanabata.jpg"];

document.addEventListener("DOMContentLoaded", function () {
    var dissolver = document.querySelector("#dissolver");
    var body = document.body;
    var i = 0;

    function dissolve () {
        var alpha = parseFloat(dissolver.getAttribute("data-alpha"));
        if (alpha < 1) {
            requestAnimationFrame(dissolve);
            dissolver.style.backgroundColor = "rgba(255,255,255," + (alpha + 0.02) + ")";
            dissolver.setAttribute("data-alpha", alpha + 0.02);
            return;
        }
        body.style.backgroundImage = "url(" + images[i % images.length] + ")";
        setTimeout(_.partial(requestAnimationFrame, clear), 1000);
    }

    function clear () {
        var alpha = parseFloat(dissolver.getAttribute("data-alpha"));
        if (alpha > 0) {
            requestAnimationFrame(clear);
            dissolver.style.backgroundColor = "rgba(255,255,255," + (alpha - 0.02) + ")";
            dissolver.setAttribute("data-alpha", alpha - 0.02);
            return;
        }
    }


    setInterval(function () {
        i++;
        requestAnimationFrame(dissolve);
    }, 20000);
});

document.addEventListener("DOMContentLoaded", function () {
    var els = document.querySelectorAll(".alternate");
    window.els = els;
    console.log(els);
    _.each(els, function (el) {
        var img = document.createElement("img");
        img.setAttribute("src", el.getAttribute("data-src-alt"));
        img.style.display = "none";
        document.body.appendChild(img);
    });
});
