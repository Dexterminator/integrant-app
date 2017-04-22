(ns user
  (:require [io.aviso.repl :as pretty]))

(defn start []
  (pretty/install-pretty-exceptions))
