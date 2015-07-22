(ns caspercljs.test-example-page-logo)


(def example-page "http://localhost:10555/")
(def bright-north-logo-selector "#bright-north")
(def screenshot-path "casper/target/screenshots/test-example-page-cljs.png")


(def casper js/casper)


(def casper-test (.-test casper))


(.begin casper-test "The Bright North logo should be visible" 1
  (fn [test]
    (.start casper example-page (fn []
                                  (this-as that
                                    (.echo that (str "The title of the example page (" example-page ") is: " (.getTitle that))))))

    (.waitForSelector casper bright-north-logo-selector)

    (.then casper (fn []
                    (this-as that
                      (.assertVisible test bright-north-logo-selector)
                      (.echo that (str "The selector '" bright-north-logo-selector "' is visible!"))
                      (.captureSelector that screenshot-path "body"))))

    (.run casper (fn []
                   (.done test)))))


