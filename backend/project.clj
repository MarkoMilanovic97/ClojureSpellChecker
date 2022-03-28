(defproject backend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/data.json "2.4.0"]
                 ;; https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
                 [org.apache.commons/commons-lang3 "3.12.0"]
                 [metosin/reitit "0.5.2"]
                 [http-kit "2.3.0"]
                 [ring-cors "0.1.13"]]
  :main ^:skip-aot backend.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
