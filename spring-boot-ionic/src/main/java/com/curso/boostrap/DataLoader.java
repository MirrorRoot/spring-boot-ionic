package com.curso.boostrap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.domain.Categoria;
import com.curso.domain.Cidade;
import com.curso.domain.Cliente;
import com.curso.domain.Endereco;
import com.curso.domain.Estado;
import com.curso.domain.ItemPedido;
import com.curso.domain.PagamentoComBoleto;
import com.curso.domain.Pedido;
import com.curso.domain.Produto;
import com.curso.domain.enums.EstadoPagamento;
import com.curso.domain.enums.TipoCliente;
import com.curso.repositories.CategoriaRepository;
import com.curso.repositories.CidadeRepository;
import com.curso.repositories.ClienteRepository;
import com.curso.repositories.EnderecoRepository;
import com.curso.repositories.EstadoRepository;
import com.curso.repositories.ItemPedidoRepository;
import com.curso.repositories.PagamentoRepository;
import com.curso.repositories.PedidoRepository;
import com.curso.repositories.ProdutoRepository;
@Profile("dev")
@Configuration
public class DataLoader  {
	
	@Autowired
    private ClienteRepository cliRep;
	@Autowired
	private EnderecoRepository endRep;
	@Autowired 
	private CategoriaRepository catRep;
	@Autowired
	private ProdutoRepository prodRep;
	@Autowired
	private EstadoRepository estRep;
	@Autowired
	private CidadeRepository cidRep;
	@Autowired
	private PedidoRepository pedRep;
	@Autowired
	private PagamentoRepository pagRep;
	@Autowired
	private ItemPedidoRepository itRep;
	public DataLoader() {
		}
	
	@Bean
	CommandLineRunner initTableDatabase() {
		Categoria cat1=new Categoria();
	    Categoria cat2=new Categoria();		
	    cat1.setNome("Informatica");
	    cat2.setNome("Escritorio");
	    Produto p1=new Produto();
	    p1.setName("Computador");
	    p1.setPreco(2000);
	    Produto p2=new Produto();
	    p2.setName("impressora");
	    p2.setPreco(800);
	    Produto p3=new Produto();
	    p3.setName("mouse");
	    p3.setPreco(80);
	    cat1.setProdutos(Arrays.asList(p1,p2,p3));
	    cat2.setProdutos(Arrays.asList(p2));
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p3.getCategorias().add(cat1);
		Estado est1=new Estado(null,"Minas Gerais", "MG");
		Estado est2=new Estado(null,"Sao Paulo", "SP");
		Cidade cid1=new Cidade(null,"Patos de Minas", est1);
		Cidade cid2=new Cidade(null,"Uberlandia", est1);
		Cidade cid3=new Cidade(null,"Patrocinio", est1);
		Cidade cid4=new Cidade(null,"Campinas", est2);
		Cidade cid5=new Cidade(null,"Mogi", est2);
		est1.getCidades().add(cid1);
		est1.getCidades().add(cid2);
		est1.getCidades().add(cid3);
		est2.getCidades().add(cid4);
		est2.getCidades().add(cid5);
		Set<String> tel=new HashSet<>();
		tel.add("98849-8877");
		tel.add("3831-5066");
		Cliente cli=new Cliente(null, "Maria da Silva", "07137155521", "maria@gmail.com", TipoCliente.PESSOAFISICA, tel);
		Endereco end1=new Endereco(null, "Avenida Marciano Pires", "3724", "Apto", "Santo Antonio","38740-000", cid3, cli);
		Endereco end2=new Endereco(null, "Avenida Faria Pereira", "372", "casa", "Santo Cristovao","38740-000", cid3, cli);
		cli.setEnderecos(Arrays.asList(end1,end2));
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateTime = LocalDateTime.now().format(formatter);
        Pedido ped=new Pedido(null, LocalDateTime.now(), cli, end1);
        PagamentoComBoleto pg=new PagamentoComBoleto(null, EstadoPagamento.CANCELADO, ped, LocalDateTime.now(), LocalDateTime.of(2019, 01, 25, 10,20));
        ped.setPagamento(pg);
        ItemPedido item=new ItemPedido(ped, p1, 0.10, 2, 500);
        p1.getItens().add(item);
        ped.getItens().add(item);
		return args->{
		this.catRep.saveAll(Arrays.asList(cat1,cat2));
		this.prodRep.saveAll(Arrays.asList(p1,p2,p3));
		this.estRep.saveAll(Arrays.asList(est1,est2));
		this.cidRep.saveAll(Arrays.asList(cid1,cid2,cid3,cid4,cid5));
		this.cliRep.save(cli);
		this.endRep.saveAll(Arrays.asList(end1,end2));
	    this.pedRep.save(ped);
        this.itRep.save(item);
		};
	}
	
}
