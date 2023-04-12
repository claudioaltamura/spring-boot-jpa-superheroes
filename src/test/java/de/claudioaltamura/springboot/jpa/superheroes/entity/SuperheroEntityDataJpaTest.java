package de.claudioaltamura.springboot.jpa.superheroes.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import de.claudioaltamura.springboot.jpa.superheroes.repository.SuperheroEntityRepository;

import jakarta.transaction.Transactional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@Transactional
class SuperheroEntityDataJpaTest {

	@Container
	private static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14.1");

	@Autowired
	private SuperheroEntityRepository superheroEntityRepository;

	@DynamicPropertySource
	public static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url",postgreSQLContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
	}

	@Test
	void testInteractionWithDatabase() {
		final var city = new CityEntity("New York City");
		superheroEntityRepository.save(new SuperheroEntity("Spider-Men", "Peter Parker", 92.0d, city));

		List<SuperheroEntity> superheroes = superheroEntityRepository.findByName("Spider-Men");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getCity().getName()).isEqualTo("New York City");
	}
}