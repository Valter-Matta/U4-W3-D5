package Catalogo.Entity.AttributiLibro;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Autore {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cognome;
	private int annoDiNascita;
	private String luogoDiNascita;

	public Autore () {
	}

	public Autore (String nome, String cognome, int annoDiNascita, String luogoDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoDiNascita = annoDiNascita;
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getNome () {
		return nome;
	}

	public void setNome (String nome) {
		this.nome = nome;
	}

	public String getCognome () {
		return cognome;
	}

	public void setCognome (String cognome) {
		this.cognome = cognome;
	}

	public int getAnnoDiNascita () {
		return annoDiNascita;
	}

	public void setAnnoDiNascita (int annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}

	public String getLuogoDiNascita () {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita (String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public Long getId () {
		return id;
	}
}
