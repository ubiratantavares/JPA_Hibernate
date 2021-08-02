package com.agenda.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.agenda.modelo.Agenda;

public class DeleteAgenda {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	EntityManager em = emf.createEntityManager();
	
	public void excluir(Agenda agenda) {
		em.getTransaction().begin();
		em.remove(em.getReference(Agenda.class, agenda.getCodigo()));
		em.getTransaction().commit();

	}
}
