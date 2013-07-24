(use '(web blog))

(blog
 {:title  "Discovery of Curried S-expression"
  :author "ympbyc"
  :date   #inst "3913-01-29T15:00:00.000-00:00"
  :content
  [:div
   [:h2 "Steeling stuff from Haskell"]
   [:p "I wanted to implement a language that is inspired by Haskell. I wanted to understand fully how currying and lazy evaluation works."]
   [:p "I started by creating a set of syntax for the language. At first I thought it would look cool if we could write functions like"]
   [:pre
    [:code
     "cons := head -> tail -> f -> f hed tail
car  := ls -> ls (h -> t -> h)
cdr  := ls -> ls (h -> t -> t)"]]
   [:p "You might have noticed it is an immitation of type signature syntax in Haskell. "]
   [:h2 "Associativity and Precedence"]
   [:p "While it looks nice we quickly encounter the problem of associativity. I always disliked the <em>order of precedence</em> in computer languages.
It simply makes the code unreadable. Here is the list of things I don't like about it:"]
   [:dl
    [:dt "It makes operators too special"]
    [:dd "In functional languages everything is supporsed to be a function. Haskell users might insist that operators are in fact functions. Yes they are but they are undoubtedly special cases in terms of syntax. Every operator has a different associativiy and precedence hence behaviour. In this sense, every operator can be seen as a syntactic form."]
    [:dt "New syntax have to be added"]
    [:dd "In order to define the precedence of operators, a new syntactic form have to be added (in Haskell infix* does it). Adding syntax that're not justified to the language is a huge sin I believe."]
    [:dt "It crashes your brain"]
    [:dd "How are we suppose to remember all the behaviours of unpronounceable symbols that appear randomly in the source code?"]]
   [:h2 "Seeking the Answer"]
   [:p "Rejection of the order of precedence would only mean one thing -- parenthesis"]
   [:pre [:code "fact := n -> n = 0 1 (n * (fact (n - 1)))"]]
   [:p "A new question arises. Why are we treating operators specially in the first place? If operators are functions, shouldn't they follow the same convention as of normal functions? My answer was yes."]
   [:pre [:code "fact := n -> = n 0 1 (* n (fact (- n 1)))"]]
   [:p "Hello S-Expression!"]
   [:h2 "Coming Home"]
   [:p "Lets accept this. If we seek a <strong>clean</strong> set of syntax, we can not get away from S-expression [1]."]
   [:pre [:code "(:= (fact n) (= n 0 1 (* n (fact (- n 1)))))"]]
   [:p "After a long trip I came back to the good old S expressions. With a few souvenirs from the Haskell world. Our functions are now curried; and applications are lazy. Lets exploit these new features a bit."]
   [:pre
    [:code
     " (:= (true  x y) x)
 (:= (false x y) y)
 (:= (if x y z) (x y z))
 (:= (cool? x) true)
 (if (cool? 'me) \"Good\" \"Damn\"))
 (cool? 'you \"Holy\" \"Nuts\")"]]
   [:p "We no longer need <em>if</em> to be a special form! Furthermore, we actually don't even need <em>if</em>! Because arguments to functions are evaluated lazily, it is guaranteed that unmatching clause will never get evaluated."]
   [:pre
    [:code
     " (:= (on) eq?)

 ;;message passing style. see SICP
 (:= (animal name voice =>)
   (on 'name   => name
   (on 'talkTo => (-> (x) (format \"%s said %s to %s\" [name voice x]))
   nil)))

 (:= (felix) (animal \"Felix the Cat\" \"meooow\"))
 (felix 'name)        ;;=> \"Felix the Cat\"
 (felix 'talkTo \"me\") ;;=> \"Felix the Cat said meooow to me\""]]
   [:p "Notice the last line? In Lisp we would have to write "
    [:span.code "((felix 'talkTo) \"me\")"]
    " which sucks. By dropping variable number arguments, we could write real message passing in S expression."]
   [:h2 "Conclusion"]
   [:p "I started my journey from Haskell by taking its two important features, laziness and currying. I criticized the problem with the <em>order of precedence</em> many imperative languages and ISWIM based languages such as ML and Haskell uses, and how rejecting it leads to re-discovery of S-expression. Finally I showed that combining S-expression and features of modern functional languages makes S-expression more interesting than ever."]
   [:div
    [:small "[1]: or suffix notations that concatenative languages tend to prefer"]]]})
