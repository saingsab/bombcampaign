(ns bombcampaign.hooks
    (use csv-map.core)
    (require [bombcampaign.sendmail :as sendmail]
             [clojure.string :as str]
             [clojure.java.io :as io]
             [bombcampaign.logs :as logs]))

(def contact "data/contact.txt")
(def content (slurp "data/content.txt"))
(def config "data/config.txt")
(def _logfile "data/sendmaillog/mailinglog.log")
(def _name (get (str/split (slurp contact) #",") 0))

(def amount-to-be-sent
   (Integer. (get (str/split (slurp config) #",") 6)))

(defn remove-contact! [filepath start nskip]
    (with-open [rdr (io/reader filepath)]
        (with-open [wrt (io/writer (str filepath ".tmp"))]
        (loop [s start n nskip]
            (if-let [line (.readLine rdr)]
            (cond
                (> s 1)  (do (doto wrt (.write line) (.newLine))
                            (recur (dec s) n))
                (pos? n) (recur s (dec n))
                :else    (do (doto wrt (.write line) (.newLine))
                            (recur s n)))
            (when (pos? n)
                (println "WARN: You are trying to remove lines beyond EOF"))))))
(.renameTo (io/file (str filepath ".tmp")) (io/file filepath)))

(defn send-with-thread []
    (def i (atom 1))
    (println i)
    (while ( <= @i amount-to-be-sent )
        (do 
            (try
                (sendmail/send-mail! (str (get (str/split (slurp contact) #",") 1))
                                     (str "Dear " (get (str/split (slurp contact) #",") 0) "\n" "\n" content))
                (remove-contact! contact 0 1)

                (catch Exception ex
                    (logs/write-log! (str "ERROR : FN send-with-thread "(ex)))))
            (swap! i inc))))