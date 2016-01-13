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
import br.ufc.quixada.spa.model.Aluno;
import br.ufc.quixada.spa.model.util.AlunoComp;
import br.ufc.quixada.spa.model.util.Pessoa;
import br.ufc.quixada.spa.service.AlunoService;
import br.ufc.quixada.spa.service.PessoaRestService;

@Named
@RequestMapping("/alunos")
public class AlunoController {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private PessoaRestService pessoaService;
	@Inject
	private AlunoService alunoService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<AlunoComp> findAll() {
		log.debug("Aluno - GET (all)");
		List<Aluno> alunos = alunoService.find(Aluno.class);
		List<AlunoComp> alunosComp = new ArrayList<>();
		for (Aluno aluno : alunos) {
			AlunoComp completo = new AlunoComp(aluno);
			Pessoa pessoa = pessoaService.getPessoa(aluno.getIdPessoa());
			completo.setPessoa(pessoa);
			alunosComp.add(completo);
		}
		return alunosComp;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody AlunoComp findById(@PathVariable Integer id) {
		log.debug("Aluno - GET (id)");
		Aluno aluno = alunoService.find(Aluno.class, id);
		AlunoComp completo = new AlunoComp(aluno);
		Pessoa pessoa = pessoaService.getPessoa(aluno.getIdPessoa());
		completo.setPessoa(pessoa);
		return completo;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody Aluno aluno) {
		log.debug("Aluno - POST");
		alunoService.save(aluno);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Aluno inserida com sucesso");
	}
	
	

	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("aluno - DELETE");
		alunoService.delete(new Aluno(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "aluno removida com sucesso");
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update( @RequestBody Aluno aluno, @PathVariable Integer id) {
		log.debug("aluno - PUT");
		aluno.setId(id);
		log.debug("Updating aluno: {}", aluno);
		alunoService.update(aluno);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "aluno atualizada com sucesso");
	}
	
}
