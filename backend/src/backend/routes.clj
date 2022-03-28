(ns backend.routes
  (:require [schema.core :as s]
            [backend.spellChecker :as spellChecker]))

(defn handler
  [{:keys [parameters]}]
  (let [data (:body parameters)]
    {:status 200
     :body (spellChecker/checkSpelling data)}))


(def check-word-route
  ["/check-word" {:post {:parameters {:body s/Str}
                         :handler handler}}])