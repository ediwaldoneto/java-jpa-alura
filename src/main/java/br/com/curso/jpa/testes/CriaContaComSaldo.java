package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Edgar Allan Poe");
		conta.setAgencia(054);
		conta.setNumero(8558);
		conta.setSaldo(10.00);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
	}
}
