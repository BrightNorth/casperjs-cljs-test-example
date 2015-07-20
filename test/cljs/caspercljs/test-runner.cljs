(ns caspercljs.test-runner
  (:require
   [cljs.test :refer-macros [run-tests]]
   [caspercljs.core-test]))

(enable-console-print!)

(defn runner []
  (if (cljs.test/successful?
       (run-tests
        'caspercljs.core-test))
    0
    1))
