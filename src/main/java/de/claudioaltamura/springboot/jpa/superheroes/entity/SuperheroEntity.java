package de.claudioaltamura.springboot.jpa.superheroes.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "superheroes")
public class SuperheroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(name = "name")
	private String name;

	@Column(name = "real_name")
	private String realName;

	@DecimalMin(value="0.0")
	@DecimalMax(value="100.0")
	@Column(name = "power", nullable = false)
	private double power;


	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cities", referencedColumnName = "id",foreignKey = @ForeignKey(name="fk_cities_supeheroes"))
	private CityEntity city;

	public SuperheroEntity(String name, String realName, double power, CityEntity city) {
		this.name = name;
		this.realName = realName;
		this.power = power;
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SuperheroEntity superhero = (SuperheroEntity) o;
		return Objects.equals(id, superhero.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "SuperheroEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", realName='" + realName + '\'' +
				", power=" + power +
				", city=" + city +
				'}';
	}
}
