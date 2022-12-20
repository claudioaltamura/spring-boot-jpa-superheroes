package de.claudioaltamura.springboot.jpa.superheroes.repository;

import de.claudioaltamura.springboot.jpa.superheroes.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityEntityRepository extends JpaRepository<CityEntity, Long> {
	List<CityEntity> findByName(String name);
}