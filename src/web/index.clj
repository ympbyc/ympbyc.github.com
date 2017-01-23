(ns web.index
  (require [hiccup.core :as h]
           [hiccup.util :as hu]
           [hiccup.page :as hp]))

(def menu
  [:div#menu
   [:a.btn.btn-blue.page {:href "/"} "Top"]
   [:a.btn.btn-blue.page {:href "#links"} "Links"]
   [:a.btn.btn-blue.page {:href "http://ympbyc.hatenablog.com/"} "Blog (Ja)"]])

(defn html-head []
  [:head
   [:meta {:charset "utf-8"}]
   [:title "ympbyc"]
   (hp/include-css "components/kraken/kraken.css")
   (hp/include-css "components/google-code-prettify/prettify.css")
   (hp/include-css "css/style.css")
   (hp/include-js  "components/jquery/jquery.min.js")
   (hp/include-js  "components/google-code-prettify/prettify")
   (hp/include-js  "components/underscore/underscore-min.js")
   (hp/include-js  "components/underscore-fix/underscore-fix.js")
   [:meta {:property "og:title" :content "ympbyc -- Minori Yamashita"}]
   [:meta {:property "og:description" :content "Minori's Portfolio"}]
   [:meta {:property "og:image" :content "https://ympbyc.github.io/images/smalltalk.jpg"}]
   [:meta {:property "og:sime_name" :content "ympbyc -- Minori Yamashita"}]
   [:meta {:property "og:type" :content "website"}]])

(defn header [img title subtitle]
  [:header
   [:img {:src img :style "float: left; margin-right: 20px; width: 109px; height: 109px;"}]
   [:h1 title]
   [:i subtitle]
   menu])


