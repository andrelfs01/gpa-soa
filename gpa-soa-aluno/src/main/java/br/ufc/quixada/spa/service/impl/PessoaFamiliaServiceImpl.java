package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.spa.model.PessoaFamilia;
import br.ufc.quixada.spa.service.PessoaFamiliaService;

@Component
@Named
public class PessoaFamiliaServiceImpl extends GenericServiceImpl<PessoaFamilia> implements PessoaFamiliaService{

}
