package br.ufc.quixada.spa.model.util;

import br.ufc.soa.Enums.Cargo;

public class Servidor {
	public Servidor() {
		super();
	}

	public Servidor(Integer id){
		this.id = id;
	}

	private Integer id;

	
	private String siape;
	
	private Cargo cargo;

	
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
