package br.ufc.quixada.spa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufc.soa.Enums.Estado;
import br.ufc.soa.Enums.GrauParentesco;
import br.ufc.soa.Enums.NivelInstrucao;
import br.ufc.soa.Enums.SituacaoResidencia;

@Entity
//@NamedQueries({ @NamedQuery(name = "IniAcad.findIniAcadById", query = "SELECT ia FROM QuestionarioIniciacaoAcademica ia WHERE ia.aluno.id = :idAluno") })
public class QuestionarioIniciacaoAcademica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private SelecaoBolsa selecaoBolsa;

	@ManyToOne(cascade = CascadeType.MERGE)
	private IdAluno idAluno;

	public IdAluno getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(IdAluno idAluno) {
		this.idAluno = idAluno;
	}

	@NotNull(message = "Campo obrigatorio")
	private Integer qtdAparelhoSom;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdTelevisao;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdRadio;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdAutomovel;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdMotocicleta;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdMaquinaLavar;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdDvdVideocassete;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdGeladeira;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdFreezer;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdTelefoneFixo;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdCelularResidentes;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdComputador;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdFogaoGas;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdMaquinaCostura;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdComodosSemBanheiro;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdBanheiros;
	@NotNull(message = "Campo obrigatorio")
	private Integer qtdEmpregadosDomesticos;
	@NotNull(message = "Campo obrigatorio")
	private Integer totalMembrosFamilia;


	
	//como mapear
	@OneToMany(mappedBy="questionario",cascade = CascadeType.ALL)
	private List<IdPessoaFamiliaIA> pessoas;

	@Column(nullable = false)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionarioiniciacaoacademica_id")
	private List<HorarioDisponivel> horariosDisponiveisBolsa;

	@NotNull
	@Size(min = 5, message = "Campo Obrigatório")
	private String enderecoAtual;

	@NotNull(message = "Campo Obrigatório")
	private Integer numero;

	private String complemento;

	@NotNull
	@Size(min = 1, message = "Campo Obrigatório")
	private String bairro;

	private String uf;

	private String cep;

	@NotNull
	@Size(min = 3, message = "Campo Obrigatório")
	private String cidade;

	private String pontoReferencia;

	private String telefoneFixo;

	private String telefoneCelular;

	private String email;

	@NotNull
	@Size(min = 1, message = "Campo Obrigatório")
	private String enderecoFamilia;

	@NotNull(message = "Campo Obrigatório")
	private Integer numeroFamilia;

	@NotNull
	@Size(min = 1, message = "Campo Obrigatório")
	private String bairroFamilia;

	private String ufFamilia;

	private String complementoFamilia;

	private String cepFamilia;

	@NotNull
	@Size(min = 3, message = "Campo Obrigatório")
	private String cidadeFamilia;

	private String pontoReferenciaFamilia;

	private int anosEstudoPrivado;

	@Enumerated(EnumType.STRING)
	private NivelInstrucao nivelInstrucaoMae;

	@Enumerated(EnumType.STRING)
	private NivelInstrucao nivelInstrucaoPai;

	@NotNull
	@Size(min = 1, message = "Campo Obrigatório")
	private String resideAtualmente;

	@NotNull
	@Size(min = 1, message = "Campo Obrigatório")
	private String definicaoLocalAtual;

	@Enumerated(EnumType.STRING)
	private Estado estado;

	@Enumerated(EnumType.STRING)
	private Estado estadoFamilia;

	@Enumerated(EnumType.STRING)
	private SituacaoResidencia situacaoResidencia;

	private String campusPreferido;

	private Date dataInscricao;

	@Enumerated(EnumType.STRING)
	private GrauParentesco parentesco;

	@NotNull
	@Size(min = 1, message = "Campo Obrigatório")
	private String justificativaPedido;

	private String telefoneFixoFamilia;

	private String telefoneCelularFamilia;

	public QuestionarioIniciacaoAcademica() {

	}

	public QuestionarioIniciacaoAcademica(Integer id2) {
		this.id = id2;
	}

	public Integer getQtdAparelhoSom() {
		return qtdAparelhoSom;
	}

	public void setQtdAparelhoSom(Integer qtdAparelhoSom) {
		this.qtdAparelhoSom = qtdAparelhoSom;
	}

	public Integer getQtdTelevisao() {
		return qtdTelevisao;
	}

	public void setQtdTelevisao(Integer qtdTelevisao) {
		this.qtdTelevisao = qtdTelevisao;
	}

	public Integer getQtdRadio() {
		return qtdRadio;
	}

	public void setQtdRadio(Integer qtdRadio) {
		this.qtdRadio = qtdRadio;
	}

	public Integer getQtdAutomovel() {
		return qtdAutomovel;
	}

	public void setQtdAutomovel(Integer qtdAutomovel) {
		this.qtdAutomovel = qtdAutomovel;
	}

	public Integer getQtdMotocicleta() {
		return qtdMotocicleta;
	}

	public void setQtdMotocicleta(Integer qtdMotocicleta) {
		this.qtdMotocicleta = qtdMotocicleta;
	}

	public Integer getQtdMaquinaLavar() {
		return qtdMaquinaLavar;
	}

	public void setQtdMaquinaLavar(Integer qtdMaquinaLavar) {
		this.qtdMaquinaLavar = qtdMaquinaLavar;
	}

	public Integer getQtdDvdVideocassete() {
		return qtdDvdVideocassete;
	}

	public void setQtdDvdVideocassete(Integer qtdDvdVideocassete) {
		this.qtdDvdVideocassete = qtdDvdVideocassete;
	}

	public Integer getQtdGeladeira() {
		return qtdGeladeira;
	}

	public void setQtdGeladeira(Integer qtdGeladeira) {
		this.qtdGeladeira = qtdGeladeira;
	}

	public Integer getQtdFreezer() {
		return qtdFreezer;
	}

	public void setQtdFreezer(Integer qtdFreezer) {
		this.qtdFreezer = qtdFreezer;
	}

	public Integer getQtdTelefoneFixo() {
		return qtdTelefoneFixo;
	}

	public void setQtdTelefoneFixo(Integer qtdTelefoneFixo) {
		this.qtdTelefoneFixo = qtdTelefoneFixo;
	}

	public Integer getQtdCelularResidentes() {
		return qtdCelularResidentes;
	}

	public void setQtdCelularResidentes(Integer qtdCelularResidentes) {
		this.qtdCelularResidentes = qtdCelularResidentes;
	}

	public Integer getQtdComputador() {
		return qtdComputador;
	}

	public void setQtdComputador(Integer qtdComputador) {
		this.qtdComputador = qtdComputador;
	}

	public Integer getQtdFogaoGas() {
		return qtdFogaoGas;
	}

	public void setQtdFogaoGas(Integer qtdFogaoGas) {
		this.qtdFogaoGas = qtdFogaoGas;
	}

	public Integer getQtdMaquinaCostura() {
		return qtdMaquinaCostura;
	}

	public void setQtdMaquinaCostura(Integer qtdMaquinaCostura) {
		this.qtdMaquinaCostura = qtdMaquinaCostura;
	}

	public Integer getQtdComodosSemBanheiro() {
		return qtdComodosSemBanheiro;
	}

	public void setQtdComodosSemBanheiro(Integer qtdComodosSemBanheiro) {
		this.qtdComodosSemBanheiro = qtdComodosSemBanheiro;
	}

	public Integer getQtdBanheiros() {
		return qtdBanheiros;
	}

	public void setQtdBanheiros(Integer qtdBanheiros) {
		this.qtdBanheiros = qtdBanheiros;
	}

	public Integer getQtdEmpregadosDomesticos() {
		return qtdEmpregadosDomesticos;
	}

	public void setQtdEmpregadosDomesticos(Integer qtdEmpregadosDomesticos) {
		this.qtdEmpregadosDomesticos = qtdEmpregadosDomesticos;
	}

	public Integer getTotalMembrosFamilia() {
		return totalMembrosFamilia;
	}

	public void setTotalMembrosFamilia(Integer totalMembrosFamilia) {
		this.totalMembrosFamilia = totalMembrosFamilia;
	}

	public String getCampusPreferido() {
		return campusPreferido;
	}

	public void setCampusPreferido(String campusPreferido) {
		this.campusPreferido = campusPreferido;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SelecaoBolsa getSelecaoBolsa() {
		return selecaoBolsa;
	}

	public void setSelecaoBolsa(SelecaoBolsa selecaoBolsa) {
		this.selecaoBolsa = selecaoBolsa;
	}

	public List<IdPessoaFamiliaIA> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<IdPessoaFamiliaIA> pessoas) {
		this.pessoas = pessoas;
	}

	public String getEnderecoAtual() {
		return enderecoAtual;
	}

	public void setEnderecoAtual(String enderecoAtual) {
		this.enderecoAtual = enderecoAtual;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnderecoFamilia() {
		return enderecoFamilia;
	}

	public void setEnderecoFamilia(String enderecoFamilia) {
		this.enderecoFamilia = enderecoFamilia;
	}

	public Integer getNumeroFamilia() {
		return numeroFamilia;
	}

	public void setNumeroFamilia(Integer numeroFamilia) {
		this.numeroFamilia = numeroFamilia;
	}

	public String getBairroFamilia() {
		return bairroFamilia;
	}

	public void setBairroFamilia(String bairroFamilia) {
		this.bairroFamilia = bairroFamilia;
	}

	public String getUfFamilia() {
		return ufFamilia;
	}

	public void setUfFamilia(String ufFamilia) {
		this.ufFamilia = ufFamilia;
	}

	public String getComplementoFamilia() {
		return complementoFamilia;
	}

	public void setComplementoFamilia(String complementoFamilia) {
		this.complementoFamilia = complementoFamilia;
	}

	public String getCepFamilia() {
		return cepFamilia;
	}

	public void setCepFamilia(String cepFamilia) {
		this.cepFamilia = cepFamilia;
	}

	public String getCidadeFamilia() {
		return cidadeFamilia;
	}

	public void setCidadeFamilia(String cidadeFamilia) {
		this.cidadeFamilia = cidadeFamilia;
	}

	public String getPontoReferenciaFamilia() {
		return pontoReferenciaFamilia;
	}

	public void setPontoReferenciaFamilia(String pontoReferenciaFamilia) {
		this.pontoReferenciaFamilia = pontoReferenciaFamilia;
	}

	public int getAnosEstudoPrivado() {
		return anosEstudoPrivado;
	}

	public void setAnosEstudoPrivado(int anosEstudoPrivado) {
		this.anosEstudoPrivado = anosEstudoPrivado;
	}

	public NivelInstrucao getNivelInstrucaoMae() {
		return nivelInstrucaoMae;
	}

	public void setNivelInstrucaoMae(NivelInstrucao nivelInstrucaoMae) {
		this.nivelInstrucaoMae = nivelInstrucaoMae;
	}

	public NivelInstrucao getNivelInstrucaoPai() {
		return nivelInstrucaoPai;
	}

	public void setNivelInstrucaoPai(NivelInstrucao nivelInstrucaoPai) {
		this.nivelInstrucaoPai = nivelInstrucaoPai;
	}

	public String getResideAtualmente() {
		return resideAtualmente;
	}

	public void setResideAtualmente(String resideAtualmente) {
		this.resideAtualmente = resideAtualmente;
	}

	public String getDefinicaoLocalAtual() {
		return definicaoLocalAtual;
	}

	public void setDefinicaoLocalAtual(String definicaoLocalAtual) {
		this.definicaoLocalAtual = definicaoLocalAtual;
	}

	public SituacaoResidencia getSituacaoResidencia() {
		return situacaoResidencia;
	}

	public void setSituacaoResidencia(SituacaoResidencia situacaoResidencia) {
		this.situacaoResidencia = situacaoResidencia;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstadoFamilia() {
		return estadoFamilia;
	}

	public void setEstadoFamilia(Estado estadoFamilia) {
		this.estadoFamilia = estadoFamilia;
	}

	public GrauParentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(GrauParentesco parentesco) {
		this.parentesco = parentesco;
	}

	public List<HorarioDisponivel> getHorariosDisponiveisBolsa() {
		return horariosDisponiveisBolsa;
	}

	public void setHorariosDisponiveisBolsa(
			List<HorarioDisponivel> horariosDisponiveisBolsa) {
		this.horariosDisponiveisBolsa = horariosDisponiveisBolsa;
	}

	public String getJustificativaPedido() {
		return justificativaPedido;
	}

	public void setJustificativaPedido(String justificativaPedido) {
		this.justificativaPedido = justificativaPedido;
	}

	public String getTelefoneFixoFamilia() {
		return telefoneFixoFamilia;
	}

	public void setTelefoneFixoFamilia(String telefoneFixoFamilia) {
		this.telefoneFixoFamilia = telefoneFixoFamilia;
	}

	public String getTelefoneCelularFamilia() {
		return telefoneCelularFamilia;
	}

	public void setTelefoneCelularFamilia(String telefoneCelularFamilia) {
		this.telefoneCelularFamilia = telefoneCelularFamilia;
	}

	public String toString() {
		return "QuestionarioIniciacaoAcademica [id=" + id + "]";
	}

}
