
package br.ufc.quixada.spa.model.util;

public class Documento {

	private Long id;
	
	private String nomeOriginal;
	
	private String nome;
	
	private String tipo;
	 
	private byte[] arquivo;

	public Documento(){
		super();
	}	
	
	public Documento(String nomeOriginal, String nome, String tipo, byte[] arquivo){
		super();
		this.nomeOriginal = nomeOriginal;
		this.nome = nome;
		this.tipo = tipo;
		this.arquivo = arquivo;
	}
	
	public Documento(Long id2) {
		this.id = id2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Documento) {
			Documento other = (Documento) obj;
			if (other != null && other.getId() != null && this.id != null && other.getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}
	
}