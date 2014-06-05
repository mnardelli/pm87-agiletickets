package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		
		switch (sessao.getEspetaculo().getTipo()) {
			case CINEMA:
			case SHOW:
				preco = calculaCinemaShow(sessao);
				break;
			case BALLET:
			case ORQUESTRA:
				preco = calculaBalletOrquestra(sessao);
				break;
			default:
				preco = sessao.getPreco();
		}
		
		return preco.multiply(BigDecimal.valueOf(quantidade));
	}
	
	private static BigDecimal calculaBalletOrquestra(Sessao sessao) {
		BigDecimal preco = adicionaAcrescimoComBaseEmOcupacao(sessao, BigDecimal.valueOf(0.20));
		
		return adicionaAcrescimoComBaseEmDuracao(sessao, preco, BigDecimal.valueOf(0.10));
	}

	private static BigDecimal adicionaAcrescimoComBaseEmDuracao(Sessao sessao,
			BigDecimal preco, BigDecimal fatorDoAcrescimo) {
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = adicionaPercentual(sessao, preco, fatorDoAcrescimo);
		}
		return preco;
	}

	private static BigDecimal adicionaAcrescimoComBaseEmOcupacao(Sessao sessao, BigDecimal fatorDoAcrescimo) {
		if(porcentagemDeIngressosRestantes(sessao) <= 0.50) { 
			return adicionaPercentual(sessao, sessao.getPreco(), fatorDoAcrescimo);
		} else {
			return sessao.getPreco();
		}
	}

	private static BigDecimal adicionaPercentual(Sessao sessao, BigDecimal preco, BigDecimal percentual) {
		return preco.add(sessao.getPreco().multiply(percentual));
	}

	private static BigDecimal calculaCinemaShow(Sessao sessao) {
		return adicionaAcrescimoComBaseEmOcupacao(sessao, BigDecimal.valueOf(0.10));
	}

	private static double porcentagemDeIngressosRestantes(Sessao sessao) {
		return (sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue();
	}

}