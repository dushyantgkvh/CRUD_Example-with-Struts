package com.witty.struts.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtilWithEntityManager {

	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		
		if (entityManagerFactory == null) {
			
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}
		return entityManagerFactory;

	}

}
