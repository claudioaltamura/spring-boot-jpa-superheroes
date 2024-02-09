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
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SuperheroEntityRepositoryTest extends SuperheroesApplicationPostgeSQLContainer {

	@Autowired
	private SuperheroEntityRepository superheroEntityRepository;

	@Test
	void shouldSaveSuperhero() {
		final var city = new CityEntity("Keystone Quadrant");
		superheroEntityRepository.save(new SuperheroEntity("Rocket", "Rocket Raccoon", 90.0d, city));

		List<SuperheroEntity> superheroes = superheroEntityRepository.findByName("Rocket");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getRealName()).isEqualTo("Rocket Raccoon");
	}

	@Test
	@Sql("/fixtures/insert-cities-superheroes.sql")
	void shouldReturnSuperheroWhenFindByName() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.findByName("Spider-Men");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getCity().getName()).isEqualTo("NYC");
	}

	@Test
	@Sql("/fixtures/insert-cities-superheroes.sql")
	void shouldReturnSuperheroWhenFindByNameStartWith() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.findByNameStartsWith("Sp");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getName()).isEqualTo("Spider-Men");
	}

	@Test
	@Sql("/fixtures/insert-cities-superheroes.sql")
	void shouldReturnSuperheroWhenSearchContainsByNameLike() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.searchContainsByNameLike("der");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getName()).isEqualTo("Spider-Men");
	}
}