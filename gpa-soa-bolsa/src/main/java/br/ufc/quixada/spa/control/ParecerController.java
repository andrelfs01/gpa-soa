package br.ufc.quixada.spa.control;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.npi.enumeration.ResponseStatus;
import br.ufc.quixada.npi.model.ResponseStatusMessage;
import br.ufc.quixada.spa.model.Parecer;
import br.ufc.quixada.spa.service.ParecerService;

@Controller
@RequestMapping("parecer")
public class ParecerController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Inject
	private ParecerService parecerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Parecer> findAll() {
		log.debug("Parecer - GET (all)");
		return parecerService.find(Parecer.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Parecer findById(@PathVariable Integer id) {
		log.debug("Parecer - GET (id)");
		return parecerService.find(Parecer.class, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody Parecer parecer) {
		log.debug("Parecer - POST");
		parecerService.save(parecer);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Parecer inserida com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("Parecer - DELETE");
		parecerService.delete(new Parecer(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Parecer removida com sucesso");
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Parecer parecer, @PathVariable Integer id) {
		log.debug("Parecer - PUT");
		parecer.setId(id);
		log.debug("Updating Parecer: {}", parecer);
		parecerService.update(parecer);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Parecer atualizada com sucesso");
	}
}
