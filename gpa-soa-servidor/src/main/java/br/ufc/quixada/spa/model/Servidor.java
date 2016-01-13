package br.ufc.quixada.spa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.ufc.soa.Enums.Cargo;

@Entity
public class Servidor {
	public Servidor() {
		super();
	}

	public Servidor(Integer id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable=false)
	private String siape;

	@Column(nullable=false)
	private Cargo cargo;

	@Column(nullable=false)
	private int idPessoa;

	public int getPessoa() {
		return idPessoa;
	}

	public void setPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Servidor [id=" + id +"]";
	}
}	
