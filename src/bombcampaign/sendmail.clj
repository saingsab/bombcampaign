(ns bombcampaign.sendmail
    (require [postal.core :refer [send-message]]))

(defn send-mail! [smtp _username _password mail-from mail-to mail-cc mail-subject mail-body]
    (send-message { :host smtp
                    :ssl true
                    :user _username
                    :pass _password }
                  { :from mail-from
                    :to mail-to
                    :cc mail-cc
                    :subject mail-subject
                    :body mail-body}))

