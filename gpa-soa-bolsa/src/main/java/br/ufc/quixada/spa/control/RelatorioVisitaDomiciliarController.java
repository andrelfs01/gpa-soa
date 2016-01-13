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
import br.ufc.quixada.spa.model.RelatorioVisitaDomiciliar;
import br.ufc.quixada.spa.service.RelatorioVisitaDomiciliarService;

@Controller
@RequestMapping("relatorioVisita")
public class RelatorioVisitaDomiciliarController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Inject
	private RelatorioVisitaDomiciliarService relatorioVisitaService;

	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<RelatorioVisitaDomiciliar> findAll() {
		log.debug("RelatorioVisitaDomiciliar - GET (all)");
		return relatorioVisitaService.find(RelatorioVisitaDomiciliar.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody RelatorioVisitaDomiciliar findById(@PathVariable Integer id) {
		log.debug("RelatorioVisitaDomiciliar - GET (id)");
		return relatorioVisitaService.find(RelatorioVisitaDomiciliar.class, id);
	}

	// cadastra um relatorio
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody RelatorioVisitaDomiciliar relatorioVisitaDomiciliar) {
		log.debug("RelatorioVisitaDomiciliar - POST");
		relatorioVisitaService.save(relatorioVisitaDomiciliar);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "RelatorioVisitaDomiciliar inserida com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("RelatorioVisitaDomiciliar - DELETE");
		relatorioVisitaService.delete(new RelatorioVisitaDomiciliar(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "RelatorioVisitaDomiciliar removida com sucesso");
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(RelatorioVisitaDomiciliar relatorio, @PathVariable Integer id) {
		log.debug("RelatorioVisitaDomiciliar - PUT");
		relatorio.setId(id);
		log.debug("Updating RelatorioVisitaDomiciliar: {}", relatorio);
		relatorioVisitaService.update(relatorio);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "RelatorioVisitaDomiciliar atualizada com sucesso");
	}
}
