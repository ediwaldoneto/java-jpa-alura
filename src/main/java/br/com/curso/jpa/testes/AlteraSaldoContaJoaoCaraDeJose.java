package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;

public class AlteraSaldoContaJoaoCaraDeJose {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = em.find(Conta.class, 1L);

		conta.setSaldo(500.00);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
	}
}