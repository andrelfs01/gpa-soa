package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import br.ufc.quixada.spa.model.Documento;
import br.ufc.quixada.spa.service.DocumentoService;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;

@Named
public class DocumentoServiceImpl extends GenericServiceImpl<Documento> implements DocumentoService{

}
