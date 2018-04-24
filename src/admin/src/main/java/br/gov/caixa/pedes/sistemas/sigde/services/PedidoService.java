package br.gov.caixa.pedes.sistemas.sigde.services;

import java.util.Date;

import br.gov.caixa.pedes.sistemas.sigde.domain.Cliente;
import br.gov.caixa.pedes.sistemas.sigde.domain.enums.Perfil;
import br.gov.caixa.pedes.sistemas.sigde.security.UserSS;
import br.gov.caixa.pedes.sistemas.sigde.services.exceptions.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.caixa.pedes.sistemas.sigde.domain.ItemPedido;
import br.gov.caixa.pedes.sistemas.sigde.domain.PagamentoComBoleto;
import br.gov.caixa.pedes.sistemas.sigde.domain.Pedido;
import br.gov.caixa.pedes.sistemas.sigde.domain.enums.EstadoPagamento;
import br.gov.caixa.pedes.sistemas.sigde.repositories.ClienteRepository;
import br.gov.caixa.pedes.sistemas.sigde.repositories.ItemPedidoRepository;
import br.gov.caixa.pedes.sistemas.sigde.repositories.PagamentoRepository;
import br.gov.caixa.pedes.sistemas.sigde.repositories.PedidoRepository;
import br.gov.caixa.pedes.sistemas.sigde.repositories.ProdutoRepository;
import br.gov.caixa.pedes.sistemas.sigde.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private PagamentoRepository repositoryPagamento;
	
	@Autowired
	private ProdutoRepository repositoryProduto;
	
	@Autowired
	private ItemPedidoRepository repositoryItemPedido;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private ClienteRepository repositoryCliente;
	
	@Autowired
	private EmailService emailService;
	
	public Pedido findById(Integer id) {
		Pedido obj = repository.findOne(id);
		if (obj == null ) {
			throw new ObjectNotFoundException("Pedido não encontrado ! Id: " + id + ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
	
	public Pedido insert(Pedido pedido) {
		pedido.setId(null);
		pedido.setCliente(repositoryCliente.findOne(pedido.getCliente().getId()));
		pedido.setInstante(new Date());
		pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		pedido.getPagamento().setPedido(pedido);
		if (pedido.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) pedido.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, pedido.getInstante());
		}
		
		pedido = repository.save(pedido);
		repositoryPagamento.save(pedido.getPagamento());
		
		for (ItemPedido itemPedido : pedido.getItens()) {
			itemPedido.setDesconto(0.0);
			itemPedido.setProduto(repositoryProduto.findOne(itemPedido.getProduto().getId()));
			itemPedido.setPreco(itemPedido.getProduto().getPreco());
			itemPedido.setPedido(pedido);
		}
		
		repositoryItemPedido.save(pedido.getItens());
		
		emailService.sendOrderConfirmationEmail(pedido);
		
		return pedido;
	}

	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS userSS = UserService.authenticated();

		if (userSS == null) {
			throw new AuthorizationException("Acesso negado !");
		}

		Cliente cliente = repositoryCliente.findOne(userSS.getId());

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findByCliente(cliente, pageRequest);
	}

}
