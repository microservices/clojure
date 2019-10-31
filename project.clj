(defproject microservice-app "0.1.0-SNAPSHOT"
 :description "My microservice"
 :dependencies [[org.clojure/clojure "1.10.1"]
                [metosin/compojure-api "2.0.0-SNAPSHOT"]]
 :ring {:handler myservice.app/app :port 8080}
 :min-lein-version "2.0.0"
 :uberjar-name "microservice"
 :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "4.0.1"]]
                 :plugins [[lein-ring "0.12.5"]]}
            :uberjar {:aot :all}})
