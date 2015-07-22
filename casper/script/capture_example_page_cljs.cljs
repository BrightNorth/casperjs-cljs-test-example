(ns capture-example-page-cljs)


(def casper (.create (.require js/window "casper")))
(def example-page "http://localhost:10555/")
(def screenshot-path "casper/target/screenshots/page-example-body-cljs.png")


(.start casper example-page
  (fn []
    (this-as that
      (.echo that (str "The title of the example page (" example-page ") is: " (.getTitle that))))))


(.waitForSelector casper "#bright-north"
  (fn []
    (this-as that
      (.captureSelector that screenshot-path "body")
      (.echo that (str "Page loaded, screenshot captured! (" screenshot-path ")")))))


(.run casper)
