package br.com.curso.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.curso.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		

		TypedQuery<Movimentacao> query = em.createQuery("select m from Movimentacao m where m.conta.id =2", Movimentacao.class);
		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição " + movimentacao.getDescricao());
			System.out.println("Tipo " + movimentacao.getTipoMovimentacao());
		}

	}

}
