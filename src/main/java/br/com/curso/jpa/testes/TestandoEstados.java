package br.com.curso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Transient
		Conta conta = new Conta();
		conta.setTitular("Maria da Graca");
		conta.setNumero(12345);
		conta.setAgencia(2345);

		em.getTransaction().begin();
		
		// Transient -> Managed
		em.persist(conta);
		
		// Managed - Removed
		em.remove(conta);
		
		em.getTransaction().commit();

	}

}
