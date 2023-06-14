
(ns bulksms.side-effects
    (:require [bulksms.patterns   :as patterns]
              [bulksms.prototypes :as prototypes]
              [bulksms.utils      :as utils]
              [clj-http.client    :as clj-http.client]
              [validator.api      :as v]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn send-message!
  ; @param (map) auth-props
  ; {:password (string)(opt)
  ;  :token-id (string)(opt)
  ;  :token-secret (string)(opt)
  ;  :username (string)(opt)}
  ; @param (map) message-props
  ; {:body (string)
  ;  :to (string or strings in vector)}
  ;
  ; @usage
  ; (send-message! {:username "my-user" :password "psw1234"}
  ;                {...})
  ;
  ; @usage
  ; (send-message! {:token-id "..." :token-secret "..."}
  ;                {...})
  ;
  ; @usage
  ; (send-message! {...}
  ;                {:to "+1234567890" :body "Hi there!"})
  ;
  ; @usage
  ; (send-message! {...}
  ;                {:to ["+1234567890" "+0987654321"] :body "Hi there!"})
  ;
  ; @return (?)
  [auth-props message-props]
  (and (v/valid? auth-props    {:pattern* patterns/AUTH-PROPS-PATTERN    :prefix* "auth-props"})
       (v/valid? message-props {:pattern* patterns/MESSAGE-PROPS-PATTERN :prefix* "message-props"})
       (let [messages-uri  (utils/create-uri "messages")
             message-props (prototypes/message-props-prototype message-props)
             request-body  (utils/message-props->request-body  message-props)
             basic-auth    (utils/auth-props->basic-auth       auth-props)]
            (clj-http.client/post messages-uri {:body request-body :basic-auth basic-auth :content-type :json}))))
