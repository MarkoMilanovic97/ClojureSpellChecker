(ns backend.core
  (:require [backend.server :as server]))

(defn -main []
  (server/restart-server))