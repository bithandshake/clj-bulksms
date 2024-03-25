
(ns bulksms-com.api
    (:require [bulksms-com.side-effects :as side-effects]
              [bulksms-com.utils        :as utils]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (bulksms-com.side-effects/*)
(def send-message! side-effects/send-message!)

; @redirect (bulksms-com.utils/*)
(def acknowledged? utils/acknowledged?)
