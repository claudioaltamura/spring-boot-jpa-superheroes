package de.claudioaltamura.springboot.jpa;

import de.claudioaltamura.springboot.jpa.superheroes.entity.CityEntity;
import de.claudioaltamura.springboot.jpa.superheroes.entity.SuperheroEntity;
import de.claudioaltamura.springboot.jpa.superheroes.repository.SuperheroEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SuperheroesApplication {

	@Autowired
	private SuperheroEntityRepository superheroEntityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			if(!superheroEntityRepository.existsById(1L)) {
				final var city = new CityEntity("Gotham City");
				superheroEntityRepository.save(new SuperheroEntity("Batman", "Bruce Wayne", 92.0d, city));
			}
		};
	}
}
