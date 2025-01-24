import Catalogo.DAO.ArchivioDAO;
import Catalogo.Entity.AttributiLibro.Autore;
import Catalogo.Entity.Prestito;
import Catalogo.Entity.Prodotti.Libri;
import Catalogo.Entity.Prodotti.Pubblicazioni;
import Catalogo.Entity.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
	public static void main (String[] args) {
		// Creazione dell'EntityManager e del DAO
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArchivioPU");
		EntityManager em = emf.createEntityManager();
		ArchivioDAO archivioDAO = new ArchivioDAO(em);

		try {
			// Creazione e aggiunta di autori
			Autore autore1 = new Autore("Giovanni", "Pirandello", 1840, "Catania");
			Autore autore2 = new Autore("Italo", "Calvino", 1923, "Santiago de Las Vegas");

			archivioDAO.aggiungiElemento(autore1);
			archivioDAO.aggiungiElemento(autore2);
			System.out.println("Autori aggiunti.");

			// Creazione e aggiunta di libri
			Libri libro1 = new Libri("9781234567101", "I Malavoglia", 1881, 300, autore1, null);
			Libri libro2 = new Libri("9782345678101", "Le città invisibili", 1972, 250, autore2, null);

			archivioDAO.aggiungiElemento(libro1);
			archivioDAO.aggiungiElemento(libro2);
			System.out.println("Libri aggiunti.");

			// Creazione e aggiunta di un utente
			Utente utente1 = new Utente("Marco", "Rossi", LocalDate.of(1990, 5, 15));
			archivioDAO.aggiungiElemento(utente1);
			System.out.println("Utente aggiunto.");

			// Creazione e aggiunta di un prestito
			Prestito prestito1 = new Prestito(utente1, libro1, LocalDate.now());
			archivioDAO.aggiungiElemento(prestito1);
			System.out.println("Prestito aggiunto.");

			// Ricerca per ISBN
			System.out.println("Ricerca per ISBN (9781234567897):");
			Pubblicazioni libroTrovato = archivioDAO.cercaPerISBN("9781234567897");
			System.out.println(libroTrovato);

			// Ricerca per anno di pubblicazione
			System.out.println("\nRicerca per anno di pubblicazione (1972):");
			archivioDAO.cercaPerAnnoDiPubblicazione(1972).forEach(System.out::println);

			// Ricerca per autore
			System.out.println("\nRicerca per autore (Giovanni Verga):");
			archivioDAO.cercaPerAutore(autore1).forEach(System.out::println);

			// Ricerca per titolo
			System.out.println("\nRicerca per titolo (Le città invisibili):");
			archivioDAO.cercaPerTitolo("città").forEach(System.out::println);

			// Ricerca dei prestiti per utente
			System.out.println("\nPrestiti attuali per utente (Marco Rossi):");
			archivioDAO.cercaPrestitiPerUtente(utente1.getNumeroTessera()).forEach(prestito -> {
				System.out.println("Prestito: " + prestito.getElementoPrestato().getTitolo());
			});

			// Ricerca dei prestiti scaduti
			System.out.println("\nPrestiti scaduti e non restituiti:");
			archivioDAO.cercaPrestitiScaduti().forEach(prestito -> {
				System.out.println("Prestito scaduto: " + prestito.getElementoPrestato().getTitolo());
			});

		} catch (Exception e) {
			System.err.println("Errore: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Chiusura delle risorse
			em.close();
			emf.close();
			System.out.println("EntityManager chiuso.");
		}
	}
}
