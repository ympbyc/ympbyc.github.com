(use '(web blog))


(blog {:title "OO isn't Suited for Simulations"
       :date #inst "2013-07-23T19:47:36.668-00:00"
       :author "ympbyc"
       :content (comment [:div
                  [:p "Yesterday, I came across "
                   [:a {:href "http://blog.fogus.me/2013/07/22/fp-vs-oo-from-the-trenches/"}
                    "this post"]
                   " in which a simple two-point guidlines to choose between OO and FP have been presented. The guidlines are as follows: "
                   [:blockquote
                    [:ul
                     [:li "Whenever I write some code to deal with " [:em "data about"]
                      " people then functional programming seems to work best."]
                     [:li "Whenever I write some code to " [:em "simulate"]
                      " people then object-oriented programming seems to work best."]]]
                   "While my wish is(n't) to rule out OO's opportunities entirely, I want to make it clear that OO, which I will soon define, is an extremely inconvenient tool to use especially when it comes to "
                   [:em "simulations."]]
                  [:h2 "Definitions"]
                  [:p "OO-vs-FP is a sensitive topic and I have to watch my mouth very carefully. Before going into details I shall define a few words in this post's context."]
                  [:p [:strong "Object"] " is an abstraction of a portion of a RAM (or any sort of phisical memory). This definition is derived from " [:strong "A Little Smalltalk"] " which can be found " [:a {:href "http://stephane.ducasse.free.fr/FreeBooks.html"} "here"]
                   " and it holds consistent with many object systems including CLOS. Because objects are coupled with pieces of a physical memory, the use of them inevitably involve mutations, in which local states emerge. Note that I have not said a word about class-based programming. I believe it sucks, but I put it aside for now and claim it is a separate concept from fundamentalist's OO." [:br]
                   "Tl;DR; object ≒ memory ≒ mutable state."]
                  [:p [:strong "Object Oriented Program"] " is a program involing extensive usage of objects."]
                  [:p [:strong "Value"] " is a immutable representation of data in a program such as Integer, String, Map, Vector, etc."]

                  [:h2 "...." ]])})
