(defproject casperjs-cljs-test-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj"]

  :test-paths ["test/clj"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3058" :scope "provided"]
                 [ring "1.3.2"]
                 [ring/ring-defaults "0.1.4"]
                 [compojure "1.3.2"]
                 [enlive "1.1.6"]
                 [org.omcljs/om "0.8.8"]
                 [environ "1.0.0"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-environ "1.0.0"]]

  :min-lein-version "2.5.1"

  :uberjar-name "casperjs-cljs-test-example.jar"

  :aliases {"casper" ["do" "clean" ["with-profiles" "-dev,+casper" ["cljsbuild" "test"]]]
            "casper-test" ["do" "clean" ["with-profiles" "-dev,+casper-test" ["cljsbuild" "test"]]]}

  :clean-targets ["casper/target"]

  :cljsbuild {:builds {:app {:source-paths ["src/cljs"]
                             :compiler {:output-to     "resources/public/js/app.js"
                                        :output-dir    "resources/public/js/out"
                                        :source-map    "resources/public/js/out.js.map"
                                        :preamble      ["react/react.min.js"]
                                        :optimizations :none
                                        :pretty-print  true}}}}

  :profiles {:dev {:source-paths ["env/dev/clj"]
                   :test-paths ["test/clj"]

                   :dependencies [[figwheel "0.2.5"]
                                  [figwheel-sidecar "0.2.5"]
                                  [com.cemerick/piggieback "0.1.5"]
                                  [weasel "0.6.0"]]

                   :repl-options {:init-ns casperjs-cljs-test-example.server
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

                   :plugins [[lein-figwheel "0.2.5"]]

                   :figwheel {:http-server-root "public"
                              :server-port 3449
                              :css-dirs ["resources/public/css"]
                              :ring-handler casperjs-cljs-test-example.server/http-handler}

                   :env {:is-dev true}

                   :cljsbuild {:test-commands { "test" ["phantomjs" "env/test/js/unit-test.js" "env/test/unit-test.html"] }
                               :builds {:app {:source-paths ["env/dev/cljs"]}
                                        :test {:source-paths ["src/cljs" "test/cljs"]
                                               :compiler {:output-to     "resources/public/js/app_test.js"
                                                          :output-dir    "resources/public/js/test"
                                                          :source-map    "resources/public/js/test.js.map"
                                                          :preamble      ["react/react.min.js"]
                                                          :optimizations :whitespace
                                                          :pretty-print  false}}}}}

             :uberjar {:source-paths ["env/prod/clj"]
                       :hooks [leiningen.cljsbuild]
                       :env {:production true}
                       :omit-source true
                       :aot :all
                       :main casperjs-cljs-test-example.server
                       :cljsbuild {:builds {:app
                                            {:source-paths ["env/prod/cljs"]
                                             :compiler
                                             {:optimizations :advanced
                                              :pretty-print false}}}}}

             :casper {:cljsbuild {:test-commands {"casper" ["casperjs" "casper/target/app.js"]}
                                  :builds {
                                           :test {:source-paths [ "casper/script"]
                                                  :compiler {:output-to     "casper/target/app.js"
                                                             :output-dir    "casper/target/"
                                                             :source-map    "casper/target/app.js.map"
                                                             :optimizations :whitespace
                                                             :pretty-print  false}}}}}

             :casper-test {:cljsbuild {:test-commands {"casper" ["casperjs" "test" "casper/target/app_test.js"]}
                                       :builds {
                                                :test {:source-paths [ "casper/test"]
                                                       :compiler {:output-to     "casper/target/app_test.js"
                                                                  :output-dir    "casper/target/"
                                                                  :source-map    "casper/target/test.js.map"
                                                                  :optimizations :whitespace
                                                                  :pretty-print  false}}}}}})
