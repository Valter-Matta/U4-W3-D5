package Catalogo.Entity.Prodotti;

import jakarta.persistence.*;

@Entity // Aggiungi questa annotazione
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Pubblicazioni {
	@Id
	private String ISBN;
	private String titolo;
	private int annoDiPubblicazione;
	private int numeroPagine;

	public Pubblicazioni () {
	}

	public Pubblicazioni (String ISBN, String titolo, int annoDiPubblicazione, int numeroPagine) {
		this.ISBN = ISBN;
		this.titolo = titolo;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getISBN () {
		return ISBN;
	}

	public void setISBN (String ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitolo () {
		return titolo;
	}

	public void setTitolo (String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoDiPubblicazione () {
		return annoDiPubblicazione;
	}

	public void setAnnoDiPubblicazione (int annoDiPubblicazione) {
		this.annoDiPubblicazione = annoDiPubblicazione;
	}

	public int getNumeroPagine () {
		return numeroPagine;
	}

	public void setNumeroPagine (int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString () {
		return "Titolo: " + titolo
			+ " Anno di Pubblicazione: " + annoDiPubblicazione
			+ " Numero Pagine: " + numeroPagine;
	}
}
