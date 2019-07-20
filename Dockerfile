FROM 		clojure:lein-2.9.1 as builder
RUN         mkdir /app
WORKDIR		/app
COPY		project.clj ./
# download all dependencies for the cache
RUN			lein ring jar || true
# copy over all source files and build a standalone jar
COPY        src ./src/
RUN			LEIN_NO_DEV=true lein ring uberjar

FROM        java:8-jre-alpine
WORKDIR		/app
COPY 		--from=builder /app/target/microservice microservice.jar
ENTRYPOINT  ["java", "-jar", "/app/microservice.jar"]
