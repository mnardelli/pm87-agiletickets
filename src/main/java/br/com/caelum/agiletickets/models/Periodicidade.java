package br.com.caelum.agiletickets.models;

import br.com.caelum.agiletickets.domain.sessao.CriadorDeSessoes;
import br.com.caelum.agiletickets.domain.sessao.CriadorDeSessoesDiaria;
import br.com.caelum.agiletickets.domain.sessao.CriadorDeSessoesSemanal;

public enum Periodicidade {
	
	DIARIA { 
		public CriadorDeSessoes getCriadorDeSessoes(){
			return new CriadorDeSessoesDiaria();
		}
	}, SEMANAL{ 
		public CriadorDeSessoes getCriadorDeSessoes(){
			return new CriadorDeSessoesSemanal();
		}
	};
	
	public abstract CriadorDeSessoes getCriadorDeSessoes();
	
}
