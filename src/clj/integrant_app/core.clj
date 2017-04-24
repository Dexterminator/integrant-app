(ns integrant-app.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [integrant-app.handler :refer [handler]]
            [integrant.core :as ig]
            [integrant-app.config.main-config :refer [main-config]])
  (:gen-class))

(defn -main
  [& args]
  (let [system (ig/init main-config)]
    (println "System initialized")
    (println system)))
