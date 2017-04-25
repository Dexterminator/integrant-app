(ns integrant-app.core
  (:require [devtools.core :as devtools]
            [re-frame.core :as rf]
            [reagent.core :as r]
            [integrant-app.views :as views]
            [integrant-app.events]
            [integrant-app.subs]))

(def debug?
  ^boolean js/goog.DEBUG)

(defn dev-setup []
  (when debug?
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
