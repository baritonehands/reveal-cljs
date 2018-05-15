(ns reveal.slides
  (:require [clojure.string :as s]))

(def slide-1
  [:section
   [:h1 "reveal-cljs"]
   [:h3 "The ClojureScript-Wrapper for reveal.js"]
   [:p "Based on "
    [:a {:href "http://lab.hakim.se/reveal-js/"} "reveal.js"]]])

(def slide-2
  [:section
   [:section
    [:h2 "Vertical Slides"]
    [:p "Generate your slides "
     [:a {:href "https://github.com/teropa/hiccups"} "with Hiccups"]]]
   [:section
    [:h2 "Tutorial"]
    [:p "Watch the full tutorial of reveal.js "
     [:a {:href "https://github.com/hakimel/reveal.js/blob/master/demo.html"} "on this site"]]]])

(def slide-3
  [:section
   [:h2 "Highlighted Code Snippets"]
   [:p "You can dump files in snippets/ to use as highlighted code samples"]
   [:pre#sum]])

(def slide-4
  [:section
   [:h2 "Live Code Snippets"]
   [:p "You can also create snippets for live editing"]
   [:klipse-snippet {:data-language "clojure"
                     :data-height   300
                     :data-src      "live"}]])

(defn all
  "Add here all slides you want to see in your presentation."
  []
  [slide-1
   slide-2
   slide-3
   slide-4])
