(ns config.dev-config)

(def dev-config
  {:figwheel {:figwheel-options {:css-dirs ["resources/public/css"]}
              :build-ids        ["dev"]
              :all-builds       [{:id           "dev"
                                  :figwheel     {:on-jsload "integrant-app.core/mount-root"}
                                  :source-paths ["src/cljs"]
                                  :compiler     {:main                 "integrant-app.core"
                                                 :output-to            "resources/public/js/compiled/app.js"
                                                 :output-dir           "resources/public/js/compiled/out"
                                                 :asset-path           "js/compiled/out"
                                                 :source-map-timestamp true}}]}
   :pretty/exceptions {}})
