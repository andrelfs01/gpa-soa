package br.ufc.quixada.spa.service.impl;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.spa.model.Aluno;
import br.ufc.quixada.spa.service.AlunoService;

@Component
@Named
public class AlunoServiceImpl extends GenericServiceImpl<Aluno> implements AlunoService{

}
