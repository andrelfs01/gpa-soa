package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import org.springframework.web.client.RestTemplate;

import br.ufc.quixada.spa.model.util.Pessoa;
import br.ufc.quixada.spa.service.PessoaRestService;

@Named
public class PessoaRestServiceImpl implements PessoaRestService{

	@Override
	public Pessoa getPessoa(int id) {
		RestTemplate restTemplate = new RestTemplate();
        Pessoa pessoa = restTemplate.getForObject("http://localhost:8080/gpa-soa-pessoa/pessoas/"+id, Pessoa.class);
        return pessoa;
	}
   
}
