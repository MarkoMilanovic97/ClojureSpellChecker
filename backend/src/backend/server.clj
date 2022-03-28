(ns backend.server
  (:require [org.httpkit.server :refer [run-server]]
            [reitit.ring :as ring]
            [ring.middleware.cors :refer [wrap-cors]]
            [reitit.ring.middleware.exception :refer [exception-middleware]]
            [reitit.ring.middleware.parameters :refer [parameters-middleware]]
            [reitit.ring.middleware.muuntaja :refer [format-negotiate-middleware
                                                     format-request-middleware
                                                     format-response-middleware]]
            [reitit.ring.coercion :refer [coerce-exceptions-middleware
                                          coerce-request-middleware
                                          coerce-response-middleware]]
            [reitit.coercion.schema]
            [muuntaja.core :as m]
            [backend.routes :refer [check-word-route]]))

(defonce server (atom nil))

(def app
  (ring/ring-handler
   (ring/router
    [["/api"
      check-word-route]]
    {:data {:coercion reitit.coercion.schema/coercion
            :muuntaja m/instance
            :middleware [[wrap-cors 
                          :access-control-allow-origin [#"http://localhost:3000"]
                          :access-control-allow-methods [:post]]
                         parameters-middleware
                         format-negotiate-middleware
                         format-response-middleware
                         exception-middleware
                         format-request-middleware
                         coerce-exceptions-middleware
                         coerce-request-middleware
                         coerce-response-middleware]}})
   (ring/routes
    (ring/redirect-trailing-slash-handler)
    (ring/create-default-handler
     {:not-found (constantly {:status 404
                              :body "Route not found"})}))))

(defn start-server []
  (println "Server started")
  (reset! server (run-server app {:port 4000})))

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn restart-server []
  (stop-server)
  (start-server))