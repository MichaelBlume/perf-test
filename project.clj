(defproject perf-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main perf-test
  :aot :all
  :java-source-paths ["src-java"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [criterium "0.4.2"]])
