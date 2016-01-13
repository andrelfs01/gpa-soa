package br.ufc.quixada.spa.model.util;

import java.util.Date;
import java.util.List;

import br.ufc.quixada.spa.model.QuestionarioAuxilioMoradia;
import br.ufc.quixada.spa.model.QuestionarioIniciacaoAcademica;
import br.ufc.quixada.spa.model.RelatorioVisitaDomiciliar;
import br.ufc.quixada.spa.model.SelecaoBolsa;
import br.ufc.soa.Enums.Status;
import br.ufc.soa.Enums.TipoBolsa;

public class SelecaoBolsaComp {
	private Integer id;
	
	private List<QuestionarioIniciacaoAcademica> questionariosIniciacaoAcademica;

	private List<QuestionarioAuxilioMoradia> questionariosAuxilioMoradia;
	
	private List<RelatorioVisitaDomiciliar> relatoriosVisitaDomiciliar;

	private Integer quantidadeVagas;

	private Date dataInicio;

	private Pessoa pessoaAutor;
	
	private List<Documento> documentos;

	private Integer sequencial;

	private Status status;

	private Date dataTermino;

	private Integer duracao;

	private String local;

	private Integer ano;

	private String comentarios;
	
	private List<Servidor> membrosBanca;

	private Servidor servidorResponsavel;

	private List<Aluno> alunosSelecao;

	private TipoBolsa tipoBolsa;

	public SelecaoBolsaComp(SelecaoBolsa selecaoBolsa) {
		this.ano = selecaoBolsa.getAno();
		this.comentarios =selecaoBolsa.getComentarios();
		this.dataInicio = selecaoBolsa.getDataInicio();
		this.dataTermino = selecaoBolsa.getDataTermino();
		this.duracao = selecaoBolsa.getDuracao();
		this.id = selecaoBolsa.getId();
		this.local = selecaoBolsa.getLocal();
		this.quantidadeVagas = selecaoBolsa.getQuantidadeVagas();
		this.sequencial = selecaoBolsa.getSequencial();
		this.status = selecaoBolsa.getStatus();
		this.tipoBolsa = selecaoBolsa.getTipoBolsa();
		this.questionariosAuxilioMoradia = selecaoBolsa.getQuestionariosAuxilioMoradia();
		this.questionariosIniciacaoAcademica = selecaoBolsa.getQuestionariosIniciacaoAcademica();
		this.relatoriosVisitaDomiciliar = selecaoBolsa.getRelatoriosVisitaDomiciliar();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<QuestionarioIniciacaoAcademica> getQuestionariosIniciacaoAcademica() {
		return questionariosIniciacaoAcademica;
	}

	public void setQuestionariosIniciacaoAcademica(List<QuestionarioIniciacaoAcademica> questionariosIniciacaoAcademica) {
		this.questionariosIniciacaoAcademica = questionariosIniciacaoAcademica;
	}

	public List<QuestionarioAuxilioMoradia> getQuestionariosAuxilioMoradia() {
		return questionariosAuxilioMoradia;
	}

	public void setQuestionariosAuxilioMoradia(List<QuestionarioAuxilioMoradia> questionariosAuxilioMoradia) {
		this.questionariosAuxilioMoradia = questionariosAuxilioMoradia;
	}

	public List<RelatorioVisitaDomiciliar> getRelatoriosVisitaDomiciliar() {
		return relatoriosVisitaDomiciliar;
	}

	public void setRelatoriosVisitaDomiciliar(List<RelatorioVisitaDomiciliar> relatoriosVisitaDomiciliar) {
		this.relatoriosVisitaDomiciliar = relatoriosVisitaDomiciliar;
	}

	public Integer getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Pessoa getPessoaAutor() {
		return pessoaAutor;
	}

	public void setPessoaAutor(Pessoa pessoaAutor) {
		this.pessoaAutor = pessoaAutor;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public List<Servidor> getMembrosBanca() {
		return membrosBanca;
	}

	public void setMembrosBanca(List<Servidor> membrosBanca) {
		this.membrosBanca = membrosBanca;
	}

	public Servidor getServidorResponsavel() {
		return servidorResponsavel;
	}

	public void setServidorResponsavel(Servidor servidorResponsavel) {
		this.servidorResponsavel = servidorResponsavel;
	}

	public List<Aluno> getAlunosSelecao() {
		return alunosSelecao;
	}

	public void setAlunosSelecao(List<Aluno> alunosSelecao) {
		this.alunosSelecao = alunosSelecao;
	}

	public TipoBolsa getTipoBolsa() {
		return tipoBolsa;
	}

	public void setTipoBolsa(TipoBolsa tipoBolsa) {
		this.tipoBolsa = tipoBolsa;
	}

}
