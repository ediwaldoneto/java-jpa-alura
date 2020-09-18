package br.com.curso.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Categoria;
import br.com.curso.jpa.modelo.Conta;
import br.com.curso.jpa.modelo.Movimentacao;
import br.com.curso.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(2L);

		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem SP");
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(400.00));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem RJ");
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(600.00));
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);

		em.getTransaction().commit();

		em.clear();

	}
}
