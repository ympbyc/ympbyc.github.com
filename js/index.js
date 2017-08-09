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
