/* https://github.com/algaworks/curso-jpa-hibernate/blob/master/Aulas/Entendendo%20um%20pouco%20mais%20da%20transacao/banco-tabajara/src/com/algaworks/curso/main/Transferencia.java */

package com.algaworks.curso.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Conta;

public class Transferencia {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancoPU");
		EntityManager em = emf.createEntityManager();
		
		Scanner entrada = new Scanner(System.in);
		
		Conta conta1 = em.find(Conta.class, 1L);
		
		if (conta1 == null) {
			System.out.println("Digite o saldo inicial da conta 1: " );
			Double saldoInicialConta1 = entrada.nextDouble();			
			conta1 = new Conta();			
			conta1.setSaldo(saldoInicialConta1);			
		}
		
		Conta conta2 = em.find(Conta.class, 2L);
		
		if (conta2 == null) {
			System.out.println("Digite o saldo inicial da conta 2: " );
			Double saldoInicialConta2 = entrada.nextDouble();			
			conta2 = new Conta();			
			conta2.setSaldo(saldoInicialConta2);	
		}
		
		em.getTransaction().begin();
		em.persist(conta1);
		em.persist(conta2);
		em.getTransaction().commit();
		
		System.out.println("Saldo da conta1: " + conta1.getSaldo());
		System.out.println("Saldo da conta2: " + conta2.getSaldo());
		
		System.out.println("-----------------------------------------");
		
		System.out.println("Digite o valor a ser transferido da conta1 para a conta2? ");
		Double valorTransferencia = entrada.nextDouble();
		
		em.getTransaction().begin();
		conta1.setSaldo(conta1.getSaldo() - valorTransferencia);
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
		
		if (conta1.getSaldo() > 0) {
			em.getTransaction().commit();
			System.out.println("Transferência realizada com sucesso");
		} else {
			em.getTransaction().rollback();
			System.err.println("Transferência não realizada, saldo insuficiente!");			
		}		
	}
}
