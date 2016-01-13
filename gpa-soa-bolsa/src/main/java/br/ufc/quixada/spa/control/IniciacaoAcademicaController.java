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
import br.ufc.quixada.spa.model.QuestionarioIniciacaoAcademica;
import br.ufc.quixada.spa.service.QuestionarioIniciacaoAcadService;

@Controller
@RequestMapping("iniciacaoAcademica")
public class IniciacaoAcademicaController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Inject
	private QuestionarioIniciacaoAcadService iniciacaoAcademicaService;


	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<QuestionarioIniciacaoAcademica> findAll() {
		log.debug("QuestionarioIniciacaoAcademica - GET (all)");
		return iniciacaoAcademicaService.find(QuestionarioIniciacaoAcademica.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody QuestionarioIniciacaoAcademica findById(@PathVariable Integer id) {
		log.debug("QuestionarioIniciacaoAcademica - GET (id)");
		return iniciacaoAcademicaService.find(QuestionarioIniciacaoAcademica.class, id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody QuestionarioIniciacaoAcademica questionario) {
		log.debug("QuestionarioIniciacaoAcademica - POST");
		iniciacaoAcademicaService.save(questionario);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "QuestionarioIniciacaoAcademica inserida com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("QuestionarioIniciacaoAcademica - DELETE");
		iniciacaoAcademicaService.delete(new QuestionarioIniciacaoAcademica(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "QuestionarioIniciacaoAcademica removida com sucesso");
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(QuestionarioIniciacaoAcademica questionario, @PathVariable Integer id) {
		log.debug("QuestionarioIniciacaoAcademica - PUT");
		questionario.setId(id);
		log.debug("Updating QuestionarioIniciacaoAcademica: {}", questionario);
		iniciacaoAcademicaService.update(questionario);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "QuestionarioIniciacaoAcademica atualizada com sucesso");
	}

	
}
