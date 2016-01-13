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
import br.ufc.quixada.spa.model.Pessoa;
import br.ufc.quixada.spa.service.PessoaService;

@Named
@RequestMapping("/pessoas")
public class PessoaController {
private Logger log = LoggerFactory.getLogger(this.getClass());
		
	@Inject
	private PessoaService pessoaService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Pessoa> findAll() {
		log.debug("PessoaFamilia - GET (all)");
		return pessoaService.find(Pessoa.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Pessoa findById(@PathVariable Integer id) {
		log.debug("Pessoa - GET (id)");
		log.debug(pessoaService.find(Pessoa.class, id).toString());
		return pessoaService.find(Pessoa.class, id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody Pessoa pessoa) {
		log.debug("Pessoa - POST");
		pessoaService.save(pessoa);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Pessoa inserida com sucesso");
	}
	
	

	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("Pessoa - DELETE");
		pessoaService.delete(new Pessoa(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Pessoa removida com sucesso");
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Pessoa pessoa, @PathVariable Integer id) {
		log.debug("Pessoa - PUT");
		pessoa.setId(id);
		log.debug("Updating aluno: {}", pessoa);
		pessoaService.update(pessoa);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Pessoa atualizada com sucesso");
	}

}
