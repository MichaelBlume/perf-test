(ns perf-test
  (:import (PerfTest))
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

(defn locking-part [x l]
  (monitor-enter l)
  (let [res (dec x)]
    (monitor-exit l)
    res))

(defn baz [x]
  (if (> x 0)
    (inc x)
    (locking-part x o)))

(defn -main []
  (println "benching foo")
  (bench (foo 5) :verbose) 
  (println "benching bar")
  (bench (bar 5) :verbose)
  (println "benching baz")
  (bench (baz 5) :verbose)

  (println "benching java port")

  (println "benching foo")
  (bench (PerfTest/foo 5) :verbose)
  (println "benching bar")
  (bench (PerfTest/bar 5) :verbose)
  (println "benching baz")
  (bench (PerfTest/baz 5) :verbose)
  (println "done benching"))

