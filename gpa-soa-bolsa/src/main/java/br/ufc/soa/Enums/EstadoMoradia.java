package br.ufc.soa.Enums;


public enum EstadoMoradia {
	CONCLUIDO("Concluído"), EM_CONST("Em construção"), DETERIORADO("Deteriorado");
	
	private String nome;
	
	private EstadoMoradia(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}
}
