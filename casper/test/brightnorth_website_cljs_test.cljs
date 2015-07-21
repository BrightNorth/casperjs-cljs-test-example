(ns caspercljs.brightnorth-website-cljs-test)


(def url "http://localhost:10555/")


(def casper js/casper)


(def casper-test (.-test casper))


(.begin casper-test "" 1 (fn [test]
                           (.start casper url (fn []
                                                (this-as that
                                                  (.echo that (.getTitle that))
                                                  (.assertTitle test "CasperJS-CLJS Test Example | Bright North"
                                                    "Test page title is the one expected"))))

                           (.run casper (fn []
                                          (.done test)))))


