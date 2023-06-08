package de.claudioaltamura.springboot.jpa.superheroes.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import de.claudioaltamura.springboot.jpa.SuperheroesApplicationPostgeSQLContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import de.claudioaltamura.springboot.jpa.superheroes.repository.SuperheroEntityRepository;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SuperheroEntityRepositoryTest extends SuperheroesApplicationPostgeSQLContainer {

	@Autowired
	private SuperheroEntityRepository superheroEntityRepository;

	@BeforeEach
	public void setUp() {
		final var city = new CityEntity("New York City");
		superheroEntityRepository.save(new SuperheroEntity("Spider-Men", "Peter Parker", 92.0d, city));
	}
	@Test
	void findByNameShouldReturnSuperhero() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.findByName("Spider-Men");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getCity().getName()).isEqualTo("New York City");
	}

	@Test
	void findByNameStartsWithShouldReturnSuperhero() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.findByNameStartsWith("Sp");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getName()).isEqualTo("Spider-Men");
	}

	@Test
	void searchContainsByNameLikeShouldReturnSuperhero() {
		List<SuperheroEntity> superheroes = superheroEntityRepository.searchContainsByNameLike("der");

		assertThat(superheroes).hasSize(1);
		assertThat(superheroes.get(0).getName()).isEqualTo("Spider-Men");
	}
}