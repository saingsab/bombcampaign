(ns bombcampaign.sendmail
    (require [postal.core :refer [send-message]]
             [clojure.string :as str]
             [clojure.java.io :as io]
             [bombcampaign.logs :as logs]))

(def config "data/config.txt")

(defn send-mail! [mail-to mail-content]
  (try
    (send-message {:host (get (str/split (slurp config) #",") 2)
                    ; :port (Integer. (get env :portmail))
                    :ssl true
                    :user (get (str/split (slurp config) #",") 0)
                    :pass (get (str/split (slurp config) #",") 1)}
                  {:from (get (str/split (slurp config) #",") 3)
                    :to mail-to
                    :subject (get (str/split (slurp config) #",") 5)
                    :body [{:type "text/html"
                            :content (str mail-content)}]})
    (logs/write-log! (str "SUCCE : " mail-to))
    (catch Exception ex
      (logs/write-log! (str "ERROR : FN send-mail! " ex)))))
                    