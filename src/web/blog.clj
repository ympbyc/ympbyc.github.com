(ns web.blog
  (:require [hiccup.core :as h]
            [hiccup.page :as hp]
            [web.index :as index])
  (:use [hiccup.page :only [include-css include-js]]))


(defn html-head []
  [:head
   [:meta {:charset "utf-8"}]
   [:title "ympbyc"]
   (include-css "../components/kraken/kraken.css")
   (include-css "../components/google-code-prettify/prettify.css")
   (include-css "../css/style.css")
   (include-js  "../components/jquery/jquery.min.js")
   (include-js  "../components/google-code-prettify/prettify")
   (include-js  "../components/underscore/underscore-min.js")
   (include-js  "../components/underscore-fix/underscore-fix.js")])

(defn bracket [& contents]
  [:div.bracket
   [:div.bracket-l]
   [:div.bracket-c  (seq contents)]
   [:div.bracket-r]])

(defn brace [& contents]
  [:div.bracket
   [:div.brace-tip.l]
   [:div.bracket-l]
   [:div.bracket-c  (seq contents)]
   [:div.bracket-r]
   [:div.brace-tip.r]])


(defn blog
  [{:keys [title date author content]}]
  (h/html
   (hp/html5
    (html-head)
    [:body.blog {:onload "prettyPrint()"}
     (index/header "../images/geta.png" "(inc altitude)" "")
     [:div#content.blog
      (brace
       [:h1.clj-title.clj   (pr-str title)]
       [:div.clj-date.clj    (pr-str date)]
       [:div.clj-author.clj  (pr-str author)]
       [:div.clj-content.clj "\"" (h/html content) "\""]
       [:div.clj-meta.clj
        (brace
         [:div.clj-ympbyc.clj [:a {:href "../index.html"} (pr-str "ympbyc.github.io")]]
         [:div.clj-blog.clj [:a {:href "../contents.html"} (pr-str "ympbyc.github.io/contents")]])])]])))


(defn contents-html
  [filenames]
  (h/html
   (hp/html5
    (index/html-head)
    [:body.blog
     (index/header "images/geta.png" "(inc altitude)" "")
     [:div#content.blog
      (brace
       [:h1 ":contents"]
       (bracket
        [:ul.no
         (map
          (fn [fname]
            [:li [:a {:href (str "" fname)} (pr-str fname)]])
          filenames)]))]])))
