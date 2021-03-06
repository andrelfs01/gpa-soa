package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.spa.model.RelatorioVisitaDomiciliar;
import br.ufc.quixada.spa.service.RelatorioVisitaDomiciliarService;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.util.SimpleMap;

@Named
public class RelatorioVisitaDomiciliarServiceImpl extends GenericServiceImpl<RelatorioVisitaDomiciliar> 
implements RelatorioVisitaDomiciliarService{

	@Override
	@Transactional(readOnly = true)
	public RelatorioVisitaDomiciliar getRelatorioVisitaById(Integer id) {
		return (RelatorioVisitaDomiciliar) findFirst("RelatorioVisita.findRelatorioVisitaById", new SimpleMap<String, Object>("alunoId",id));
	}
	
	

}
