package de.claudioaltamura.springboot.jpa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SuperheroesApplicationTests extends SuperheroesApplicationPostgeSQLContainer {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
