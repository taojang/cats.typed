(ns cats.typed.builtin
  (:require [clojure.core.typed :as t]
            [cats.protocols :refer :all]
            [cats.typed.protocols]
            [cats.builtin]))

(t/ann ^:no-check cats.builtin/any-monoid (t/I Context (Monoid t/Bool)))
