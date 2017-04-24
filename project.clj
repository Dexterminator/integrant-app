(defproject integrant-app "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.521"]
                 [io.aviso/pretty "0.1.33"]
                 [integrant "0.4.0"]
                 [ring "1.5.1"]
                 [compojure "1.5.1"]]

  :main ^:skip-aot integrant-app.core
  :target-path "target/%s"

  :source-paths ["src/clj" "src/cljs"]
  :test-paths ["test/clj" "test/cljs"]

  :plugins [[lein-cljsbuild "1.1.3"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"]

  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}

  :profiles
  {:dev {:dependencies   [[pjstadig/humane-test-output "0.8.1"]
                          [integrant/repl "0.2.0"]]
         :injections     [(require 'pjstadig.humane-test-output)
                          (pjstadig.humane-test-output/activate!)]
         :plugins        [[com.jakemccrary/lein-test-refresh "0.19.0"]
                          [lein-doo "0.1.7"]]
         :test-refresh   {:quiet        true
                          :changes-only true}
         :source-paths   ["dev/src"]
         :resource-paths ["dev/resources"]
         :repl-options   {:init-ns user}}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :compiler     {:main                 integrant-app.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true}}
    {:id           "min"
     :source-paths ["src/cljs"]
     :jar          true
     :compiler     {:main            integrant-app.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}
    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:output-to     "resources/public/js/compiled/test.js"
                    :main          integrant-app.doo-runner
                    :optimizations :none}}
    ]}

  :uberjar {:aot :all}

  )
