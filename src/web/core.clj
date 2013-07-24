(ns web.core
  (use web.index)
  (require [hiccup.util :as hu])
  (use [web.blog :only [contents-html]])
  (:gen-class))

(def blogs
  ;;every file must export entry/0
  (file-seq (clojure.java.io/file "src/web/blog")))


(defn -main
  [& args]
  (spit "index.html" (main-html))

  (doseq [blog (drop 1 blogs)]
    (spit (str "blog/" (.getName blog) ".html")
          (load-file (str "src/web/blog/" (.getName blog)))))
  (spit "contents.html"
        (contents-html (map #(str "blog/" (.getName %) ".html") (drop 1 blogs)))))
