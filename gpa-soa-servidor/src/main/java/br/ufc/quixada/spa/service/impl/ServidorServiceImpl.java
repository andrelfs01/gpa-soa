package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.spa.model.Servidor;
import br.ufc.quixada.spa.service.ServidorService;

@Component
@Named
public class ServidorServiceImpl extends GenericServiceImpl<Servidor> implements ServidorService{

}
