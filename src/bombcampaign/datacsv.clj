(ns bombcampaign.datacsv
    (use csv-map.core)
    (require [bombcampaign.sendmail :as sendmail]
             [clojure.data.csv :as csv]
             [clojure.java.io :as io]))

(def datafile "data/contact.csv")
(def _subject "Pre-Order Service")

(defn push-email! []
   (def mailling (atom 0))
    
   (while ( < @mailling 10)
      (do
         (def person (nth (parse-csv (slurp datafile)) @mailling))
         (def _name (get person "name"))
         (def _email (get person "email"))
         (sendmail/send-mail! 
                        _email
                        _email
                        _email
                        _subject
                        (str "Dear " _name))
         (swap! mailling inc))))
