package Catalogo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Utente {
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	@Id
	private String numeroTessera;

	public Utente (String nome, String cognome, LocalDate dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.numeroTessera = UUID.randomUUID().toString();
	}

	public String getNome () {
		return nome;
	}

	public String getCognome () {
		return cognome;
	}

	public LocalDate getDataNascita () {
		return dataNascita;
	}

	public String getNumeroTessera () {
		return numeroTessera;
	}
}
