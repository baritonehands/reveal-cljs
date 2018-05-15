(ns reveal.macros
  (:require [me.raynes.fs :as fs]))

(defmacro preload [path]
  (into {}
    (for [file (fs/list-dir path)
          :when (fs/file? file)]
      [(fs/name file) (slurp file)])))
