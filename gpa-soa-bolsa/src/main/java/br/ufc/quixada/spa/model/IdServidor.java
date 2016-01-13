package br.ufc.quixada.spa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class IdServidor {
	//classe intermediaria do many to many
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private SelecaoBolsa selecao;
	
	@Column(nullable = false)
	private int idServidor;

	public IdServidor(){
		
	}
	
	public IdServidor(Integer id, SelecaoBolsa selecaoBolsa) {
		this.idServidor = id;
		this.selecao = selecaoBolsa;
	}

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

	public int getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}

}
