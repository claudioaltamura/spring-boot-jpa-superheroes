-- liquibase formatted sql
-- changeset claudio.altamura:initial-database-setup
CREATE TABLE "cities" ("id" BIGSERIAL PRIMARY KEY, "name" VARCHAR(255) NOT NULL);

CREATE INDEX "idx_city_name" ON "cities"("name");

CREATE TABLE "superheroes" ("id" BIGSERIAL PRIMARY KEY, "name" VARCHAR(255), "power" FLOAT8 NOT NULL, "real_name" VARCHAR(255), "city_id" BIGINT NOT NULL);

ALTER TABLE "superheroes" ADD CONSTRAINT "fk_cities_supeheroes" FOREIGN KEY ("city_id") REFERENCES "cities" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE UNIQUE INDEX "idx_sh_name_unq" ON "superheroes"("name");