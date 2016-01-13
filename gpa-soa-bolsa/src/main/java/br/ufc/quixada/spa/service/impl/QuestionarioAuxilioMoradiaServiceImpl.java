package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.spa.model.QuestionarioAuxilioMoradia;
import br.ufc.quixada.spa.service.QuestionarioAuxMoradiaService;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class QuestionarioAuxilioMoradiaServiceImpl extends GenericServiceImpl<QuestionarioAuxilioMoradia> 
	implements QuestionarioAuxMoradiaService {

	@Override
	@Transactional(readOnly = true)
	public QuestionarioAuxilioMoradia getQuestAuxMorById(Integer id) {
		return (QuestionarioAuxilioMoradia) findFirst("AuxMor.findAuxMorById", new SimpleMap<String, Object>("idAluno", id));
	}

	
	
}
