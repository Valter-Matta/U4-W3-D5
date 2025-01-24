package Catalogo.Entity;

import Catalogo.Entity.Prodotti.Pubblicazioni;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class Prestito {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn (name = "utente_numero_tessera")
	private Utente utente;

	@ManyToOne
	@JoinColumn (name = "Prodotto_id")
	private Pubblicazioni elementoPrestato;

	private LocalDate dataInizioPrestito;
	private LocalDate dataRestituzionePrevista;
	private LocalDate dataRestituzioneEffettiva;

	public Prestito (Utente utente, Pubblicazioni elementoPrestato, LocalDate dataInizioPrestito) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
		this.dataRestituzioneEffettiva = null;
	}

	public Utente getUtente () {
		return utente;
	}

	public void setUtente (Utente utente) {
		this.utente = utente;
	}

	public Pubblicazioni getElementoPrestato () {
		return elementoPrestato;
	}

	public void setElementoPrestato (Pubblicazioni elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public LocalDate getDataInizioPrestito () {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito (LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getDataRestituzionePrevista () {
		return dataRestituzionePrevista;
	}

	public void setDataRestituzionePrevista (LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}

	public LocalDate getDataRestituzioneEffettiva () {
		return dataRestituzioneEffettiva;
	}

	public void setDataRestituzioneEffettiva (LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
}
