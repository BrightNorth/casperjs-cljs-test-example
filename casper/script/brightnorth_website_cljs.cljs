(ns brightnorth-website-cljs)


(def casper (.create (.require js/window "casper")))


(.start casper "http://localhost:10555/"
  (fn []
    (this-as that
      (.echo that (.getTitle that)))))


(.thenOpen casper "http://www.brightnorth.co.uk/"
  (fn []
    (this-as that
      (.echo that (.getTitle that)))))


(.run casper)
