package com.agenda.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.agenda.modelo.Agenda;

public class ReadAgenda {	
	
	public Agenda consultar(Integer codigo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		Agenda agenda = em.find(Agenda.class, codigo);
		return agenda;
	}
}
