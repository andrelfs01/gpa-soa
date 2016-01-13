package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.spa.model.IdServidor;
import br.ufc.quixada.spa.model.util.Servidor;

public interface ServidorRestService {
	Servidor getServidor(IdServidor i);

	List<Servidor> getServidores(List<IdServidor> membrosBanca);
}
