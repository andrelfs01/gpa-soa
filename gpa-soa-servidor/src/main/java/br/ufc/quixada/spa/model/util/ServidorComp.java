package br.ufc.quixada.spa.model.util;

import br.ufc.quixada.spa.model.Servidor;
import br.ufc.soa.Enums.Cargo;


public class ServidorComp {
	public ServidorComp() {
		super();
	}

	public ServidorComp(Integer id){
		this.id = id;
	}
	
	public ServidorComp(Servidor s) {
		this.id = s.getId();
		this.siape = s.getSiape();
		this.cargo = s.getCargo();
	}

	private Integer id;

	private String siape;

	private Cargo cargo;

	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
