package de.claudioaltamura.springboot.jpa.superheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.claudioaltamura.springboot.jpa.superheroes.entity.SuperheroEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SuperheroEntityRepository extends JpaRepository<SuperheroEntity, Long> {
	List<SuperheroEntity> findByName(String name);

	List<SuperheroEntity> findByNameStartsWith(String name);

	@Query(value = "SELECT * FROM Superheroes s WHERE s.name LIKE %:name%", nativeQuery = true)
	List<SuperheroEntity> searchContainsByNameLike(@Param("name") String name);
}