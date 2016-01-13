package br.ufc.quixada.spa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Parecer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean selecionado;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private SelecaoBolsa selecao;
	
	@OneToOne
	private IdAluno idAlunoApto;
	
	@NotNull(message = "Campo obrigatório.")
	private String peso;
	
	public Parecer(Integer id2) {
		this.id = id2;
	}
	
	public Parecer() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Boolean selecionado) {
		this.selecionado = selecionado;
	}

	public SelecaoBolsa getSelecao() {
		return selecao;
	}

	public void setSelecao(SelecaoBolsa selecao) {
		this.selecao = selecao;
	}

	public IdAluno getAlunoApto() {
		return idAlunoApto;
	}

	public void setIdAlunoApto(IdAluno idAlunoApto) {
		this.idAlunoApto = idAlunoApto;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Parecer [id=" + id + "]";
	}
	
}
