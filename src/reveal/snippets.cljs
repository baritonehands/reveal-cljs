(ns reveal.snippets
  (:require-macros [hiccups.core :refer [html]]
                   [reveal.macros :refer [preload]])
  (:require [clojure.string :as s]))

(def preloaded (preload "snippets"))

(defn render [id]
  (if-let [elem (.getElementById js/document id)]
    (let [lines (for [line (s/split (get preloaded id) #"\n")]
                  [:code.hljs.clojure line "\n"])]
      (set! (.-innerHTML elem) (html lines)))))

(defn render-all []
  (doseq [id (keys preloaded)]
    (render id)))
