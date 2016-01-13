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
import br.ufc.quixada.spa.model.Servidor;
import br.ufc.quixada.spa.model.util.Pessoa;
import br.ufc.quixada.spa.model.util.ServidorComp;
import br.ufc.quixada.spa.service.PessoaRestService;
import br.ufc.quixada.spa.service.ServidorService;

@Named
@RequestMapping("/servidores")
public class ServidorController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject
	private PessoaRestService pessoaService;

	@Inject
	private ServidorService servidorService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ServidorComp> findAll() {
		log.debug("Servidor - GET (all)");

		List<Servidor> servidores = servidorService.find(Servidor.class);
		List<ServidorComp> servidorComp = new ArrayList<>();
		for (Servidor s : servidores) {
			ServidorComp completo = new ServidorComp(s);
			Pessoa pessoa = pessoaService.getPessoa(s.getPessoa());
			completo.setPessoa(pessoa);
			servidorComp.add(completo);
		}
		return servidorComp;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody ServidorComp findById(@PathVariable Integer id) {
		log.debug("Servidor - GET (id)");
		
		Servidor servidor = servidorService.find(Servidor.class, id);
		ServidorComp completo = new ServidorComp(servidor);
		Pessoa pessoa = pessoaService.getPessoa(servidor.getPessoa());
		completo.setPessoa(pessoa);
		return completo;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody Servidor servidor) {
		log.debug("Servidor - POST");
		servidorService.save(servidor);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Servidor inserida com sucesso");
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("Servidor - DELETE");
		servidorService.delete(new Servidor(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Servidor removida com sucesso");
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Servidor servidor, @PathVariable Integer id) {
		log.debug("Servidor - PUT");
		servidor.setId(id);
		log.debug("Updating aluno: {}", servidor);
		servidorService.update(servidor);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Servidor atualizada com sucesso");
	}

}
