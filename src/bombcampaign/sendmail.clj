(ns bombcampaign.sendmail
    (require [postal.core :refer [send-message]]))
 
;  provie the SMTP 
(def smtp "smtp.gmail.com")

; Credential
(def _username "saing.sab@gmail.com")
(def _password "??????????????????????????????")

(defn send-mail! [mail-from mail-to mail-cc mail-subject mail-body]
    (send-message { :host smtp
                    :ssl true
                    :user _username
                    :pass _password }
                  { :from mail-from
                    :to mail-to
                    :cc mail-cc
                    :subject mail-subject
                    :body mail-body}))

