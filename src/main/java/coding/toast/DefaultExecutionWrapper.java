package coding.toast;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@FunctionalInterface
public interface DefaultExecutionWrapper {
	static void wrapAndExecute(String persistenceUnitName, DefaultExecutionWrapper defaultWrapper) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			 EntityManager em = emf.createEntityManager()) {

			EntityTransaction tx = em.getTransaction();
			tx.begin();

			try {
				defaultWrapper.execute(emf, em, tx);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new RuntimeException(e);
			}

		}
	}
	
	void execute(EntityManagerFactory emf, EntityManager em, EntityTransaction tx);
}
