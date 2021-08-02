package com.algaworks.curso.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class RemovendoPrimeiroObjeto {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		while (true) {
			System.out.print("Digite o código: ");
			Scanner sc_codigo = new Scanner(System.in);	
			Long codigo = sc_codigo.nextLong();	
					
			Cliente cliente = em.find(Cliente.class, codigo);
			
			if (cliente != null) {
				em.getTransaction().begin();
				em.remove(cliente);
				em.getTransaction().commit();
				System.out.println("Cliente de código " + codigo + " removido com sucesso.");

			} else {
				System.out.println("Cliente de código " + codigo + " não cadastrado.");
			}
			
			System.out.println("\n");
			
			System.out.print("Excluir outro cliente <S/N>? ");
			Scanner sc_opcao = new Scanner(System.in);
			String opcao = sc_opcao.next();			
			
			if (opcao.equalsIgnoreCase("s")) {
				continue;
			} else {
				break;
			}
		}
	}
}
