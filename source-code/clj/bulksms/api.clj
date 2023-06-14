
(ns bulksms.api
    (:require [bulksms.side-effects :as side-effects]
              [bulksms.utils        :as utils]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; bulksms.side-effects
(def send-message! side-effects/send-message!)

; bulksms.utils
(def acknowledge? utils/acknowledge?)
