package com.agenda.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.agenda.modelo.Agenda;

public class UpdateAgenda {


	
	public void update(Agenda agenda) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();	
		em.getTransaction().begin();
		em.merge(agenda);
		em.getTransaction().commit();
	}	
	
}
