package Catalogo.Entity.AttributiLibro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genere {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	private String genere;

	public Genere () {
	}

	public Genere (String genere) {
		this.genere = genere;
	}

	public Long getId () {
		return id;
	}


	public String getGenere () {
		return genere;
	}
}
