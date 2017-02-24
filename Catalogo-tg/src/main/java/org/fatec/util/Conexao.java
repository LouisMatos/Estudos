package org.fatec.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
	private EntityManager em = factory.createEntityManager();
	public EntityManager getEntityManager() {
		return em;
	}
	
	

}
