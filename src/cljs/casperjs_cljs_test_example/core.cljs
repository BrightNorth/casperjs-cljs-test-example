(ns casperjs-cljs-test-example.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {:text "Hello Bright North!"}))

(defn main []
  (om/root
    (fn [app owner]
      (reify
        om/IRender
        (render [_]
          (dom/div nil
            ;(dom/h1 nil (:text app))
            (dom/div nil
              (dom/a #js{:href   "http://www.brightnorth.co.uk/"
                         :target "_blank"}
                (dom/img #js{:src       "images/bn-logo-white-large.png"
                             :className "bright-north-logo"})))
            (dom/div nil
              (dom/img #js{:src       "images/casperjs-logo.png"
                           :className "casperjs-logo"}))))))
    app-state
    {:target (. js/document (getElementById "app"))}))
