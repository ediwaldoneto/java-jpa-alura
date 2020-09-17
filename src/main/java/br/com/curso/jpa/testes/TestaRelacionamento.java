package br.com.curso.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;
import br.com.curso.jpa.modelo.Movimentacao;
import br.com.curso.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();

		conta.setTitular("Lucas Silva e Silva");
		conta.setAgencia(123);
		conta.setNumero(4321);
		conta.setSaldo(400.00);

		Movimentacao movimentacao = new Movimentacao();

		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Energia");
		movimentacao.setValor(new BigDecimal(255.00));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(conta);
		em.persist(movimentacao);

		em.getTransaction().commit();

		em.close();

	}
}
