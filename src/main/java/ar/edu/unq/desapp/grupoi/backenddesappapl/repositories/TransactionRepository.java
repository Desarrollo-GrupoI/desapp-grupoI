package ar.edu.unq.desapp.grupoi.backenddesappapl.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Transaction;

@Configuration
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE Transaction SET state = 'CANCELED' WHERE id != ?1 AND intention_id = ?2")
	void cancelAllOthersTransactions(Integer acceptedTransactionId, Integer intentionId);
}
