package Catalogo.Entity.Prodotti;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Riviste extends Pubblicazioni {
	@Enumerated (EnumType.STRING)
	private Periodicita periodicita;

	public Riviste () {

	}

	public Riviste (String ISBN, String titolo, int annoDiPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(ISBN, titolo, annoDiPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public enum Periodicita {
		SETTIMANALE, MENSILE, SEMESTRALE
	}
}
