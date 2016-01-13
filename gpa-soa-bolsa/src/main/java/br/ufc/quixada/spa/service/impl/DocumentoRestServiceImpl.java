package br.ufc.quixada.spa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.ufc.quixada.spa.model.IdDocumento;
import br.ufc.quixada.spa.model.util.Documento;
import br.ufc.quixada.spa.service.DocumentoRestService;

@Named
public class DocumentoRestServiceImpl implements DocumentoRestService{

    public Documento getDocumento(IdDocumento id) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Documento doc = restTemplate.getForObject("http://localhost:8080/gpa-soa-documento/documentos/"+id.getIdDocumento(), Documento.class);
        return doc;
    }
    
   public List<Documento> getTodosDocumentos(List<IdDocumento> idsDocs){
    	List<Documento> docs = null;
    	
    	for (IdDocumento idDoc : idsDocs) {
			try {
				docs.add(getDocumento(idDoc));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}    	
    	return docs;
    	
    }

   @Override
	public List<IdDocumento> salvarDocumentos(List<Documento> documentos) {
	   List<IdDocumento> idsDocumentos = new ArrayList<>();
	   RestTemplate rest = new RestTemplate();
	   MultiValueMap<String,Object> map = new LinkedMultiValueMap<String, Object>();
	
	   for (Documento doc : documentos) {
		   map.add("file",doc.getArquivo());
		   Long result = rest.postForObject("http://localhost:8080/gpa-soa-documento/documentos", map, Long.class);
		   IdDocumento idDoc = new IdDocumento();
		   idDoc.setIdDocumento(result);
		   idsDocumentos.add(idDoc);
	   }
	   return idsDocumentos;
		
	}
}