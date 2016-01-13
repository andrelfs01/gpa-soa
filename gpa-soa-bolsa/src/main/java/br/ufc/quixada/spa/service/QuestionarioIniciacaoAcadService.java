package br.ufc.quixada.spa.service;

import br.ufc.quixada.spa.model.QuestionarioIniciacaoAcademica;
import br.ufc.quixada.npi.service.GenericService;

public interface QuestionarioIniciacaoAcadService extends GenericService<QuestionarioIniciacaoAcademica> {
	
	public abstract QuestionarioIniciacaoAcademica getQuestIniAcadById(Integer id);
}
