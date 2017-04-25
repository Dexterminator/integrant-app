(ns integrant-app.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [integrant-app.handler :refer [handler]]
            [integrant.core :as ig]
            [integrant-app.handler]
            [integrant-app.server]
            [integrant-app.config.main-config :refer [main-config]])
  (:gen-class))

(defn -main
  [& args]
  (ig/init main-config))
