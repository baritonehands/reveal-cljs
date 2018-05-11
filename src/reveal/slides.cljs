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
   [:h2 "Live Code Editing"]
   [:p "You can define snippets for live editing"]
   [:klipse-snippet {:data-language "clojure"
                     :data-height   300}
    (s/join "\n"
      ["(defn sum [xs]"
       "   (reduce + xs))"
       ""
       "(sum (range 0 100))"])]])

(defn all
  "Add here all slides you want to see in your presentation."
  []
  [slide-1
   slide-2
   slide-3])
