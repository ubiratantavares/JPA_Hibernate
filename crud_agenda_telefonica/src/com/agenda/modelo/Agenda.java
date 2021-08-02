package com.agenda.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Agenda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;	
	private String telefone;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro;
	
	public Agenda() {

	}
	
	public Agenda(String nome, String telefone, Date dataRegistro) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataRegistro = dataRegistro;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@Override
	public String toString() {
		return "Agenda [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", dataRegistro="
				+ dataRegistro + "]";
	}		
}
