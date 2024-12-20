![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/claudioaltamura/spring-boot-jpa-superheroes/ci.yml?branch=main)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# spring-boot-jpa-superheroes
Spring Boot JPA example

* @DataJpaTest with Testcontainers
* Liquibase
* ...

## Liquibase init

    Postgres https://docs.liquibase.com/start/tutorials/postgresql.html

    liquibase init project \
    --project-dir=./src/main/resources/liquibase \
    --changelog-file=db.changelog-master.yaml \
    --format=yaml \
    --project-defaults-file=liquibase.properties \
    --url=jdbc:postgresql://localhost:5432/superheroes \
    --username=hero \
    --password=1234

### Liquibase generate and 

    https://docs.liquibase.com/commands/home.html

    cd src/main/resources/db

    liquibase generate-changelog

    liquibase changelog-sync

    liquibase status

    liquibase clear-checksums

#### Maven

    https://docs.liquibase.com/tools-integrations/maven/commands/home.html
