# Bombcampaign

A Clojure Web service for sending email for your marketing purpose.
Thanks to https://www.rosettacode.org/wiki/Send_email#Clojure

Tobe added more!
## Usage
To config the mail account in the data/config.csv
To add the e-mail listing go to data/contact.csv
To Edit e-mail content go to data/content.csv

1) Download the dependencies with the following commend: 
```
lein deps
```

---
2) Compile Application with the following commend: 
---
lein compile
---
3) Build a Java Application with the following commend: 
---
lein uberjar
---
4) Run Application
---
java -jar bombcampaign-0.1.0-SNAPSHOT-standalone.jar
----

Note* 
- Make sure that the data directory is there with bombcampaign-0.1.0-SNAPSHOT-standalone.jar
- To verify the sending email and error log go to data/sendmaillog/mailinglog.log

## License

Copyright © 2018 Mr Ayoung

Distributed under Free License.
