(ns cats.typed.protocols
  (:require [clojure.core.typed :as t]
            [cats.protocols :refer :all]))

(t/ann-protocol ^:no-check cats.protocols/Context
                -get-level [Context -> t/Num])

(t/ann-protocol ^:no-check cats.protocols/Contextual
                -get-context [Contextual -> cats.typed.context/TypeClasses])

(t/ann-protocol ^:no-check [[x :variance :covariant]]
                cats.protocols/Monoid
                -mempty [(cats.protocols/Monoid x) -> x])

(t/ann-protocol ^:no-check [[x :variance :covariant]]
                cats.protocols/Semigroup
                -mappend [(cats.protocols/Semigroup x) x x -> x])
