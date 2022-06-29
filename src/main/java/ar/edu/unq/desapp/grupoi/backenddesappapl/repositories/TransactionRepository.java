package ar.edu.unq.desapp.grupoi.backenddesappapl.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Transaction;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.TransactionState;

@Configuration
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
	@Modifying
	@Query(value = "UPDATE Transaction SET state = 'CANCELED' WHERE id != ?1 AND intention_id = ?2", nativeQuery = true)
	void cancelAllOthersTransactions(Integer acceptedTransactionId, Integer intentionId);
	
	@Query("SELECT t FROM Transaction t WHERE (user.email = ?1 OR transactionIntention.user.email = ?1) AND (date BETWEEN ?2 AND ?3)")
	List<Transaction> findDoneTransactions(String email, LocalDateTime dateFrom, LocalDateTime dateTo);
	
	@Query("SELECT t FROM Transaction t WHERE t.state = 'PENDING'")
	List<Transaction> findAllActives();
}
