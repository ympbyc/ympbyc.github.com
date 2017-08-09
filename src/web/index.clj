(ns web.index
  (require [hiccup.core :as h]
           [hiccup.util :as hu]
           [hiccup.page :as hp]))

(defn img [src & [alternation]]
  (if alternation
    [:div.image.alternate
     {:style (str "background-image: url(" src ");")
      :data-src src
      :data-src-alt alternation}]
    [:div.image {:style (str "background-image: url(" src ");")}]))

(defn img-desc [src desc]
  [:div.img-desc
   [:div.desc desc]
   [:div.image {:style (str "background-image: url(" src ");")}]])

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
   (hp/include-js  "js/index.js")
   [:meta {:property "og:title" :content "ympbyc -- Minori Yamashita"}]
   [:meta {:property "og:description" :content "Portfolio Minori Yamashita a private researcher"}]
   [:meta {:property "og:image" :content "https://ympbyc.github.io/images/business-card.png"}]
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
   [:div#dissolver {:data-alpha 0}
    (header "images/face.jpg" "ympbyc" "Minori Yamashita 1993-")
    [:div#content
     [:div.section
      (img "images/makerfaire2.jpg" "images/makerfaire.jpg")
      [:a {:href "http://makezine.jp/event/makers2017/m0078/"} "Maker Faire Tokyo 2017"]]
     [:div.section
      (img-desc "images/torii.jpg" [:p "An objet made out of hundreds of waste speakers.  See the link below for details."])
      [:a {:href "https://www.codaworx.com/project/karaoke-kamiyama-artist-in-residence-kair-program"}
       "Jan 2017 Karaoke Torii w/ Die Audio Gruppe"]]
     [:div.section
      (img-desc "images/sticky-watch.jpg" [:p "Quick and easy voice memo device. Email me if you want to purchase one."])
      [:a {:href "http://proto.pilotz.jp/sticky-watch"} "Sticky Watch"]]
     [:div.section
      (img-desc "images/3dpnp.jpg" [:p "I hacked my 3D printer into an pick-n-place machine to make producing sticky-watches efficient. An open source software I developed converts Eagle partlist file into GCode: " [:a {:href "https://github.com/ympbyc/3dpnp"} "GitHub/ympbyc/3DPnP"]])
      [:a {:href "https://github.com/ympbyc/3dpnp"} "DIY Pick and Place Machine"]]
     [:div.section
      (img "images/business-card.png" "images/business-card-back.png")
      "Business Card"]
     [:div.section
      (img "images/electronics-club.png" "images/drawbot-with-kids.jpg")
      [:a {:href "http://proto.pilotz.jp/electronics"} "Kamiyama Electronics Club"]]
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
     [:section.section
      [:h2 "Skills"]
      [:ul
       [:li "Fluent in Japanese & English"]
       [:li "Analog & Digital circuit design"]
       [:li "Lisp: (Clojure & Scheme)"]
       [:li "Thorough experience with JavaScript, SML, PHP, etc"]
       [:li "Toss juggling"]]]
     [:div.section
      (img "images/smalltalk.jpg")]
     [:section.section
      [:h2 "Things I love"]
      [:ul
       [:li "Making/Art"]
       [:li "Forest Making"]
       [:li "Electronics Experiments"]
       [:li "Spacetime Geometry"]
       [:li "IoT as a Computational Resource"]
       [:li "Autogyro"]
       [:li "Psychedelics"]]]
     [:div.section
      (img "images/waves.gif" "images/special-relativity.jpg")
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
       (comment
         [:tr
          [:td [:a {:href "https://github.com/ympbyc/vorpalblade"} "vorpalblade"]]
          [:td "Roguelike written in Biwascheme (incomplete)"]]
         [:tr
          [:td [:a {:href "http://ympbyc.github.io/coffeehack/build"} "coffeehack"]]
          [:td "Roguelike written in Coffeescript (abandoned)"]])
       ]]
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
         :data-id    "6e9fc0503251013041d412313d06f1ad"
         :data-ratio "1.33333333333333"
         :src        "//speakerdeck.com/assets/embed.js"}]]]
     [:div.section
      [:iframe {:width 320 :height 230 :src "https://www.youtube.com/embed/YLwikExc_KI" :frameborder 0 :allowfullscreen true}]]
     [:section#links.section
      [:h2 "See Also (Links)"]
      [:ul
       [:li [:a {:href "https://github.com/ympbyc"} "ympbyc on github"]]
       [:li [:a {:href "http://d.hatena.ne.jp/ympbyc"} "標高+1m (blog)"]]
       [:li [:a {:href "https://www.youtube.com/channel/UCoZPJbl8xxx8OSo7KSy29vA"}]]
       [:li [:a {:href  "https://www.wantedly.com/users/1509657"} "Minori Yamashita on wantedly"]]
       [:li [:a {:href "http://www.facebook.com/minori.yamashita"} "Minori Yamashita on facebook"]]]]
     [:div.section
      (img "images/painting/tajimahikawa.png")]
     [:div.section
      (img "images/painting/nakaurawa.png")]
     [:div.section
      (img "images/s-exploration.png")
      [:a {:href "http://ympbyc.github.io/s-exploration"}
       "S-exploration"]]]]
   ])


(defn main-html []
  (h/html
   (hp/html5
    (html-head)
    (html-body))))
