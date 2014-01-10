(use '(web blog))

(blog
 {:title   "Using Sweet.js to Introduce Limited Continuation to JavaScript"
  :author  "ympbyc"
  :date    (java.util.Date. 2013 8 22)
  :content
  [:div
   [:img {:src "/images/sweetjs_shift_reset.png" :width "800"
          :style "padding: 2px; border: 1px solid #444;"}]
   [:div
    [:h3 "Pyramid of Doom"]
    [:p " JavaScript programs make heavy use of asynchronous functions. Asynchronous functions  in JavaScript are achieved by practicing what's called Continuation Passing Style (CPS) where asynchronous functions are applied to callback functions.  Traditionally, these programs suffered from deep nestings of callback functions due to the lack of syntactic support.  Those nests of callback functions are sometimes called " [:strong "Pyramid of Doom"] " or " [:strong "Callback Hell"] "."]
    [:p " To solve the issue, programmers started to use constructs known as promises or features. Using promises, JavaScript codes became Limited Continuation Passing Style.  In which nesting don't occur, but the number of callbacks stays the same as before."]
    [:p " In this post, I present a better solution.  I created macros using sweet.js that implements " [:span.code "shift"] " and " [:span.code "reset"] ", two operators that is used to capture limited continuations."]]
   [:div
    [:h3 "Spec"]
    [:p "Sweet.js provides some ways to define postfix macros.  However, It is impossible to capture continuations of expressions such as " [:span.code "reset(f(g(shift(k=>...))))"] " with a postfix macro.  Due to this restriction, " [:span.code "shift"] " shall be implemented as a statement construct.  This way, the macro only has to look at the statements that follow the "    [:span.code "shift"] " statement."]
    [:pre
     [:code
"reset {
  ...
  shift_let <var> = <function>
  <continuation>...
}"]]
    [:p [:span.code "shift_let"] " takes <function> and give it the continuation. When the continuation gets invoked with a value, the value gets bound to <var>."]]
   [:div
    [:h3 "Implementation"]
    [:pre
     [:code
"macro reset {
  rule { {$exprs...} } => {
    (function () { $exprs... })()
  }
}

macro shift_let {
  rule { $var = $fn $rest...} => {
    $fn(function ($var) { $rest... })
  }
}"]]]
   [:div
    [:h3 "Usage"]
    [:pre
     [:code
"reset {
  shift_let name = getName
  shift_let data  = (function (continuation) {
      $.getJSON('http://.../users/' + name, continuation)
  })
  console.log(name)
  console.log(data)
}

//ヘルパ
function getName (continuation) {
  $('#some-input').on('change', function () {
    continuation($(this).val())
  })
}"]]
    [:p "Notice how asynchronous operations are written flat with no use of callbacks."]]]})
