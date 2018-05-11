(ns build
  (:require [shadow.cljs.devtools.api :as shadow]
            [me.raynes.fs :as fs]))

(defn copy-reveal []
  (fs/copy-dir "node_modules/reveal.js/css" ".")
  (fs/copy-dir "node_modules/reveal.js/lib" ".")
  (fs/copy "node_modules/reveal.js/js/reveal.js" "js/reveal.js"))

(defn watch
  {:shadow/requires-server true}
  []
  (copy-reveal)
  (shadow/watch :reveal))

(defn release []
  (copy-reveal)
  (shadow/release :reveal))
