(ns dots.util.names
  (:require [camel-snake-kebab.core :as csk]
            [clojure.string :as str])
  #?(:cljs (:require-macros [dots.util.names :refer [cljs-core-macro-names]])))

(defn- collect-cljs-core-public-names [coll]
  (into coll (map (comp name key)) (ns-publics 'cljs.core)))

(defmacro ^:private cljs-core-macro-names []
  (collect-cljs-core-public-names #{}))

(def ^:private cljs-core-public-names
  (collect-cljs-core-public-names (cljs-core-macro-names)))

(defn cljs-core-name?
  "Returns true if there is a public symbol in the `cljs.core` namespace
   with the same name as the string `n`."
  [n]
  (contains? cljs-core-public-names n))

(defn internal?
  "Returns true if the naming convention of `n` indicates it is for
   internal use."
  [n]
  (str/starts-with? n "_"))

(defn cljs-name
  "Transforms a TypeScript name into a ClojureScript one."
  [n]
  {:pre [(string? n)]}
  (-> n
      (str/replace "\"" "")
      (str/replace #"\W+" "_")
      csk/->kebab-case-string
      (cond->
       (str/starts-with? n "_") (->> (str "-"))
       (str/ends-with? n "_") (str "*"))))

(defn split-fqn
  "Splits a TypeScript fully-qualified name into a vector of strings."
  [fqn]
  (vec (re-seq #"\"[^\"]+\"|\w+" fqn)))

(def reserved-names #{"nil"})

(defn munge-name
  "Ensures `n` is useable as a ClojureScript name, munging it as necessary."
  [n]
  (if (reserved-names n)
    (str (n "*"))
    n))

(defn strip-getter-prefix
  "Removes a `get-` or `is-` prefix from the ClojureScript name `n`."
  [n]
  (if-let [[_ n*] (re-matches #"(?:get|is)-(.+)" n)]
    n*
    n))

(defn quoted? [n]
  (str/starts-with? n "\""))
