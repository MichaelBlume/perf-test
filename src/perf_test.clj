(ns perf-test
  (:use (criterium core))
  (:gen-class))

(def o (Object.))

(defn foo [x]
  (if (> x 0)
    (inc x)
    (do
      (monitor-enter o)
      (let [res (dec x)]
        (monitor-exit 0)
        res))))

(defn bar [x]
  (if (> x 0)
    (inc x)
    (dec x)))

(defn -main []
  (println "benching foo")
  (bench (foo 5) :verbose) 
  (println "benching bar")
  (bench (bar 5) :verbose)
  (println "done benching"))

