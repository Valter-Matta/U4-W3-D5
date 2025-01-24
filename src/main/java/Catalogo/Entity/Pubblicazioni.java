package Catalogo.Entity;


public abstract class Pubblicazioni {
	private Long ISBN;
	private String titolo;
	private int annoDiPubblicazione;
	private int numeroPagine;

	protected Pubblicazioni (String titolo, int annoDiPubblicazione, int numeroPagine) {
		this.titolo = titolo;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public Long getISBN () {
		return ISBN;
	}

	public void setISBN (Long ISBN) {
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
