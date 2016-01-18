(ns web.twofifteen
  (require [hiccup.core :as h]
           [hiccup.util :as hu]
           [hiccup.page :as hp]))

(defn html-head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "Robots" :content "index, follow"}]
   [:meta {:http-equiv "Content-Type" :content "text/html; charset=utf-8"}]
   [:meta {:http-equiv "X-UA-Compatible" :content "IE=Edge,chrome=1"}]
   [:title "Minori Yamashita"]
   [:meta {:name "description" :content "Minori Yamashita's Portfolio as of 2015"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"}]

   (hp/include-css "css/reset.css")
   (hp/include-css "components/google-code-prettify/prettify.css")
   (hp/include-css "css/hidamari.css")
   (hp/include-js  "components/google-code-prettify/prettify")
   (hp/include-js  "components/underscore/underscore-min.js")
   (hp/include-js  "components/underscore-fix/underscore-fix.js")
   (hp/include-js  "js/main.js")])

(defn html-body []
  [:body
   [:header
    [:div#header-slides.slides]
    [:div.content.title
     [:h1.main-logo [:span.sticker "Minori Yamashita"]]
     [:span.sticker "Since 1993"]]]
   [:div.main-container
    [:main
     [:div.flexbox.flex-row
      [:section.tile
       [:div
        [:a {:href "resume.html"}
         [:img {:src "images/twof/resume.png" :width "50%"}]]]
       [:h2 {:style "background: #f4b043"} "Resume"]]
      [:section.tile
       [:div
        [:ul.align-left
         [:li [:a {:href "http://ympbyc.hatenablog.com/"} "標高+1m (Blog ja-jp)"]]
         [:li [:a {:href "http://proto.pilotz.jp/"} "PILOT Proto Lab"]]
         [:li [:a {:href "http://www.facebook.com/minori.yamashita"} "Facebook"]]]]
       [:h2 {:style "background: rgb(85,154,213)"} "Links"]]
      [:section.tile
       [:div
        ]
       [:h2 {:style "background: #f9db57"} "Carrot"]]]]]])

(defn main-html []
  (h/html
   (hp/html5
    (html-head)
    (html-body))))
