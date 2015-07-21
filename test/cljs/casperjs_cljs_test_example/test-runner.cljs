(ns casperjs_cljs_test_example.test-runner
  (:require
   [cljs.test :refer-macros [run-tests]]
   [casperjs_cljs_test_example.core-test]))

(enable-console-print!)

(defn runner []
  (if (cljs.test/successful?
       (run-tests
        'casperjs_cljs_test_example.core-test))
    0
    1))
