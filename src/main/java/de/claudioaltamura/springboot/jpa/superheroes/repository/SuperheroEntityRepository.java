package de.claudioaltamura.springboot.jpa.superheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.claudioaltamura.springboot.jpa.superheroes.entity.SuperheroEntity;

public interface SuperheroEntityRepository extends JpaRepository<SuperheroEntity, Long> {
	List<SuperheroEntity> findByName(String name);
}