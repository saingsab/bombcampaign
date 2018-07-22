(ns bombcampaign.datacsv
    (use csv-map.core)
    (require [bombcampaign.sendmail :as sendmail]
             [clj-time.core :as t]
             [clojure.data.csv :as csv]
             [clojure.java.io :as io]))

(def file-contact "data/contact.csv")
(def file-mail "data/config.csv")
(def file-contents "data/content.csv")
(def _logfile "data/sendmaillog/mailinglog.log")
(def _subject "Pre-Order Service")


(def mailconfig (nth (parse-csv (slurp file-mail)) 0))
(def content (nth (parse-csv (slurp file-contents)) 0))

(defn push-email! []
   (def mailling (atom 0))
   (while ( < @mailling 2)
      (do
         (def person (nth (parse-csv (slurp file-contact)) @mailling))
         (def _name (get person "name"))
         (def  _mail-to (get person "email"))
         (def smtp (get mailconfig "smtp"))
         (def _username (get mailconfig "username"))
         (def _password (get mailconfig "password"))
         (def _mail-from (get mailconfig "mail-from"))
         (def _mail-cc (get mailconfig "mail-cc"))
         (def _paragraph1 (get content "paragraph1"))
         (def _paragraph2 (get content "paragraph2"))
         (def _paragraph3 (get content "paragraph3"))

         (try 
            (sendmail/send-mail! 
                        smtp
                        _username
                        _password
                        _mail-from
                        _mail-to
                        _mail-cc
                        _subject
                        (str "Dear " _name "\n" "\n" _paragraph1 "\n" "\n" _paragraph2 "\n" "\n" _paragraph3)) 
             (with-open [wrtr (io/writer _logfile :append true)]
                (.write wrtr (str "\n" "SEND : " _mail-to " AT: " (t/to-time-zone (t/now) (t/time-zone-for-offset +7)) )))
             
             (catch Exception e
                (with-open [wrtr (io/writer _logfile :append true)]
                    (.write wrtr (str "\n" "ERROR : " _mail-to " " (.getMessage e) " AT : " (t/to-time-zone (t/now) (t/time-zone-for-offset +7)))))))
         
         (swap! mailling inc))))
