package br.ufc.quixada.spa.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.web.client.RestTemplate;

import br.ufc.quixada.spa.model.IdServidor;
import br.ufc.quixada.spa.model.util.Servidor;
import br.ufc.quixada.spa.service.ServidorRestService;

@Named
public class ServidorRestServiceImpl implements ServidorRestService{

    public Servidor getServidor(IdServidor id) {
        RestTemplate restTemplate = new RestTemplate();
        Servidor servidor = restTemplate.getForObject("http://localhost:8080/gpa-soa-servidor/servidores", Servidor.class, id.getIdServidor());
        return servidor;
    }
    
   public List<Servidor> getServidores(List<IdServidor> idsServidores){
    	List<Servidor> servidores = null;
    	
    	for (IdServidor idServidor : idsServidores) {
			try {
				servidores.add(getServidor(idServidor));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}    	
    	return servidores;
    	
    }
}
