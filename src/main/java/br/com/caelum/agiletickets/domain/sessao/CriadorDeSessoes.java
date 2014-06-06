package br.com.caelum.agiletickets.domain.sessao;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Periodicidade;
import br.com.caelum.agiletickets.models.Sessao;

public interface CriadorDeSessoes {

	public List<Sessao> cria(LocalDate inicio, LocalDate fim, LocalTime horario, Periodicidade periodicidade, Espetaculo espetaculo);
	
}
