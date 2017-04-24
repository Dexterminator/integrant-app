(ns integrant-app.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
  :main/title
  (fn [db]
    (:test db)))
