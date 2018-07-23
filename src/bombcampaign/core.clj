(ns bombcampaign.core
    (require [bombcampaign.datacsv :as datacsv]
             [bombcampaign.sendmail :as sendmail])
    (:gen-class))

(defn -main []
  (datacsv/push-email!)
  (datacsv/remove-contact file-contact 2 199))
