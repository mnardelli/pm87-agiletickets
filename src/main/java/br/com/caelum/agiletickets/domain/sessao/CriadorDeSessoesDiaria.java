package br.com.caelum.agiletickets.domain.sessao;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Periodicidade;
import br.com.caelum.agiletickets.models.Sessao;

public class CriadorDeSessoesDiaria implements CriadorDeSessoes {

	@Override
	public List<Sessao> cria(LocalDate inicio, LocalDate fim,
			LocalTime horario, Periodicidade periodicidade, Espetaculo espetaculo) {
		List<Sessao> sessoes = new ArrayList<Sessao>();
		for(LocalDate data = inicio; !data.isAfter(fim); data = data.plusDays(1)) {
			Sessao sessao = new Sessao();
			sessao.setInicio(data.toDateTime(horario));
			sessao.setEspetaculo(espetaculo);
			sessoes.add(sessao);
		}
		return sessoes;
	}

}
