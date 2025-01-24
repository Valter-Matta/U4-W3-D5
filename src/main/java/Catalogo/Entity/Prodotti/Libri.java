package Catalogo.Entity.Prodotti;

import Catalogo.Entity.AttributiLibro.Autore;
import Catalogo.Entity.AttributiLibro.Genere;
import jakarta.persistence.*;

@Entity
public class Libri extends Pubblicazioni {

	@ManyToOne
	@JoinColumn (name = "autore_id")
	private Autore autore;

	@ManyToOne
	@JoinColumn (name = "genere_id")
	private Genere genere;

	public void setGenere (Genere genere) {
		this.genere = genere;
	}

	public Libri () {
	}

	public Libri (String ISBN, String titolo, int annoDiPubblicazione, int numeroPagine, Autore autore, Genere genere) {
		super(ISBN, titolo, annoDiPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public Autore getAutore () {
		return autore;
	}

	public Genere getGenere () {
		return genere;
	}


}
