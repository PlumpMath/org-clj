(defproject coldnew/org-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.189"]
                 [com.lucasbradstreet/instaparse-cljs "1.4.1.0"]
                 [environ "1.0.1"]]

  :test-paths ["spec"]
  :source-paths ["src"]

  :plugins [[speclj "3.3.1"]
            [lein-cljsbuild "1.1.1"]
            [lein-environ "1.0.1"]
            [lein-codox "0.9.0"]]

  :cljsbuild {:builds {:dev  {:source-paths ["src/cljs" "spec/cljs"]
                              :compiler     {:output-to "target/org-clj.js"}
                              :notify-command ["phantomjs" "bin/speclj" "target/org-clj.js"]}
                       :prod {:source-paths  ["src/cljs"]
                              :compiler      {:output-to "target/org-clj.js"
                                              :optimizations :simple}}}
              :test-commands {"test" ["phantomjs"  "bin/speclj" "target/org-clj.js"]}}

  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}

  :codox {:source-uri "http://github.com/coldnew/org-clj/blob/master/{filepath}#L{line}"})
