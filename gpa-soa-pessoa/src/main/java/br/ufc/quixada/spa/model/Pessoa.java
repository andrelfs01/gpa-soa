package br.ufc.quixada.spa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.ufc.soa.Enums.Estado;


@Entity
public  class Pessoa {
	public Pessoa() {
		super();
	}
	
	public Pessoa(Integer id, String nome){
		this.id = id;
		this.nome = nome;
	}
	public Pessoa(Integer id2) {
		this.id = id2;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String login;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private boolean habilitado;

	@Column(nullable=false, unique = true)
	private String email;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private Date dataNascimento;
	@Column(nullable=false)
	private String nacionalidade;
	@Column(nullable=false)
	private String naturalidade;

	@Column(nullable=false)
	private Estado uf;
	@Column(nullable=false)
	private String sexo;
	@Column(nullable=false)
	private String cpf;
	@Column(nullable=false)
	private String rg;
	@Column(nullable=false)
	private String telefone;
	@Column(nullable=false)
	private String estadoCivil;
	

	public Estado getUf() {
		return uf;
	}
	
	public void setUf(Estado uf) {
		this.uf = uf;
	}
		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + "]";
	}
}
