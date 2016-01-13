package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.spa.model.IdServidor;
import br.ufc.quixada.spa.model.SelecaoBolsa;
import br.ufc.quixada.npi.service.GenericService;

public interface SelecaoBolsaService extends GenericService<SelecaoBolsa> {

	public abstract List<SelecaoBolsa> getSelecaoBolsasSubmetidos();
	
	public List<SelecaoBolsa> getSelecaoBolsasAtribuidos();

	public abstract List<SelecaoBolsa> getSelecaoBolsasByUsuario(Integer id);
	
	public abstract List<SelecaoBolsa> getSelecaoBolsasAguardandoParecer();
	
	public abstract boolean existsSelecaoEquals(SelecaoBolsa selecaoBolsa);

	public abstract SelecaoBolsa getSelecaoBolsaComDocumentos(Integer id);

	public abstract List<SelecaoBolsa> getSelecaoBolsaComMembros();

	public abstract SelecaoBolsa getSelecaoBolsaComMembros(Integer id);

	public abstract SelecaoBolsa getSelecaoBolsaComAlunos(Integer id);
	
	public abstract List<SelecaoBolsa> getSelecaoComAlunos();

	public abstract List<IdServidor> findByServidorBanca(Integer id);

}
