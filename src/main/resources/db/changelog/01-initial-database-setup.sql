-- liquibase formatted sql
-- changeset claudio.altamura:initial-database-setup
CREATE TABLE "cities" ("id" BIGINT NOT NULL, "name" VARCHAR(255) NOT NULL, CONSTRAINT "cities_pkey" PRIMARY KEY ("id"));

CREATE SEQUENCE IF NOT EXISTS "cities_seq" AS bigint START 1 INCREMENT 50 OWNED BY cities.id;

CREATE INDEX "idx_city_name" ON "cities"("name");

CREATE TABLE "superheroes" ("id" BIGINT NOT NULL, "name" VARCHAR(255), "power" FLOAT8 NOT NULL, "real_name" VARCHAR(255), "city_id" BIGINT NOT NULL, CONSTRAINT "superheroes_pkey" PRIMARY KEY ("id"));

ALTER TABLE "superheroes" ADD CONSTRAINT "fk_cities_supeheroes" FOREIGN KEY ("city_id") REFERENCES "cities" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE SEQUENCE IF NOT EXISTS "superheroes_seq" AS bigint START 1 INCREMENT 50 OWNED BY superheroes.id;

CREATE UNIQUE INDEX "idx_sh_name_unq" ON "superheroes"("name");