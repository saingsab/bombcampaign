# Bombcampaign

A sigal Java application writen Clojure for sending mask email for your general purpose.
This application using [Postal](https://github.com/drewr/postal) is a library for constructing and sending RFC822-compliant Internet email messages. and [Clojure v1.10.1](https://clojure.github.io/clojure/clojure.java.io-api.html) To reader/writer to/from Clojure data structures to interact with text file.

## Usage
### I Build
If you want to contribute or build on your won pc here is the environment setup [How to install Leiningen project tool for Clojure on Arch Linux](https://www.ayoungnotes.com/How-to-install-Leiningen-project-tool-for-Clojure-on-Arch-Linux).

Bellow is the build guide:

1) Download the dependencies with the following commend: 
```
lein deps
```
2) Compile Application with the following commend: 
```
lein compile
```
3) Build a Java Application with the following commend: 
```
lein uberjar
```
4) Run Application
```
java -jar bombcampaign-0.1.0-SNAPSHOT-standalone.jar
```

### Start Sending Email

1) Prerequisites 

Bombcampaign running on JVM so before runing an application need to install Java JDK [How to install OpenJDK In Pionux or any Arch Linux base](https://www.ayoungnotes.com/How-to-install-OpenJDK-In-Pionux-or-any-Arch-Linux-base)

2) Get Software 
Download the [Official Release](https://github.com/mrayoung/bombcampaign/releases)

3) Configure
There are three files in side data folder. config.txt is where you confige SMTP server. In contact.txt is list of email who you want to send your email to. And content.txt is your email body.

4) Excute
Double click on bombcampaign-0.1.0-SNAPSHOT-standalone.jar 

5) Verify 
The application log at data/sendmaillog/mailinglog.log so all the email and error log will show here.

For realtime monitor you can use 
```
tail -f data/sendmaillog/mailinglog.log
```

Note* 
- Make sure that the data directory is there with bombcampaign-0.1.0-SNAPSHOT-standalone.jar
- To verify the sending email and error log go to data/sendmaillog/mailinglog.log

Issues report to developer [here](https://github.com/mrayoung/bombcampaign/issues)

## License

Copyright © 2020 Mr.Ayoung

Distributed under Free License.
