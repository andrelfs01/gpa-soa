package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.spa.model.Pessoa;
import br.ufc.quixada.spa.service.PessoaService;

@Component
@Named
public class PessoaServiceImpl extends GenericServiceImpl<Pessoa> implements PessoaService{

}
