(ns bombcampaign.core
    (require [bombcampaign.hooks :as hooks])
    (:gen-class))

(defn -main []
  (hooks/send-with-thread))