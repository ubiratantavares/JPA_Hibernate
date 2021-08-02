package com.agenda.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.agenda.modelo.Agenda;

public class CreateAgenda {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	EntityManager em = emf.createEntityManager();
	
	public void salvar(Agenda agenda) {
		em.getTransaction().begin();
		em.persist(agenda);
		em.getTransaction().commit();
	}	
}
