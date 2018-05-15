(ns reveal.klipse
  (:require-macros [hiccups.core :as hiccups :refer [html]])
  (:require [clojure.string :as s]
            [reveal.snippets :as snippets] :reload))

(def lang->selector
  {"clojure" "selector",
   "javascript" "selector_eval_js",
   "python" "selector_eval_python_client",
   "scheme" "selector_eval_scheme",
   "ruby" "selector_eval_ruby"})

(defn js-src [lang]
  (if (= lang "clojure")
    "https://storage.googleapis.com/app.klipse.tech/plugin/js/klipse_plugin.js"
    "https://storage.googleapis.com/app.klipse.tech/plugin_prod/js/klipse_plugin.min.js"))

(defn iframe-src [lang src]
  (let [selector (lang->selector lang)]
    [:div
     [:pre
      [:code.klipse src]]
     [:link {:rel "stylesheet" :type "text/css" :href "https://storage.googleapis.com/app.klipse.tech/css/codemirror.css"}]
     [:link {:rel "stylesheet" :type "text/css" :href "https://codemirror.net/theme/zenburn.css"}]
     [:style ".CodeMirror { font-size: 24px; }"]
     [:script (s/join "\n" ["window.klipse_settings = {"
                            (str selector ": '.klipse',")
                            "codemirror_options_in: { theme: 'zenburn' },"
                            "codemirror_options_out: { theme: 'zenburn' }"
                            "}"])]
     [:script {:src (js-src lang)}]]))

(defn create-iframe [lang src height]
  [:iframe {:sandbox "allow-scripts"
            :height (str height "px")
            :width "100%"
            :srcdoc (html (iframe-src lang src))}])

(defn klipsify [elem]
  (let [data (js->clj (.-dataset elem))
        height (int (or (.-height data) "400"))
        lang (.-language data)
        src (.-src data)]
    (if src
      (aset elem "innerHTML" (html (create-iframe lang (get snippets/preloaded src) height)))
      (aset elem "innerHTML" (html (create-iframe lang (.-innerHTML elem) height))))))

(defn klipsify-all []
  (doseq [x (array-seq (.querySelectorAll js/document "klipse-snippet"))]
    (klipsify x)))
