
Template backend Kotlin microservice with Spring Boot, JOOQ, Flyway, and Postgres
(Allows the rapid creation of rest controllers that read/write data from/to Postgres)

* Start Postgres

Assumes that you have docker installed and postgres image downloaded

`run make`

* Flyway

`./gradlew flywayMigrate -i`

`./gradlew flywayInfo`

* JOOQ

`./gradlew generateJooq`

* Build Project

`./gradlew clean build`

* Run Service

`./gradlew bootRun`

* Example Curl Commands

`curl http://localhost:8080/api/blockchain/1`

`curl -X POST http://localhost:8080/api/blockchain/add \
-H 'Content-Type: application/json' \
-d '{
"name": "blockchain2"
}`