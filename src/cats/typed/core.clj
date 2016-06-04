(ns cats.typed.core
  (:require [clojure.core.typed :as t]
            [cats.core]
            [cats.protocols :refer :all]
            [cats.context :as ctx]
            [cats.builtin :as builtin]
            [cats.typed.context]
            [cats.typed.protocols]
            [cats.typed.builtin]))

(t/ann ^:no-check clojure.core/satisfies? (t/All [x] [x t/Any -> t/Bool :filters {:then (is x 0) :else (! x 0)}]))

(t/ann ^:no-check cats.core/mempty (t/All [x] [(Monoid x) -> x]))

(t/ann ^:no-check cats.core/mappend (t/All [x] [x * -> x]))

(t/ann mempty-any-monoid-test t/Bool)
(def mempty-any-monoid-test
  (cats.core/mempty builtin/any-monoid))


(t/ann mappend-any-monoid-test t/Bool)
(def mappend-any-monoid-test
  (ctx/with-context builtin/any-monoid (cats.core/mappend true false)))

(comment
  (t/check-ns)
  )
