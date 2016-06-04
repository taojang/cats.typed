(ns cats.typed.context
  (:require [clojure.core.typed :as t]
            [cats.context]
            [cats.protocols :refer :all]
            [cats.typed.protocols]))

(t/defalias TypeClasses
  (t/All [[x :< (t/U (t/I Context (t/U (Semigroup t/Any) (Monoid t/Any)))
                     nil)]]
         x))

(t/ann ^:no-check cats.context/*context*
       (t/All [x]
              (t/Option (t/I Context (t/U (Semigroup x) (Monoid x))))))

(t/ann ^:no-check cats.context/+level-default+ t/Num)
(t/ann ^:no-check cats.context/+level-transformer+ t/Num)

(t/ann ^:no-check cats.context/throw-ilegal-argument [t/Str -> Error])
