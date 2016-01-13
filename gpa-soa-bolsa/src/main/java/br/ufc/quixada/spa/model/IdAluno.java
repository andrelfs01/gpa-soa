package br.ufc.quixada.spa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class IdAluno {
	//classe intermediaria do many to many

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private SelecaoBolsa selecao;
	
	@Column(nullable = false)
	private int idAluno;
	
	public IdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	
	public IdAluno(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SelecaoBolsa getSelecao() {
		return selecao;
	}

	public void setSelecao(SelecaoBolsa selecao) {
		this.selecao = selecao;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
}
