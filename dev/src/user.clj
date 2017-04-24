(ns user
  (:require [io.aviso.repl :as pretty]
            [integrant-app.core]
            [integrant-app.config.main-config :refer [main-config]]
            [integrant.repl :refer [clear go halt init reset reset-all set-prep!]]
            [integrant.repl.state :refer [config system]]))

(pretty/install-pretty-exceptions)
(integrant.repl/set-prep! (constantly main-config))
