package br.ufc.soa.Enums;

import java.util.Map;
import java.util.TreeMap;

public enum TipoEnsinoFundamental{
	PUBLICO("Público"), PARTICULAR("Particular"), PART_COM_BOLSA("Particular com Bolsa");
	
	private String nome;
	private static Map<TipoEnsinoFundamental, String> map;

	TipoEnsinoFundamental(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public static Map<TipoEnsinoFundamental, String> toMap() {
		if (map == null) {
			map = new TreeMap<TipoEnsinoFundamental, String>();
			for (TipoEnsinoFundamental tef : TipoEnsinoFundamental.values()) {
				map.put(tef, tef.nome);
			}
		}
		return map;
	}
} 
