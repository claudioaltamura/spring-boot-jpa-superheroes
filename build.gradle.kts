plugins {
    java
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.diffplug.spotless") version "8.1.0"
    id("com.github.ben-manes.versions") version "0.53.0"
}

group = "de.claudioaltamura"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot and JPA"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
	mavenCentral()
}

dependencies {
    compileOnly ("org.projectlombok:lombok")

    annotationProcessor ("org.projectlombok:lombok")

    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-validation")
    implementation ("org.postgresql:postgresql:42.7.8")

    developmentOnly ("org.springframework.boot:spring-boot-devtools")
    runtimeOnly ("org.liquibase:liquibase-core")

    testCompileOnly ("org.projectlombok:lombok")

    testAnnotationProcessor ("org.projectlombok:lombok")

    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.testcontainers:junit-jupiter")
    testImplementation ("org.testcontainers:postgresql")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
