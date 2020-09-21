package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Joao Cara de Jose");
		conta.setAgencia(335);
		conta.setNumero(45334);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
	}
}
