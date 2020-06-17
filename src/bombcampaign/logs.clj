(ns bombcampaign.logs
    (require [clojure.java.io :as io]
             [clj-time.core :as t]))

(def _logfile "data/sendmaillog/mailinglog.log")

(defn write-log!
    [msg]
    (with-open [wrtr (io/writer _logfile :append true)]
        (.write wrtr (str "\n" msg " At: " (t/to-time-zone (t/now) (t/time-zone-for-offset +7))))))
          