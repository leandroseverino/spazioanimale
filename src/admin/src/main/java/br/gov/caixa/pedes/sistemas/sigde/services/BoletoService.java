package br.gov.caixa.pedes.sistemas.sigde.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.gov.caixa.pedes.sistemas.sigde.domain.PagamentoComBoleto;


@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date dataPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