(defn html-body []
  [:body {:onload "/*prettyPrint()*/"}
   (header "images/face.jpg" "ympbyc" "Minori Yamashita 1993")
   [:div#content
    [:div.section
     [:img {:src "images/torii.jpg"}]
     "Jan 2017 Karaoke Torii w/ Die Audio Gruppe"]
    [:div.section
     [:img {:src "images/sticky-watch-cg.png"}]
     "Sticky Watch"]
    [:div.section
     [:img {:src "images/farm-watcher.jpg"}]
     "Moisture Sensor & Display for my farm"]
    [:section.section
     [:h2 "Contacts"]
     [:ul
      [:li "<" [:a {:href "mailto:ympbyc@gmail.com"} "ympbyc@gmail.com"] ">"]
      [:li [:a {:href "http://twitter.com/ympbyc"} "@ympbyc"]]]
     [:h2 "Resume"]
     [:a {:href "resume.html"} "Minori Yamashita's Resume"]]
    [:div.section
     [:iframe {:width 320 :height 180 :src "https://www.youtube.com/embed/PwPBY7NojgY":frameborder 0 :allowfullscreen true}]
     [:a {:href "proto.pilotz.jp/bird"} "Bird"]]
    [:section.section
     [:h2 "Currently"]
     [:ul [:li [:a {:href "http://proto.pilotz.jp/"} "PILOT Proto Lab"]]]
     [:h2 "Education"]
     [:ul
      [:li [:a {:href "http://www.sierracollege.edu/"} "Sierra College CompSci - Dropout"]]
      [:li [:a {:href "http://www.lynfield.school.nz/"} "Lynfield College"]]]]
    [:div.section
     [:img {:src "images/special-relativity.jpg"}]]
    [:section.section
     [:h2 "Skills"]
     [:ul
      [:li "Fluent in Japanese & English"]
      [:li "Analog & Digital circuit design"]
      [:li "Lisp: (Clojure & Scheme)"]
      [:li "Thorough experience with Smalltalk, JavaScript, SML, etc"]
      [:li "Juggling up to 5 balls / rings / clubs"]]]
    [:div.section
     [:img {:src "images/smalltalk.jpg"}]]
    [:section.section
     [:h2 "Things I do"]
     [:ul
      [:li "Making"]
      [:li "3D printing"]
      [:li "Electronics Experiments"]
      [:li "Spacetime Geometry"]
      [:li "IoT as a Computational Resource"]
      [:li "Autogyro"]
      [:li "SciFi"]
      [:li "Psychoactive Plants"]]]
    [:div.section
     [:img {:src "images/waves.gif"}]
     [:a {:href "http://ympbyc.hatenablog.com/entry/we-need-more-space"} "We Need More Space!"]]
    [:section.section
     [:h2 "Software Projects"]
     [:table
      [:tr
       [:td [:a {:href "https://github.com/ympbyc/Carrot"} "Carrot"]]
       [:td "Purely Functional Poc Lisp (incomplete)"]]
      [:tr
       [:td [:a {:href "https://github.com/typedclojure/core.typed"} "Typed Clojure"]]
       [:td "Optional typing in Clojure. I'm involved w/ clojurescript checker"]]
      [:tr
       [:td [:a {:href "http://ympbyc.github.io/LittleSmallscript"} "LittleSmallscript"]]
       [:td "Write JavaScript in Smalltalk's Syntax"]]
      [:tr
       [:td [:a {:href "http://proto.pilotz.jp/bird"} "Bird"]]
       [:td "Frontend IDE for kakahiaka"]]
      [:tr
       [:td [:a {:href "https://github.com/ympbyc/kakahiaka"} "kakahiaka"]]
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
       [:td [:a {:href "http://ympbyc.github.io/coffeehack/build"} "coffeehack"]]
       [:td "Roguelike written in Coffeescript (abandoned)"]]]]
    [:div.section
     [:div.slide
      [:script.speakerdeck-embed
       {:async      true
        :data-id    "8102cd705054013132c906f96a5ccdc2"
        :data-ratio "1.77777777777778"
        :src        "//speakerdeck.com/assets/embed.js"}]]]
    [:div.section
     [:div.slide
      [:script.speakerdeck-embed
       {:async      true
        :data-id    "08ee2240c557013074ff022654766eda"
        :data-ratio "1.33333333333333"
        :src        "//speakerdeck.com/assets/embed.js"}]]]
    [:div.section
     [:div.slide
      [:script.speakerdeck-embed
       {:async      true
        :data-id    "6e9fc0503251013041d412313d06f1ad"
        :data-ratio "1.33333333333333"
        :src        "//speakerdeck.com/assets/embed.js"}]]]
    [:div.section
     [:iframe {:width 320 :height 230 :src "https://www.youtube.com/embed/YLwikExc_KI" :frameborder 0 :allowfullscreen true}]]
    [:section#links.section
     [:h2 "See Also"]
     [:ul
      [:li [:a {:href "https://github.com/ympbyc"} "ympbyc on github"]]
      [:li [:a {:href "http://d.hatena.ne.jp/ympbyc"} "標高+1m (blog)"]]
      [:li [:a {:href  "https://www.wantedly.com/users/1509657"} "Minori Yamashita on wantedly"]]
      [:li [:a {:href "http://www.facebook.com/minori.yamashita"} "Minori Yamashita on facebook"]]]]
    [:div.section
     [:img {:src "images/electronics-club.png"}]
     [:a {:href "http://proto.pilotz.jp/electronics"} "Kamiyama Electronics Club"]]
    [:div.section
     [:img {:src "images/painting/tajimahikawa.png"}]]
    [:div.section
     [:img {:src "images/painting/kounumakawa.png"}]]
    [:div.section
     [:img {:src "images/painting/nakaurawa.png"}]]
    [:div.section
     [:a {:href "view-source:"}
      [:img {:src "images/lisplogo_warning2.png"}]]]
    [:div.section
     [:a {:href "http://ympbyc.github.io/s-exploration"}
      [:img {:src "images/s-exploration.png"}]]]
    [:div.section
     [:img {:src "images/bike.jpg"}]]]])


(defn main-html []
  (h/html
   (hp/html5
    (html-head)
    (html-body))))
