# ichan-springdatajpajsonb

While using **Spring Boot** with **PostgreSQL**, have you ever needed to retrieve or persist data to `JSONB` column? If your answer is yes, you might want to check [this journal entry](https://journal.ichan.moe/spring-data-jpa-with-postgresqls-jsonb).

This Sprint Boot project is built using following setting.

| | |
| --- | --- |
| Project | Maven |
| Language | Java |
| Spring Boot | 3.3.3 |

**Project Metadata:**

| | |
| --- | --- |
| Group | `moe.ichan` |
| Artifact | `ichan-springdatajpajsonb` |
| Name | ichan-springdatajpajsonb |
| Description | ichan-springdatajpajsonb |
| Package Name | `moe.ichan.springdatajpajsonb` |
| Packaging | Jar |
| Java | 17 |

**Dependencies:**
- Lombok
- Validation
- PostgreSQL Driver
- Flyway Migration
- Spring Data JPA
- Spring Security
- Spring Boot Actuator
- Spring Web

Check [this project's Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.3.3&packaging=jar&jvmVersion=17&groupId=moe.ichan&artifactId=ichan-springdatajpajsonb&name=ichan-springdatajpajsonb&description=ichan-springdatajpajsonb&packageName=moe.ichan.springdatajpajsonb&dependencies=lombok,validation,postgresql,flyway,data-jpa,security,actuator,web).

## Environment Variables

Environment variables used to run this project as follows.
```
SPRING_POSTGRESQL_DRIVER=org.postgresql.Driver
SPRING_POSTGRESQL_PASSWORD=YourPostgresqlPassword
SPRING_POSTGRESQL_URL=jdbc:postgresql://localhost:5432/ichan-springdatajpajsonb?currentSchema=ichan_schema
SPRING_POSTGRESQL_USERNAME=YourPostgresqlUsername
```

> [!NOTE]
> Modify `YourPostgresqlPassword` and `YourPostgresqlUsername` according to your PostgreSQL database credential.
> 
> You might want to adjust the value of `SPRING_POSTGRESQL_URL` according to your PostgreSQL location. However, please keep using `currentSchema=ichan_schema` in your connection string.

## cURL

After you have successfully run the project, you could use following cURL to hit the project's API.

### Create Sample
```shell
curl --location 'http://localhost:8080/api/v1/crud/sample' \
--data '{
    "sample_id": "ID1",
    "sample_name": "Sample One",
    "child_jsons": [
        "A",
        "B"
    ]
}'
```

### Get Sample
```shell
curl --location 'http://localhost:8080/api/v1/crud/sample?sample_name=sample%20one&size=10&page=0'
```
