 (ns brightnorth-website-cljs)


(def url "http://www.brightnorth.co.uk/contact-us.html")


(def casper (.create (.require js/window "casper")))

(.start casper "http://www.brightnorth.co.uk/"
  (fn []
    (this-as that
      (.echo that (.getTitle that)))))

(.thenOpen casper "http://www.brightnorth.co.uk/contact-us.html"
  (fn []
    (this-as that
      (.echo that (.getTitle that)))))

(.run casper)
