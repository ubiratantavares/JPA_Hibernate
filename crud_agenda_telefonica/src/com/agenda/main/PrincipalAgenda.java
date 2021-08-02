package com.agenda.main;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.agenda.modelo.Agenda;
import com.agenda.persistence.CreateAgenda;
import com.agenda.persistence.DeleteAgenda;
import com.agenda.persistence.ReadAgenda;
import com.agenda.persistence.UpdateAgenda;

public class PrincipalAgenda {
	
	@SuppressWarnings("resource")
	public static Integer menu() {
		Scanner sc = new Scanner(System.in);
		Integer opcao = 0;		
		do {
			System.out.println("1 - Cadastrar contato na agenda");
			System.out.println("2 - Consultar contato da agenda");
			System.out.println("3 - Atualizar contato da agenda");
			System.out.println("4 -   Excluir contato da agenda");
			System.out.println("5 - Fechar a agenda");
			System.out.print("Digite um número do menu: ");	
			opcao = sc.nextInt();	
			
			if ((opcao < 1) || (opcao > 5)) {
				System.out.println("Opção Inválida.\n");
			}
			
		} while ((opcao < 1) || (opcao > 5));
		return opcao;		
	}
	
	@SuppressWarnings("resource")
	public static Integer lerCodigo() {
		System.out.print("Digite o código: ");	
		Scanner sc_codigo = new Scanner(System.in);	
		Integer codigo = sc_codigo.nextInt();
		return codigo;
	}
	
	@SuppressWarnings("resource")
	public static Agenda ler() {
		System.out.println("Digite o nome: ");
		Scanner sc_nome = new Scanner(System.in);
		String nome = sc_nome.nextLine();
		
		System.out.println("Digite o telefone: ");
		Scanner sc_tel = new Scanner(System.in);
		String tel = sc_tel.nextLine();
		
		Calendar cal = Calendar.getInstance();
		
		Date data = cal.getTime();
		
		Agenda agenda = new Agenda(nome, tel, data);
		return agenda;	
	}		
	
	public static Agenda consultar(Integer codigo) {
		ReadAgenda ra = new ReadAgenda();	
		Agenda agenda = ra.consultar(codigo);		
		return agenda;
	}	
	
	public static void cadastrar() {
		try {
			Integer codigo = lerCodigo();
			Agenda agenda = consultar(codigo);
			if (agenda == null) {
				agenda = ler();	
				CreateAgenda ca = new CreateAgenda();		
				ca.salvar(agenda);	
				System.out.println("Dados do código " + codigo + " cadastrados na agenda.");							
			} else {
				System.out.println("Dados do código " + codigo + " já cadastrados na agenda.");
			}
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}	
	}
	
	public static void exibir() {
		try {
			Integer codigo = lerCodigo();	
			Agenda agenda = consultar(codigo);
			if (agenda != null) {
				System.out.println(agenda.toString());
			} else {
				System.out.println("Dados do código " + codigo + " não cadastrados na agenda.");
			}
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}	
	}
	
	public static void atualizar() {
		try {
			Integer codigo = lerCodigo();
			Agenda agenda = consultar(codigo);			
			if (agenda != null) {
				Agenda agendaNova = ler();
				agenda.setNome(agendaNova.getNome());
				agenda.setTelefone(agendaNova.getTelefone());
				agenda.setDataRegistro(agendaNova.getDataRegistro());				
				UpdateAgenda ua = new UpdateAgenda();
				ua.update(agenda);
				System.out.println("Dados do código " + codigo + " atualizados na agenda.");					
			} else {
				System.out.println("Dados do código " + codigo + " não cadastrados na agenda.");
			}
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}	
	}
	
	public static void excluir() {
		try {
			Integer codigo = lerCodigo();
			Agenda agenda = consultar(codigo);						
			if (agenda != null) {
				DeleteAgenda da = new DeleteAgenda();
				da.excluir(agenda);
				System.out.println("Dados do código " + codigo + " excluídos na agenda.");
			} else {
				System.out.println("Dados do código " + codigo + " não cadastrados na agenda.");
			}
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
	

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {		
		while (true) {			
			Integer opcao = menu();			
			switch (opcao) {
				case 1: {
					cadastrar();
					break;
				}				
				case 2: {
					exibir();
					break;
				}
				case 3: {
					atualizar();
					break;
				}
				case 4: {
					excluir();
					break;
				}
			}
				
			if (opcao == 5) {
				System.out.println("Encerrando a agenda.");
				break;
			}
			
			System.out.println("\n");
			
			System.out.print("Voltar ao menu inicial <S/N>? ");
			Scanner sc = new Scanner(System.in);
			String resp = sc.next();
			if (resp.equalsIgnoreCase("s")) {
				continue;
			} else {
				break;
			}	
		}		
	}
}
