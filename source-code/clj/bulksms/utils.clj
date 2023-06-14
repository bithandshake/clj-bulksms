
(ns bulksms.utils
    (:require [bulksms.config :as config]
              [math.api       :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn acknowledge?
  ; @param (map) response
  ; {:status (integer)}
  ;
  ; @usage
  ; (acknowledge? (send-message! {...} {...}))
  ;
  ; @return (boolean)
  [response]
  (-> response :status (math/between? 200 299)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn create-uri
  ; @ignore
  ;
  ; @param (string) suffix
  ;
  ; @usage
  ; (create-uri "messages")
  ;
  ; @example
  ; (create-uri "messages")
  ; =>
  ; "https://api.bulksms.com/v1/messages"
  ;
  ; @return (string)
  [suffix]
  (str config/BASE-URI "/" suffix))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn message-props->request-body
  ; @ignore
  ;
  ; @param (map) message-props
  ; {:body (string)
  ;  :to (strings in vector)}
  ;
  ; @return (string)
  [{:keys [body to]}]
  (str "{\"body\": \""body"\", \"to\": "to"}"))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn auth-props->basic-auth
  ; @ignore
  ;
  ; @param (map) auth-props
  ; {:password (string)(opt)
  ;  :token-id (string)(opt)
  ;  :token-secret (string)(opt)
  ;  :username (string)(opt)}
  ;
  ; @return (strings in vector)
  [{:keys [password token-id token-secret username]}]
  (if username [username password]
               [token-id token-secret]))
