(ns myservice.app
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            ))

(s/defschema User
  {:name s/Str})

(s/defschema UserResponse
  {:message s/Str})

(defapi app
    (GET "/health" []
      (ok "OK"))

    (POST "/message" []
      :body [{:keys [name]} User]
      :return UserResponse
      (ok {:message (str "Hello " name)})))
