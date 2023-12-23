
(ns bulksms-com.prototypes
    (:require [fruits.mixed.api :as mixed]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn message-props-prototype
  ; @ignore
  ;
  ; @param (map) message-props
  ; {:to (string or strings in vector)}
  ;
  ; @return (opt)
  ; {:to (strings in vector)}
  [{:keys [to] :as message-props}]
  (merge message-props {:to (mixed/to-vector to)}))
