(ns integrant-app.core
  (:require [integrant-app.config :as config]
            [devtools.core :as devtools]
            [re-frame.core :as rf]
            [reagent.core :as r]
            [integrant-app.views :as views]
            [integrant-app.events]
            [integrant-app.subs]))

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (devtools/install!)))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (r/render [views/main-panel]
            (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (rf/dispatch-sync [:initialize-db])
  (mount-root))
