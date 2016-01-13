package br.ufc.quixada.spa.control;

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
import br.ufc.quixada.spa.model.PessoaFamilia;
import br.ufc.quixada.spa.service.PessoaFamiliaService;

@Named
@RequestMapping("/familiares")
public class PessoaFamiliaController {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Inject
	private PessoaFamiliaService pessoaFamiliaService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<PessoaFamilia> findAll() {
		log.debug("PessoaFamilia - GET (all)");
		return pessoaFamiliaService.find(PessoaFamilia.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody PessoaFamilia findById(@PathVariable Integer id) {
		log.debug("PessoaFamilia - GET (id)");
		return pessoaFamiliaService.find(PessoaFamilia.class, id);
	}
	
		@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody PessoaFamilia aluno) {
		log.debug("PessoaFamilia - POST");
		pessoaFamiliaService.save(aluno);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "PessoaFamilia inserida com sucesso");
	}
	
	

	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("PessoaFamilia - DELETE");
		pessoaFamiliaService.delete(new PessoaFamilia(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "PessoaFamilia removida com sucesso");
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(PessoaFamilia pessoaFamilia, @PathVariable Integer id) {
		log.debug("PessoaFamilia - PUT");
		pessoaFamilia.setId(id);
		log.debug("Updating aluno: {}", pessoaFamilia);
		pessoaFamiliaService.update(pessoaFamilia);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "PessoaFamilia atualizada com sucesso");
	}

}
