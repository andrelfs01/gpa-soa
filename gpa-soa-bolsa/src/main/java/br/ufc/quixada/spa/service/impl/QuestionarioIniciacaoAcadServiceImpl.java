package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.spa.model.QuestionarioIniciacaoAcademica;
import br.ufc.quixada.spa.service.QuestionarioIniciacaoAcadService;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class QuestionarioIniciacaoAcadServiceImpl extends GenericServiceImpl<QuestionarioIniciacaoAcademica> implements QuestionarioIniciacaoAcadService {

	@Override
	@Transactional(readOnly = true)
	public QuestionarioIniciacaoAcademica getQuestIniAcadById(Integer id) {
		return (QuestionarioIniciacaoAcademica) findFirst("IniAcad.findIniAcadById", new SimpleMap<String, Object>("idAluno", id));
	}
	

}
