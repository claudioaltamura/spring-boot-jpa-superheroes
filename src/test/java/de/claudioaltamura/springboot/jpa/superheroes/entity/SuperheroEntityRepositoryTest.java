package de.claudioaltamura.springboot.jpa.superheroes.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import de.claudioaltamura.springboot.jpa.SuperheroesApplicationPostgeSQLContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import de.claudioaltamura.springboot.jpa.superheroes.repository.SuperheroEntityRepository;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql("/fixtures/insert-cities-superheroes.sql")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SuperheroEntityRepositoryTest extends SuperheroesApplicationPostgeSQLContainer {

	@Autowired
	private SuperheroEntityRepository superheroEntityRepository;

	@Test
	void shouldReturnSuperheroWhenFindByName() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.findByName("Spider-Men");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getCity().getName()).isEqualTo("NYC");
	}

	@Test
	void shouldReturnSuperheroWhenFindByNameStartWith() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.findByNameStartsWith("Sp");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getName()).isEqualTo("Spider-Men");
	}

	@Test
	void shouldReturnSuperheroWhenSearchContainsByNameLike() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.searchContainsByNameLike("der");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getName()).isEqualTo("Spider-Men");
	}
}