plugins {
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
	id("java")
    id("com.diffplug.spotless") version "6.25.0"
    id("com.github.ben-manes.versions") version "0.51.0"
}

group = "de.claudioaltamura"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
    compileOnly ("org.projectlombok:lombok")

    annotationProcessor ("org.projectlombok:lombok")

    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-validation")
    implementation ("org.postgresql:postgresql:42.7.4")

    developmentOnly ("org.springframework.boot:spring-boot-devtools")
    runtimeOnly ("org.liquibase:liquibase-core")

    testCompileOnly ("org.projectlombok:lombok")

    testAnnotationProcessor ("org.projectlombok:lombok")

    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.testcontainers:junit-jupiter")
    testImplementation ("org.testcontainers:postgresql")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
