
(ns bulksms.api
    (:require [bulksms.side-effects :as side-effects]
              [bulksms.utils        :as utils]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (bulksms.side-effects)
(def send-message! side-effects/send-message!)

; @redirect (bulksms.utils)
(def acknowledge? utils/acknowledge?)
