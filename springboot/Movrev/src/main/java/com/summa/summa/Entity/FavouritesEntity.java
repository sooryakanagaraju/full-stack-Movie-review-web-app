package com.summa.summa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fav")
public class FavouritesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long favId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable = false)
	private String image;
		
	@Column
	private String genre;
	
	@Column
	private String director;
	
	@Column
	private Long released;
}
