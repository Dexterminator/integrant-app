(defproject integrant-app "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.aviso/pretty "0.1.33"]]

  :main ^:skip-aot integrant-app.core
  :target-path "target/%s"

  :source-paths ["src/clj" "src/cljs"]
  :test-paths ["tests/clj" "tests/cljs"]

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-less "1.7.5"]
            [lein-kibit "0.1.3"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"]

  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}

  :profiles
  {:dev     {:dependencies   [[pjstadig/humane-test-output "0.8.1"]]
             :plugins        [[com.jakemccrary/lein-test-refresh "0.14.0"]]
             :injections     [(require 'pjstadig.humane-test-output)
                              (pjstadig.humane-test-output/activate!)]
             :source-paths   ["dev/src"]
             :resource-paths ["dev/resources"]
             :repl-options   {:init-ns user}}

   :uberjar {:aot :all}

   })
