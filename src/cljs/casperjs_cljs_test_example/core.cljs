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
            (dom/div nil
              (dom/a #js{:href   "http://www.brightnorth.co.uk/"
                         :target "_blank"}
                (dom/img #js{:id        "bright-north"
                             :src       "images/bn-logo-inv-large.png"
                             :className "bright-north-logo"})))
            (dom/div nil
              (dom/img #js{:id        "casperjs"
                           :src       "images/casperjs-logo.png"
                           :className "casperjs-logo"}))
            (dom/div nil
              (dom/img #js{:id        "cljs"
                           :src       "images/cljs-logo.jpg"
                           :className "cljs-logo"}))))))
    app-state
    {:target (. js/document (getElementById "app"))}))
