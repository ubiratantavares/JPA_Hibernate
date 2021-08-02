package com.algaworks.curso.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultandoPrimeiroObjeto {
	
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
				System.out.println("Cliente de código " + codigo + " cadastrado.");				
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("Idade: " + cliente.getIdade());
				System.out.println("Sexo: " + cliente.getSexo());
				System.out.println("Profissão: " + cliente.getProfissao());	
				System.out.println("Cliente de código " + codigo + " consultado com sucesso.");	

			} else {
				System.out.println("Cliente de código " + codigo + " não cadastrado.");
			}
			
			System.out.println("\n");
			
			System.out.print("Consultar outro cliente <S/N>? ");
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
