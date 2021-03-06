package br.ufc.quixada.spa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.util.SimpleMap;
import br.ufc.quixada.spa.model.IdServidor;
import br.ufc.quixada.spa.model.SelecaoBolsa;
import br.ufc.quixada.spa.service.SelecaoBolsaService;

@Named
public class SelecaoBolsaServiceImpl extends GenericServiceImpl<SelecaoBolsa> implements
		SelecaoBolsaService {
	
	@Override
	public List<SelecaoBolsa> getSelecaoBolsasSubmetidos() {
		return find(QueryType.JPQL, "from SelecaoBolsa as p where p.status != 'NOVO' ", null);
	}
	
	@Override
	public List<SelecaoBolsa> getSelecaoBolsasAtribuidos() {
		return find(QueryType.JPQL, "from SelecaoBolsa as p where p.status = 'AGUARDANDO_PARECER' ", null);
	}

	@Override
	public List<SelecaoBolsa> getSelecaoBolsasByUsuario(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return find(QueryType.JPQL, "from SelecaoBolsa where usuario.id = :id", params);
	}
	
	@Override
	public List<SelecaoBolsa> getSelecaoBolsasAguardandoParecer() {
		return find(QueryType.JPQL, "from SelecaoBolsa as p where p.status = 'AGUARDANDO_PARECER'", null);
	}

	@Override
	@Transactional
	public boolean existsSelecaoEquals(SelecaoBolsa selecaoBolsa) {
		List<SelecaoBolsa> selecoes = find(QueryType.JPQL, "from SelecaoBolsa as p where p.tipoBolsa = :tipo and p.ano = :ano and p.sequencial = :sequencial",
				new SimpleMap<String, Object>("tipo",selecaoBolsa.getTipoBolsa(), "ano",selecaoBolsa.getAno(),"sequencial",selecaoBolsa.getSequencial() ));
		if(selecoes == null || selecoes.isEmpty()){
			return false;
		}
		return true;
	
	}

	@Override
	@Transactional
	public SelecaoBolsa getSelecaoBolsaComDocumentos(Integer id) {
		return (SelecaoBolsa) findFirst("SelecaoBolsa.findSelecaoBolsaComDocumentos", new SimpleMap<String, Object>("selecaoBolsaId", id));
	}
	
	@Override
	@Transactional
	public List<SelecaoBolsa> getSelecaoBolsaComMembros() {
		return ((List<SelecaoBolsa>)find("SelecaoBolsa.findSelecaoBolsaComMembros", new SimpleMap<String, Object>()));		
	}
	
	@Override
	@Transactional
	public SelecaoBolsa getSelecaoBolsaComMembros(Integer id) {
		return (SelecaoBolsa) findFirst("SelecaoBolsa.findSelecaoBolsaIdComMembros", new SimpleMap<String, Object>("selecaoBolsaId", id));
	}

	@Override
	@Transactional(readOnly = true)
	public SelecaoBolsa getSelecaoBolsaComAlunos(Integer id) {
		return (SelecaoBolsa) findFirst("SelecaoBolsa.findSelecaoBolsaIdComAlunos", new SimpleMap<String, Object>("selecaoBolsaId", id));
	}

	@Override
	@Transactional(readOnly = true)
	public List<SelecaoBolsa> getSelecaoComAlunos() {
		return ((List<SelecaoBolsa>) find("SelecaoBolsa.findSelecaoComAlunos", new SimpleMap<String, Object>()));
	}

	@Override
	public List<IdServidor> findByServidorBanca(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return find(QueryType.JPQL,
				"from IdServidor where IdServidor = :id",
				params);
	}
	
}
