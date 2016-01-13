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
import br.ufc.quixada.spa.model.QuestionarioAuxilioMoradia;
import br.ufc.quixada.spa.service.QuestionarioAuxMoradiaService;

@Controller
@RequestMapping("auxilioMoradia")
public class AuxilioMoradiaController {

	@Inject
	private QuestionarioAuxMoradiaService questionarioAuxMoradiaService;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<QuestionarioAuxilioMoradia> findAll() {
		log.debug("QuestionarioAuxilioMoradia - GET (all)");
		return questionarioAuxMoradiaService.find(QuestionarioAuxilioMoradia.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody QuestionarioAuxilioMoradia findById(@PathVariable Integer id) {
		log.debug("QuestionarioAuxilioMoradia - GET (id)");
		return questionarioAuxMoradiaService.find(QuestionarioAuxilioMoradia.class, id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody QuestionarioAuxilioMoradia questionario) {
		log.debug("QuestionarioAuxilioMoradia - POST");
		questionarioAuxMoradiaService.save(questionario);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "QuestionarioAuxilioMoradia inserida com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("QuestionarioAuxilioMoradia - DELETE");
		questionarioAuxMoradiaService.delete(new QuestionarioAuxilioMoradia(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "QuestionarioAuxilioMoradia removida com sucesso");
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(QuestionarioAuxilioMoradia questionario, @PathVariable Integer id) {
		log.debug("QuestionarioAuxilioMoradia - PUT");
		questionario.setId(id);
		log.debug("Updating QuestionarioAuxilioMoradia: {}", questionario);
		questionarioAuxMoradiaService.update(questionario);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "QuestionarioAuxilioMoradia atualizada com sucesso");
	}

}
