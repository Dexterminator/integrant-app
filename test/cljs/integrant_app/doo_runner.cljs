(ns integrant-app.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [integrant-app.core-test]))

(doo-tests 'integrant-app.core-test)


