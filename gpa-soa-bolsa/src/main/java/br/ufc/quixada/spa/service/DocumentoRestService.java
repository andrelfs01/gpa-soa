package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.spa.model.IdDocumento;
import br.ufc.quixada.spa.model.util.Documento;

public interface DocumentoRestService {

	public Documento getDocumento(IdDocumento i) throws Exception;

	public List<Documento> getTodosDocumentos(List<IdDocumento> documentos);

	public List<IdDocumento> salvarDocumentos(List<Documento> documentos);
}
