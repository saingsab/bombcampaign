(defproject bombcampaign "0.1.0-SNAPSHOT"
  :description "Bombcampaign: Is the newsletters, subscribers and promotions automation mailing service"
  :url "https://github.com/mrayoung/bombcampaign"
  :license {:name "Bombcampaign"
            :url "https://github.com/mrayoung/bombcampaign"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.draines/postal "2.0.2"]
                 [csv-map "0.1.2"]
                 [clj-time "0.14.4"]
                 [org.clojure/data.json "0.2.7"]]

  :aot  [bombcampaign.core]
  :main bombcampaign.core)
