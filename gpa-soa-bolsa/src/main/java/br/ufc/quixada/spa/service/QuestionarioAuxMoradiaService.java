package br.ufc.quixada.spa.service;

import br.ufc.quixada.spa.model.QuestionarioAuxilioMoradia;
import br.ufc.quixada.npi.service.GenericService;

public interface QuestionarioAuxMoradiaService extends GenericService<QuestionarioAuxilioMoradia>{

	public abstract QuestionarioAuxilioMoradia getQuestAuxMorById(Integer id);
}
