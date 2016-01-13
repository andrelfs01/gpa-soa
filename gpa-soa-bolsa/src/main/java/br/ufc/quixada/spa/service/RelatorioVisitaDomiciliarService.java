package br.ufc.quixada.spa.service;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.spa.model.RelatorioVisitaDomiciliar;

public interface RelatorioVisitaDomiciliarService extends GenericService<RelatorioVisitaDomiciliar>{
	public abstract RelatorioVisitaDomiciliar getRelatorioVisitaById(Integer id);


}
