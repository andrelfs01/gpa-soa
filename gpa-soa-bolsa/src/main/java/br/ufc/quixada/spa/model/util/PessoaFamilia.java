package br.ufc.quixada.spa.model.util;

import br.ufc.soa.Enums.GrauParentesco;


public class PessoaFamilia {

	private Integer id;
	
	private String nome;
	
	private int idade;

	private String escolaridade;
	
	private String atividadeProfissao;
	
	private double rendaMensal;
	
	private GrauParentesco grauParentesco;

	public PessoaFamilia(Integer id2) {
		this.id = id2;
	}

	public PessoaFamilia() {

	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getAtividadeProfissao() {
		return atividadeProfissao;
	}

	public void setAtividadeProfissao(String atividadeProfissao) {
		this.atividadeProfissao = atividadeProfissao;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome + ", idade=" + idade
				+ ", atividadeProfissao=" + atividadeProfissao
				+ ", rendaMensal=" + rendaMensal + ", grauParentesco="
				+ grauParentesco + "]";
	}
}
