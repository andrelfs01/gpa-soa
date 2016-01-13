package br.ufc.quixada.spa.control;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.npi.enumeration.ResponseStatus;
import br.ufc.quixada.npi.model.ResponseStatusMessage;
import br.ufc.quixada.spa.model.IdServidor;
import br.ufc.quixada.spa.model.SelecaoBolsa;
import br.ufc.quixada.spa.model.util.Aluno;
import br.ufc.quixada.spa.model.util.SelecaoBolsaComp;
import br.ufc.quixada.spa.model.util.Servidor;
import br.ufc.quixada.spa.service.AlunoRestService;
import br.ufc.quixada.spa.service.DocumentoRestService;
import br.ufc.quixada.spa.service.PessoaRestService;
import br.ufc.quixada.spa.service.SelecaoBolsaService;
import br.ufc.quixada.spa.service.ServidorRestService;

@Named
@RequestMapping("selecoes")
public class SelecaoBolsaController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Inject 
	private SelecaoBolsaService selecaoService;
	
	@Inject 
	private AlunoRestService alunoService;
	
	@Inject 
	private ServidorRestService servidorService;
	
	@Inject
	private DocumentoRestService documentoService;
	
	@Inject
	private PessoaRestService pessoaService;
		
//	@RequestMapping(value= "/teste" ,method = RequestMethod.GET)
//	public @ResponseBody Documento teste() {
//		log.debug("teste - GET (alunol)");
//		try {
//			IdDocumento id = new IdDocumento();
//			id.setIdDocumento((long) 1);
//			return documentoService.getDocumento(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<SelecaoBolsaComp> findAll() {
		log.debug("SelecaoBolsa - GET (all)");
		List<SelecaoBolsa> selecoes = selecaoService.find(SelecaoBolsa.class);
		
		List<SelecaoBolsaComp> selecoesCompletas = new ArrayList<>();
		
		for (SelecaoBolsa selecaoBolsa : selecoes) {
			//setar a selecao
			SelecaoBolsaComp selecaoCompleta = new SelecaoBolsaComp(selecaoBolsa);
			
			selecaoCompleta.setDocumentos(documentoService.getTodosDocumentos(selecaoBolsa.getDocumentos()));
			//setar pessoa
			selecaoCompleta.setPessoaAutor(pessoaService.getAutor(selecaoBolsa.getAutor()));
			//setar alunos
			selecaoCompleta.setAlunosSelecao(alunoService.getTodosAlunos(selecaoBolsa.getIdsAlunosSelecao()));
			//setar servidores
			selecaoCompleta.setMembrosBanca(servidorService.getServidores(selecaoBolsa.getMembrosBanca()));
			//SETAR SERVIDOR RESP
			selecaoCompleta.setServidorResponsavel(servidorService.getServidor(selecaoBolsa.getResponsavel()));
			selecoesCompletas.add(selecaoCompleta);
		}
		return selecoesCompletas;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody SelecaoBolsaComp findById(@PathVariable Integer id) {
		log.debug("SelecaoBolsa - GET (id)");
		SelecaoBolsa selecaoBolsa = selecaoService.find(SelecaoBolsa.class, id);
		//setar a selecao
		SelecaoBolsaComp selecaoCompleta = new SelecaoBolsaComp(selecaoBolsa);
		
		selecaoCompleta.setDocumentos(documentoService.getTodosDocumentos(selecaoBolsa.getDocumentos()));
		//setar pessoa
		selecaoCompleta.setPessoaAutor(pessoaService.getAutor(selecaoBolsa.getAutor()));
		//setar alunos
		selecaoCompleta.setAlunosSelecao(alunoService.getTodosAlunos(selecaoBolsa.getIdsAlunosSelecao()));
		//setar servidores
		selecaoCompleta.setMembrosBanca(servidorService.getServidores(selecaoBolsa.getMembrosBanca()));
		//SETAR SERVIDOR RESP
		selecaoCompleta.setServidorResponsavel(servidorService.getServidor(selecaoBolsa.getResponsavel()));
		
		return selecaoCompleta;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("selecaoService - DELETE");
		selecaoService.delete(new SelecaoBolsa(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "selecaoService removida com sucesso");
	}
		
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage novaSelecao(@RequestBody SelecaoBolsaComp selecaoCompleta) {
		log.debug("SelecaoBolsa - POST");
		//salva os documentos, os outros componentes ja devem existir		
		documentoService.salvarDocumentos(selecaoCompleta.getDocumentos());
		selecaoService.save(new SelecaoBolsa(selecaoCompleta));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "SelecaoBolsa inserida com sucesso");
	}
		
	//editar selecao bolsa
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(SelecaoBolsa selecao, @PathVariable Integer id) {
		log.debug("SelecaoBolsa - PUT");
		selecaoService.update(selecao);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "QuestionarioAuxilioMoradia atualizada com sucesso");
	}	
	
	//listar selecoes que o servidor é da banca
	@RequestMapping(value = "/participaBanca/{id}" ,method = RequestMethod.GET)
	public @ResponseBody List<SelecaoBolsaComp> findByServidorBanca(@PathVariable Integer id) {
		log.debug("SelecaoBolsa - GET (Participa banca)");
		List<SelecaoBolsa> selecoes = new ArrayList<>();
		List<IdServidor> participacoes = selecaoService.findByServidorBanca(id); 
		for (IdServidor idServidor : participacoes) {
			selecoes.add(idServidor.getSelecao());
		}				
		
		List<SelecaoBolsaComp> selecoesCompletas = new ArrayList<>();
		
		for (SelecaoBolsa selecaoBolsa : selecoes) {
			//setar a selecao
			SelecaoBolsaComp selecaoCompleta = new SelecaoBolsaComp(selecaoBolsa);
			
			selecaoCompleta.setDocumentos(documentoService.getTodosDocumentos(selecaoBolsa.getDocumentos()));
			//setar pessoa
			selecaoCompleta.setPessoaAutor(pessoaService.getAutor(selecaoBolsa.getAutor()));
			//setar alunos
			selecaoCompleta.setAlunosSelecao(alunoService.getTodosAlunos(selecaoBolsa.getIdsAlunosSelecao()));
			//setar servidores
			selecaoCompleta.setMembrosBanca(servidorService.getServidores(selecaoBolsa.getMembrosBanca()));
			//SETAR SERVIDOR RESP
			selecaoCompleta.setServidorResponsavel(servidorService.getServidor(selecaoBolsa.getResponsavel()));
			selecoesCompletas.add(selecaoCompleta);
		}
		return selecoesCompletas;
	}
	
	//listar inscritos da selecao
	@RequestMapping(value="{id}/participantes", method = RequestMethod.GET)
	public @ResponseBody List<Aluno> findParticipantesById(@PathVariable Integer id) {
		log.debug("SelecaoBolsa - GET PARTICIPANTES (id)");
		SelecaoBolsa selecaoBolsa = selecaoService.find(SelecaoBolsa.class, id);
		//setar a selecao
		return alunoService.getTodosAlunos(selecaoBolsa.getIdsAlunosSelecao());
	}
	
	//atruibuir tres servidores para serem pareceristas
	@RequestMapping(value="{id}/pareceristas", method = RequestMethod.POST)
	public @ResponseBody void atribuirBanca(@PathVariable Integer id, @RequestBody List<Servidor> banca) {
		log.debug("SelecaoBolsa - ATRIBUIR PARECERISTAS");
		SelecaoBolsa selecaoBolsa = selecaoService.find(SelecaoBolsa.class, id);
		//setar os IDs dos servidores que vierem na selecao
		
		if(banca.size() == 3){
			List<IdServidor> membrosBanca = new ArrayList<>();
			for (Servidor servidor : banca) {
				membrosBanca.add(new IdServidor(servidor.getId(), selecaoBolsa));
			}
			
			selecaoBolsa.setMembrosBanca(membrosBanca);
			selecaoService.save(selecaoBolsa);
		}
		
	}
	
}