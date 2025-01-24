package Catalogo.DAO;

import Catalogo.Entity.AttributiLibro.Autore;
import Catalogo.Entity.Prestito;
import Catalogo.Entity.Prodotti.Libri;
import Catalogo.Entity.Prodotti.Pubblicazioni;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class ArchivioDAO {
	private EntityManager em;

	public ArchivioDAO (EntityManager e) {
		this.em = e;
	}

	public <T> void aggiungiElemento (T qualsiasi) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(qualsiasi);
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}
	public <T> void modificaElemento (T qualsiasi) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(qualsiasi);
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}

	public void rimuoviElemento (String ISBN) {
		Pubblicazioni pubblicazione = em.find(Pubblicazioni.class, ISBN);
		if (pubblicazione != null) {
			EntityTransaction transaction = em.getTransaction();
			try {
				transaction.begin();
				em.remove(pubblicazione);
				transaction.commit();
			} catch (RuntimeException e) {
				transaction.rollback();
				throw e;
			}
		}
	}

	public Pubblicazioni cercaPerISBN (String ISBN) {
		return em.find(Pubblicazioni.class, ISBN);
	}

	public List<Pubblicazioni> cercaPerAnnoDiPubblicazione (int anno) {
		String strQuery = "SELECT p FROM Pubblicazioni p WHERE p.annoDiPubblicazione = :anno";
		TypedQuery<Pubblicazioni> query = em.createQuery(strQuery, Pubblicazioni.class);
		query.setParameter("anno", anno);
		return query.getResultList();
	}

	public List<Libri> cercaPerAutore (Autore autore) {
		String strQuery = "SELECT l FROM Libri l WHERE l.autore = :autore";
		TypedQuery<Libri> query = em.createQuery(strQuery, Libri.class);
		query.setParameter("autore", autore);
		return query.getResultList();
	}

	public List<Pubblicazioni> cercaPerTitolo (String titolo) {
		String strQuery = "SELECT p FROM Pubblicazioni p WHERE p.titolo LIKE :titolo";
		TypedQuery<Pubblicazioni> query = em.createQuery(strQuery, Pubblicazioni.class);
		query.setParameter("titolo", "%" + titolo + "%");
		return query.getResultList();
	}

	public List<Prestito> cercaPrestitiPerUtente (String numeroTessera) {
		String queryStr = "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL";
		TypedQuery<Prestito> query = em.createQuery(queryStr, Prestito.class);
		query.setParameter("numeroTessera", numeroTessera);
		return query.getResultList();
	}

	public List<Prestito> cercaPrestitiScaduti () {
		String strQuery = "SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS null AND p.dataRestituzionePrevista < :oggi";
		TypedQuery<Prestito> query = em.createQuery(strQuery, Prestito.class);
		query.setParameter("oggi", LocalDate.now());
		return query.getResultList();
	}
}
