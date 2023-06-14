
(ns bulksms.patterns)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @ignore
;
; @description
; https://github.com/bithandshake/cljc-validator
;
; @constant (map)
(def AUTH-PROPS-PATTERN
     {:password     {:rep* [:token-id :token-secret]
                     :f*   string?
                     :not* empty?
                     :e*   ":username must be a nonempty string!"}
      :token-id     {:rep* [:username :password]
                     :f*   string?
                     :not* empty?
                     :e*   ":token-id must be a nonempty string!"}
      :token-secret {:rep* [:username :password]
                     :f*   string?
                     :not* empty?
                     :e*   ":token-secret must be a nonempty string!"}
      :username     {:rep* [:token-id :token-secret]
                     :f*   string?
                     :not* empty?
                     :e*   ":username must be a nonempty string!"}})

; @ignore
;
; @description
; https://github.com/bithandshake/cljc-validator
;
; @constant (map)
(def MESSAGE-PROPS-PATTERN
     {:body {:f*   string?
             :not* empty?
             :e*   ":body must be a nonempty string!"}
      :to   {:or*  [string? vector?]
             :not* empty?
             :e*   ":to must be a nonempty string or nonempty strings in a vector!"}})
