(def app-host (or (System/getenv "APP_HOST")
                  (throw (Exception. "APP_HOST is not defined"))))

(defproject org.broadinstitute/shibsp "0.0.1"
  :dependencies [
                 [org.clojure/clojure "1.7.0"] ; keep up-to-date with clojurescript dep
                 [org.clojure/clojurescript "1.7.145"]
                 ]
  :plugins [[lein-cljsbuild "1.1.0-SNAPSHOT"]]
  :profiles {:dev
             {:cljsbuild
              {:builds
               {:client {:notify-command ["curl" "-sk" ~(str "https://" app-host "/restart")]}}}}}
  :cljsbuild {:builds {:client {:source-paths ["src/cljs"]
                                :compiler
                                {:target :nodejs}}}})
