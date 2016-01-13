package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.spa.model.IdAluno;
import br.ufc.quixada.spa.model.util.Aluno;

public interface AlunoRestService {

	Aluno getAluno(IdAluno i) throws Exception;

	List<Aluno> getTodosAlunos(List<IdAluno> idsAlunos);
}
