(ns integrant-app.views
  (:require [re-frame.core :refer [subscribe]]))

(defn main-panel []
  [:div (str "Hello " @(subscribe [:main/title]))])
