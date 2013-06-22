(ns web.index
  (require [hiccup.core :as h]
           [hiccup.util :as hu])
  (:gen-class))

(def menu
  [:div#menu])

(defn html-head []
  [:head
   [:meta {:charset "utf-8"}]
   [:title "ympbyc"]
   [:link {:rel  "stylesheet"
           :href "components/kraken/kraken.css"}]
   [:link {:rel "stylesheet"
           :href "components/google-code-prettify/prettify.css"}]
   [:link {:rel  "stylesheet"
           :href "css/style.css"}]
   [:script {:src "components/jquery/jquery.min.js"}]
   [:script {:src "components/google-code-prettify/prettify.js"}]
   [:script {:src "components/underscore/underscore-min.js"}]
   [:script {:src "components/underscore-fix/underscore-fix.js"}]])

(defn html-body []
  [:body {:onload "prettyPrint()"}
   [:header
    [:img {:src "images/face.jpg" :style "float: left; margin-right: 20px"}]
    [:h1 "ympbyc"]
    [:i "Minori Yamashita 1993"]
    menu]
   [:div#content
    [:div
     [:section.section
      [:h2 "Contacts"]
      [:ul
       [:li "<" [:a {:href "mailto:ympbyc@gmail.com"} "ympbyc@gmail.com"] ">"]
       [:li [:a {:href "http://twitter.com/ympbyc"} "@ympbyc"]]]]
     [:div.section
      [:img {:src "images/bike.jpg"}]]
     [:section.section
      [:h2 "Currently"]
      [:ul [:li [:a {:href "http://pilotz.jp/"} "PILOT"]]]
      [:h2 "Formerly"]
      [:ul [:li [:a {:href "http://www.lynfield.school.nz/"} "Lynfield College"]]]]]
    [:div
     [:div.section
      [:img {:src "images/nakaurawa.jpg"}]]
     [:section.section
      [:h2 "Fluent in"]
      [:ul
       [:li "Japanese"]
       [:li "English"]
       [:li "Clojure"]
       [:li "Scheme"]
       [:li "JavaScript"]
       [:li "SML"]
       [:li "Smalltalk"]]]
     [:div.section
      [:img {:src "images/smalltalk.jpg"}]]]
    [:div
     [:section.section
      [:h2 "Interested in"]
      [:ul
       [:li "Painting"]
       [:li "Concatenative Languages"]
       [:li "Graphical Languages"]
       [:li "Functional GUI Programming"]
       [:li "Toy Camera"]
       [:li "Radio"]
       [:li "Time"]
       [:li "Human Powered Flying Vehicle"]
       [:li "Philosophy"]
       [:li "SF"]]]
     [:div.section
      [:img {:src "images/ring.jpg"}]]
     [:section.section
      [:h2 "Pet Projects"]
      [:table
       [:tr
        [:td [:a {:href "https://github.com/ympbyc/Nadeko"} "Nadeko"]]
        [:td "Purely Functional Poc Lisp (incomplete)"]]
       [:tr
        [:td [:a {:href "http://ympbyc.github.io/LittleSmallscript"} "LittleSmallscript"]]
        [:td "Write JavaScript in Smalltalk syntax"]]
       [:tr
        [:td [:a {:href "http://ympbyc.github.io/Pasta/web"} "Pasta"]]
        [:td "Client side functional GUI programming"]]
       [:tr
        [:td [:a {:href "https://github.com/ympbyc/underscore-fix"} "Underscore-fix"]]
        [:td "Underscore.js extensions for serious functional programming"]]
       [:tr
        [:td [:a {:href "https://github.com/ympbyc/js-clos"} "JS-CLOS"]]
        [:td "Multimethod in JavaScript"]]
       [:tr
        [:td [:a {:href "https://github.com/ympbyc/vorpalblade"} "vorpalblade"]]
        [:td "Roguelike written in Biwascheme (incomplete)"]]
       [:tr
        [:td [:a {:href "https://github.com/ympbyc/coffeehack"} "coffeehack"]]
        [:td "Roguelike written in Coffeescript (abandoned)"]]]]]
    [:div
     [:div.section
      [:a {:href "http://ympbyc.github.io/vorpalblade/"} [:img {:src "images/vopal.png"}]]]
     [:div.section
      [:div.slide
       [:script.speakerdeck-embed
        {:async      true
         :data-id    "5094b6c9cac0440002011658"
         :data-ratio "1.33333333333333"
         :src        "//speakerdeck.com/assets/embed.js"}]]]
     [:div.section
      [:div.slide
       [:script.speakerdeck-embed
        {:async      true
         :data-id    "6e9fc0503251013041d412313d06f1ad"
         :data-ratio "1.33333333333333"
         :src        "//speakerdeck.com/assets/embed.js"}]]]
     [:section.section
      [:h2 "Articles"]
      [:ul
       [:li [:a {:href "https://gist.github.com/ympbyc/5564146"} "Functional JavaScript"]]
       [:li [:a {:href "https://gist.github.com/ympbyc/5459224"} "Getting Close To Metal: The Right Way"] " (incomplete)"]
       [:li [:a {:href "https://gist.github.com/ympbyc/5278140"} "LLerのための関数指向入門"]]]]]
    [:div
     [:div.section
      [:img {:src "images/favourites.jpg"}]]
     [:section.section
      [:h2 "See Also"]
      [:ul
       [:li [:a {:href "https://github.com/ympbyc"} "ympbyc on github"]]
       [:li [:a {:href "http://d.hatena.ne.jp/ympbyc"} "標高+1m (blog)"]]
       [:li [:a {:href "http://www.facebook.com/minori.yamashita"} "Minori Yamashita on facebook"]]]]]

    [:div
     [:img {:src "images/lisplogo_warning2.png"}]]]])


(defn main-html []
  (h/html
   [:html
    (html-head)
    (html-body)]))
