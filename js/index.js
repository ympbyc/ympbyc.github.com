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


var images = ["images/fusuma-led.jpg",
              "images/river.jpg",
              "images/outdoor-electronics.jpg",
              "images/outdoor-cooking.jpg",
              "images/tanabata.jpg"];


document.addEventListener("DOMContentLoaded", function () {
    var dissolver = document.querySelector("#dissolver");
    var body = document.body;
    var i = 0;
    var frame = 0;

    function dissolve () {
        if (frame++ % 3 < 2) {
            requestAnimationFrame(dissolve);
            return;
        }

        var alpha = parseFloat(dissolver.getAttribute("data-alpha"));
        if (alpha < 1) {
            requestAnimationFrame(dissolve);
            dissolver.style.backgroundColor = "rgba(255,255,255," + (alpha + 0.06) + ")";
            dissolver.setAttribute("data-alpha", alpha + 0.08);
            return;
        }
        body.style.backgroundImage = "url(" + images[i % images.length] + ")";
        setTimeout(_.partial(requestAnimationFrame, clear), 1000);
    }

    function clear () {
        if (frame++ % 3 < 2) {
            requestAnimationFrame(clear);
            return;
        }
        var alpha = parseFloat(dissolver.getAttribute("data-alpha"));
        if (alpha > 0) {
            requestAnimationFrame(clear);
            dissolver.style.backgroundColor = "rgba(255,255,255," + (alpha - 0.06) + ")";
            dissolver.setAttribute("data-alpha", alpha - 0.08);
            return;
        }
    }


    setInterval(function () {
        i++;
        requestAnimationFrame(dissolve);
    }, 120000);
});

document.addEventListener("DOMContentLoaded", function () {
    var els = document.querySelectorAll(".alternate");
    window.els = els;
    console.log(els);
    _.chain(els).map(function (el) {
        return el.getAttribute("data-src-alt");
    }).union(images).each(function (url) {
        var img = document.createElement("img");
        img.setAttribute("src", url);
        img.style.display = "none";
        document.body.appendChild(img);
    });

    var headerH1 = document.querySelector("header h1");
    var faceEl = document.querySelector(".face");
    window.addEventListener("scroll", function (e) {
        faceEl.style.height = (109 - Math.min(window.pageYOffset/10, 50)) + "px";
        headerH1.style.marginTop = 0;
        headerH1.style.paddingTop = (20 - Math.max(window.pageYOffset/10, 0)) + "px";
    });
});

function detatchNode (node) {
    var parent = node.parentNode;
    parent.removeChild(node);
    return node;
}

function animateStyle (el, accessors, prop, before, after, init, stop, step, cb) {
    cb = cb || function () {};
    var anim;
    var x = init;
    var obj = _.foldl(accessors, function (prop, accsr) {
        return prop[accsr];
    }, el);
    var frame = 0;
    function anim () {
        if (frame++ % 2 == 0) {
            requestAnimationFrame(anim);
            return;
        }
        if ((init < stop && x >= stop)
            || (init > stop && x <= stop))
        { cb(); return; }
        requestAnimationFrame(anim);
        obj[prop] = before + x + after;
        x += step;
    }
    requestAnimationFrame(anim);
}

document.addEventListener("DOMContentLoaded", function () {
    var sects = document.querySelectorAll("#content>.section");
    var overlay = document.querySelector("#overlay");
    _.each(sects, function (el) {
        el.addEventListener("click", function (e) {
            e.stopPropagation();
            var detail = el.querySelector(".detail");
            if (! detail) return;
            var node = detail.cloneNode(true);
            overlay.appendChild(node);
            overlay.style.visibility = "visible";
            node.style.display = "block";
            overlay.style.top = parseInt(window.getComputedStyle(document.querySelector("header")).height) + "px";
            if (detail.classList.contains("no-transition"))
                overlay.style.opacity = 1;
            else
                animateStyle(overlay, ["style"], "opacity", "", "", 0, 1, 0.02);
        });
    });
    overlay.addEventListener("click", function (e) {
        if (overlay.querySelector(".detail").classList.contains("no-transition")) {
            overlay.style.opacity = 0;
            overlay.style.visibility = "hidden";
            overlay.removeChild(overlay.firstChild);
            return;
        }
        animateStyle(overlay, ["style"], "opacity", "", "", 1, 0, -0.02, function () {
            overlay.style.visibility = "hidden";
            overlay.removeChild(overlay.firstChild);
        });
    });
});
