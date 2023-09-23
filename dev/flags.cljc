(ns flags
  (:require [camel-snake-kebab.core :as csk]
            [clojure.string :as str]))

(defn- gen-var [flag-type line]
  (when-let [[_ name _val] (re-matches #"\s*(\w+)\s*=\s*(\d+)\s*,?\s*" line)]
    (str "(def "
         (csk/->kebab-case-string name)
         " (.-" name " ts/" flag-type ")"
         ")")))

(defn gen [flag-type source]
  (->> source
       (str/split-lines)
       (keep (partial gen-var flag-type))
       (run! println)))

(comment
  (gen "TypeFlags"
       "
    Any = 1,
    Unknown = 2,
    String = 4,
    Number = 8,
    Boolean = 16,
    Enum = 32,
    BigInt = 64,
    StringLiteral = 128,
    NumberLiteral = 256,
    BooleanLiteral = 512,
    EnumLiteral = 1024,
    BigIntLiteral = 2048,
    ESSymbol = 4096,
    UniqueESSymbol = 8192,
    Void = 16384,
    Undefined = 32768,
    Null = 65536,
    Never = 131072,
    TypeParameter = 262144,
    Object = 524288,
    Union = 1048576,
    Intersection = 2097152,
    Index = 4194304,
    IndexedAccess = 8388608,
    Conditional = 16777216,
    Substitution = 33554432,
    NonPrimitive = 67108864,
    TemplateLiteral = 134217728,
    StringMapping = 268435456,
    Literal = 2944,
    Unit = 109440,
    StringOrNumberLiteral = 384,
    PossiblyFalsy = 117724,
    StringLike = 402653316,
    NumberLike = 296,
    BigIntLike = 2112,
    BooleanLike = 528,
    EnumLike = 1056,
    ESSymbolLike = 12288,
    VoidLike = 49152,
    UnionOrIntersection = 3145728,
    StructuredType = 3670016,
    TypeVariable = 8650752,
    InstantiableNonPrimitive = 58982400,
    InstantiablePrimitive = 406847488,
    Instantiable = 465829888,
    StructuredOrInstantiable = 469499904,
    Narrowable = 536624127,
   ")
  )
