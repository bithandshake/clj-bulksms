
# clj-bulksms

### Overview

The <strong>clj-bulksms</strong> is a simple Clojure API library for bulksms.com.

### deps.edn

```
{:deps {bithandshake/clj-bulksms {:git/url "https://github.com/bithandshake/clj-bulksms"
                                  :sha     "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}}
```

### Current version

Check out the latest commit on the [release branch](https://github.com/bithandshake/clj-bulksms/tree/release).

### Documentation

The <strong>clj-bulksms</strong> functional documentation is [available here](documentation/COVER.md).

### Changelog

You can track the changes of the <strong>clj-bulksms</strong> library [here](CHANGES.md).

# Usage

### Index

- [How to send an SMS?](#how-to-send-an-sms)

- [How to acknowledge the sending?](#how-to-acknowledge-the-sending)

### How to send an SMS?

The [`bulksms.api/send-message!`](documentation/clj/bulksms/API.md/#send-message)
function sends an SMS message.

```
(send-message! {:username "my-user" :password "psw1234"}
               {...})
```

```
(send-message! {:token-id "..." :token-secret "..."}
               {...})
```

```
(send-message! {...}
               {:to "+1234567890" :body "Hi there!"})

```

```
(send-message! {...}
               {:to ["+1234567890" "+0987654321"] :body "Hi there!"})
```

### How to acknowledge the sending?

The [`bulksms.api/acknowledge?`](documentation/clj/bulksms/API.md/#acknowledge)
function returns true if the message has been sent without errors.

```
(acknowledge? (send-message! {...} {...}))
```
