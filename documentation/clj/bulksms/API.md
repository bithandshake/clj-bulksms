
# bulksms.api Clojure namespace

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > bulksms.api

### Index

- [acknowledge?](#acknowledge)

- [send-message!](#send-message)

### acknowledge?

```
@param (map) response
{:status (integer)}
```

```
@usage
(acknowledge? (send-message! {...} {...}))
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn acknowledge?
  [response]
  (-> response :status (math/between? 200 299)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [bulksms.api :refer [acknowledge?]]))

(bulksms.api/acknowledge? ...)
(acknowledge?             ...)
```

</details>

---

### send-message!

```
@param (map) auth-props
{:password (string)(opt)
 :token-id (string)(opt)
 :token-secret (string)(opt)
 :username (string)(opt)}
@param (map) message-props
{:body (string)
 :to (string or strings in vector)}
```

```
@usage
(send-message! {:username "my-user" :password "psw1234"}
               {...})
```

```
@usage
(send-message! {:token-id "..." :token-secret "..."}
               {...})
```

```
@usage
(send-message! {...}
               {:to "+1234567890" :body "Hi there!"})
```

```
@usage
(send-message! {...}
               {:to ["+1234567890" "+0987654321"] :body "Hi there!"})
```

```
@return (?)
```

<details>
<summary>Source code</summary>

```
(defn send-message!
  [auth-props message-props]
  (and (v/valid? auth-props    {:pattern* patterns/AUTH-PROPS-PATTERN    :prefix* "auth-props"})
       (v/valid? message-props {:pattern* patterns/MESSAGE-PROPS-PATTERN :prefix* "message-props"})
       (let [messages-uri  (utils/create-uri "messages")
             message-props (prototypes/message-props-prototype message-props)
             request-body  (utils/message-props->request-body  message-props)
             basic-auth    (utils/auth-props->basic-auth       auth-props)]
            (clj-http.client/post messages-uri {:body request-body :basic-auth basic-auth :content-type :json}))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [bulksms.api :refer [send-message!]]))

(bulksms.api/send-message! ...)
(send-message!             ...)
```

</details>

---

This documentation is generated with the [clj-docs-generator](https://github.com/bithandshake/clj-docs-generator) engine.

