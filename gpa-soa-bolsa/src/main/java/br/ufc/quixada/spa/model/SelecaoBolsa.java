package br.ufc.quixada.spa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import br.ufc.quixada.spa.model.util.SelecaoBolsaComp;
import br.ufc.soa.Enums.Status;
import br.ufc.soa.Enums.TipoBolsa;

@Entity
public class SelecaoBolsa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy = "selecaoBolsa")
	private List<QuestionarioIniciacaoAcademica> questionariosIniciacaoAcademica;

	@OneToMany(mappedBy = "selecaoBolsa")
	private List<QuestionarioAuxilioMoradia> questionariosAuxilioMoradia;
	
	@OneToMany(mappedBy = "selecaoBolsa")
	private List<RelatorioVisitaDomiciliar> relatoriosVisitaDomiciliar;

	@NotNull(message = "Campo obrigatorio")
	@Range(min=1, max=999, message="O número de vagas deve ser maior ou igual a 1")
	private Integer quantidadeVagas;

	@Future(message = "Data de inicio deve ser maior que a data atual")
	@NotNull(message = "Campo obrigatorio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;

	@Column
	private Integer idPessoaAutor;
	
	@OneToMany(mappedBy = "selecao")
	private List<IdDocumento> documentos;

	@NotNull(message="Campo obrigatorio")
	@Range(min=1, message="O valor do edital deve ser maior que 0")
	private Integer sequencial;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Future(message = "Data de termino deve ser maior que a data atual")
	@NotNull(message = "Campo obrigatorio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataTermino;

	@NotNull(message = "Campo obrigatorio")
	@Range(min=1, max=999, message="A duracao da selecao deve ser maior ou igual a 1 mes")
	private Integer duracao;

	private String local;

	@NotNull(message = "Campo obrigatorio")
	private Integer ano;

	@Size(min = 2, message = "Minimo 2 caracteres")
	private String comentarios;
	
	//como mapear mny to many
	@OneToMany(mappedBy = "selecao")
	private List<IdServidor> membrosBanca;

	@OneToOne
	private IdServidor idServidorResponsavel;

	//como mapear mny to many
	@OneToMany(mappedBy = "selecao")
	private List<IdAluno> idsAlunosSelecao;

	@NotNull(message="Selecione o tipo de bolsa")
	@Enumerated(EnumType.STRING)
	private TipoBolsa tipoBolsa;

	public SelecaoBolsa(Integer id) {
		this.id = id;
	}
	
	public SelecaoBolsa(){}

	public SelecaoBolsa(SelecaoBolsaComp selecaoCompleta) {
		//pegar id das complexas 
		
		//alunosSelecao
		//membrosBanca
		//documentos
		//servidorResponsavel
		//pessoaAutor
		
		this.ano = selecaoCompleta.getAno();
		this.comentarios =selecaoCompleta.getComentarios();
		this.dataInicio = selecaoCompleta.getDataInicio();
		this.dataTermino = selecaoCompleta.getDataTermino();
		this.duracao = selecaoCompleta.getDuracao();
		this.id = selecaoCompleta.getId();
		this.local = selecaoCompleta.getLocal();
		this.quantidadeVagas = selecaoCompleta.getQuantidadeVagas();
		this.sequencial = selecaoCompleta.getSequencial();
		this.status = selecaoCompleta.getStatus();
		this.tipoBolsa = selecaoCompleta.getTipoBolsa();
		this.questionariosAuxilioMoradia = selecaoCompleta.getQuestionariosAuxilioMoradia();
		this.questionariosIniciacaoAcademica = selecaoCompleta.getQuestionariosIniciacaoAcademica();
		this.relatoriosVisitaDomiciliar = selecaoCompleta.getRelatoriosVisitaDomiciliar();

	}

	public List<IdAluno> getIdsAlunosSelecao() {
		return idsAlunosSelecao;
	}

	public Integer getAno() {
		return ano;
	}

	public int getAutor() {
		return idPessoaAutor;
	}

	public String getComentarios() {
		return comentarios;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public List<IdDocumento> getDocumentos() {
		return documentos;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public Integer getId() {
		return id;
	}

	public String getLocal() {
		return local;
	}

	public List<IdServidor> getMembrosBanca() {
		return membrosBanca;
	}

	public Integer getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public IdServidor getResponsavel() {
		return idServidorResponsavel;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public Status getStatus() {
		if (status == null) {
			if (dataTermino.getTime() <= System.currentTimeMillis()) {
				return Status.PROC_SELETIVO;
			} else if (dataInicio.getTime() <= System.currentTimeMillis()) {
				return Status.INSC_ABERTA;
			}else {
				return Status.NOVA;
			} 
			
		}
		return status;
	}
	public TipoBolsa getTipoBolsa() {
		return tipoBolsa;
	}

	
	public void setIdsAlunosSelecao(List<IdAluno> idsAlunosSelecao) {
		this.idsAlunosSelecao = idsAlunosSelecao;
	}

	public void addAlunosSelecao(IdAluno... a) {
		for (int i = 0; i < a.length; i++) {
			this.idsAlunosSelecao.add(a[i]);
		}
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setAutor(Integer idPessoaAutor) {
		this.idPessoaAutor = idPessoaAutor;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void setDataInicio(Date datadeInicio) {
		this.dataInicio = datadeInicio;
	}

	public void setDataTermino(Date datadeTermino) {
		this.dataTermino = datadeTermino;
	}

	public void setDocumentos(List<IdDocumento> documentos) {
		this.documentos = documentos;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}

	public void setMembrosBanca(List<IdServidor> membrosBanca) {
		this.membrosBanca = membrosBanca;
	}

	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public void setResponsavel(IdServidor idServidorResponsavel) {
		this.idServidorResponsavel = idServidorResponsavel;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setTipoBolsa(TipoBolsa tipoBolsa) {
		this.tipoBolsa = tipoBolsa;
	}
	
	

	public List<QuestionarioIniciacaoAcademica> getQuestionariosIniciacaoAcademica() {
		return questionariosIniciacaoAcademica;
	}

	public void setQuestionariosIniciacaoAcademica(
			List<QuestionarioIniciacaoAcademica> questionariosIniciacaoAcademica) {
		this.questionariosIniciacaoAcademica = questionariosIniciacaoAcademica;
	}

	public List<QuestionarioAuxilioMoradia> getQuestionariosAuxilioMoradia() {
		return questionariosAuxilioMoradia;
	}

	public void setQuestionariosAuxilioMoradia(
			List<QuestionarioAuxilioMoradia> questionariosAuxilioMoradia) {
		this.questionariosAuxilioMoradia = questionariosAuxilioMoradia;
	}

	public List<RelatorioVisitaDomiciliar> getRelatoriosVisitaDomiciliar() {
		return relatoriosVisitaDomiciliar;
	}

	public void setRelatoriosVisitaDomiciliar(
			List<RelatorioVisitaDomiciliar> relatoriosVisitaDomiciliar) {
		this.relatoriosVisitaDomiciliar = relatoriosVisitaDomiciliar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelecaoBolsa other = (SelecaoBolsa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
