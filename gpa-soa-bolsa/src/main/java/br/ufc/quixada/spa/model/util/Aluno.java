package br.ufc.quixada.spa.model.util;

import java.util.List;

import br.ufc.soa.Enums.Banco;
import br.ufc.soa.Enums.Curso;

public class Aluno {
	
	private Integer id;

	private String matricula;
	
	private Curso curso;
	
	private String nome;
	
	private String anoIngresso;
	
	private double ira;
	
	private Banco banco;
	
	private String agencia;

	private String conta;

	private int idPessoa;

	private byte[] foto;

	private List<PessoaFamilia> familiares;

	public Aluno(Integer id) {
		this.id = id;
	}
	
	public Aluno(){}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(String anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
	
	public double getIra() {
		return ira;
	}

	public void setIra(Double ira) {
		this.ira = ira;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public List<PessoaFamilia> getFamiliares() {
		return familiares;
	}

	public void setFamiliares(List<PessoaFamilia> familiares) {
		this.familiares = familiares;
	}

	public String toString() {
		return "Aluno [id=" + id + "]";
	}
}
