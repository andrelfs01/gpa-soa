package br.ufc.quixada.spa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.ufc.soa.Enums.Banco;
import br.ufc.soa.Enums.Curso;


@Entity
public class Aluno {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable=false, unique=true)
	private String matricula;

	@Column(nullable=false)
	private Curso curso;

	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String anoIngresso;
	@Column(nullable=false)
	private double ira;
	@Column(nullable=false)
	private Banco banco;
	@Column(nullable=false)
	private String agencia;
	@Column(nullable=false)
	private String conta;
	
	@Column(nullable=false)
	private int idPessoa;
	
	@OneToMany(mappedBy="aluno", cascade=CascadeType.ALL)
	private List<PessoaFamilia> familiares;
	
	@Column
	private byte[] foto;

	public Aluno(Integer id) {
		this.id = id;
	}
	
	public Aluno(){}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
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

	@Override
	public String toString() {
		return "Aluno [id=" + id + "]";
	}
}
