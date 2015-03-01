(function () {
    window.addEventListener("load", function () {
        _.toArray(document.querySelectorAll(".btn-demo")).forEach(function (el) {
            el.addEventListener("click", eval_codes);
        });
    });

    function eval_codes () {
        var code = "";
        this.dataset.codes.split(" ").forEach(function (id) {
            var codeEl = document.getElementById(id);
            code += codeEl.innerText || codeEl.textContent;
        });
        console.log(code);
        eval(code);
    }
}());
