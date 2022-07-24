package business;



import java.util.List;

import data.Contatto;
import data.NumeroTelefono;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.persistence.PersistenceContext;

@Stateless
@LocalBean
public class RubricaEJB implements RubricaEJBLocal {

	@PersistenceContext(unitName = "RubricaPU")
	EntityManager em;

	public RubricaEJB() {

	}

	public Contatto insertContatto(Contatto cont) {
		em.persist(cont);
		return cont;
	}

	public Contatto insertContatto(String nome, String cognome, String email, String numTelefono) {
		Contatto c = new Contatto(nome, cognome, email);
		return insertContatto(c);
	}

//	@Override
//	public void inserisciContatto(String nome, String cognome, String email, String numero) {
//		Contatto c = new Contatto(nome, cognome, email);
//		List <NumeroTelefono> numeri = new ArrayList <NumeroTelefono>();
//		numeri.add(new NumeroTelefono (numero,c));
//		c.setNumTelefoni(numeri);
//		em.persist(c);
//	}

	public List<Object[]> getAllContattiEnumeri() {
		Query q = em.createQuery(
				"SELECT distinct c.nome, c.cognome, c.email, n.numeroTelefono FROM Contatto c JOIN NumeroTelefono n ON "
						+ " c.contatto = n.contatto");
		List<Object[]> contatti = q.getResultList();
		return contatti;
	}

	public List<Contatto> getContattoByCognome(String cognome) {
		Query q = em.createNamedQuery("getContatto.byCognome");
		q.setParameter("cognome", "%" + cognome + "%");
		List<Contatto> contatti = q.getResultList();
		for (Contatto i : contatti) {
			System.out.println(i.getNome() + " " + i.getCognome());
		}
		return contatti;
	}

	public List<Contatto> getContattoByNumero(String numero) {
		Query q = em.createNamedQuery("getContatto.byNumero");
		q.setParameter("numero", "%" + numero + "%");
		List<Contatto> contatti = q.getResultList();
		for (Contatto i : contatti) {
			System.out.println(i.getNome() + " " + i.getCognome());
		}
		return contatti;
	}

	public void aggiornaContattoEsistente(int id, String numero1, String numero2, String nome, String cognome,
			String email) {
		Contatto c = em.find(Contatto.class, id);
		if (c == null) {
			c = new Contatto();
			c.setId(id);
		}
		c.setNome(nome);
		c.setCognome(cognome);
		c.setEmail(email);

		if (!numero1.isBlank()) {
			NumeroTelefono n1 = new NumeroTelefono();
			n1.setContatto(c);
			n1.setNumeroTelefono(numero1);
			c.getNumTelefoni().add(n1);
		}
		if (!numero2.isBlank()) {
			NumeroTelefono n2 = new NumeroTelefono();
			n2.setContatto(c);
			n2.setNumeroTelefono(numero2);
			c.getNumTelefoni().add(n2);
		}
		em.merge(c);
	}

	public void deleteContatto(Contatto c) {
		em.remove(em.find(Contatto.class, c.getId()));
	}

}
