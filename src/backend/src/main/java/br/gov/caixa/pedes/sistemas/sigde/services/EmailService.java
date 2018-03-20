package br.gov.caixa.pedes.sistemas.sigde.services;

import br.gov.caixa.pedes.sistemas.sigde.domain.Cliente;
import org.springframework.mail.SimpleMailMessage;

import br.gov.caixa.pedes.sistemas.sigde.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
