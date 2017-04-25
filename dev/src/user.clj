(ns user
  (:require [io.aviso.repl :as pretty]
            [integrant-app.core]
            [integrant-app.config.main-config :refer [main-config]]
            [config.dev-config :refer [dev-config]]
            [integrant.repl :refer [clear go halt init reset reset-all set-prep!]]
            [integrant.repl.state :refer [config system]]
            [integrant.core :as ig]
            [figwheel-sidecar.repl-api :as ra]
            [figwheel-dev]))

(defn get-config []
  (merge main-config dev-config))

(defn cljs-repl []
  (ra/cljs-repl))

(pretty/install-pretty-exceptions)
(integrant.repl/set-prep! get-config)
