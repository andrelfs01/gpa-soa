package br.ufc.quixada.spa.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.web.client.RestTemplate;

import br.ufc.quixada.spa.model.IdAluno;
import br.ufc.quixada.spa.model.util.Aluno;
import br.ufc.quixada.spa.service.AlunoRestService;

@Named
public class AlunoRestServiceImpl implements AlunoRestService{

    public Aluno getAluno(IdAluno id) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Aluno aluno = restTemplate.getForObject("http://localhost:8080/gpa-soa-aluno/alunos", Aluno.class, id.getIdAluno());
        
        return aluno;
    }
    
   public List<Aluno> getTodosAlunos(List<IdAluno> idsAlunos){
    	List<Aluno> alunos = null;
    	
    	for (IdAluno idAluno : idsAlunos) {
			try {
				alunos.add(getAluno(idAluno));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}    	
    	return alunos;
    	
    }
}
