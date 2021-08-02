package com.algaworks.curso.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class AtualizandoPrimeiroObjeto {
	
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
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("Idade: " + cliente.getIdade());
				System.out.println("Sexo: " + cliente.getSexo());
				System.out.println("Profissão: " + cliente.getProfissao());	
				System.out.println("\n");
				
				System.out.println("Digite o novo nome: ");
				Scanner sc_nome = new Scanner(System.in);
				String nome = sc_nome.nextLine();
				
				System.out.println("Digite a nova idade: ");
				Scanner sc_idade = new Scanner(System.in);
				Integer idade = sc_idade.nextInt();
				
				System.out.println("Digite o novo sexo <F/M>: ");
				Scanner sc_sexo = new Scanner(System.in);
				String sexo = sc_sexo.next();
				
				System.out.println("Digite a nova profissão: ");
				Scanner sc_profissao = new Scanner(System.in);
				String profissao = sc_profissao.nextLine();
				System.out.println("\n");
				
				cliente.setNome(nome);
				cliente.setIdade(idade);
				cliente.setSexo(sexo);
				cliente.setProfissao(profissao);
				
				em.getTransaction().begin();
				em.getTransaction().commit();
				
				System.out.println("Cliente de código " + codigo + " atualizado com sucesso!");				

			} else {
				System.out.println("Cliente de código " + codigo + " não cadastrado.");
			}
			
			System.out.println("\n");
			
			System.out.print("Atualizar outro cliente <S/N>? ");			
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
