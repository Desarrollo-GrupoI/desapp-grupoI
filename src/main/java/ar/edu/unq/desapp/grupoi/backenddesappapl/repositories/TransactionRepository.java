package ar.edu.unq.desapp.grupoi.backenddesappapl.repositories;

import java.time.LocalDateTime;
import java.util.List;

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
	
	@Modifying
	@Query(nativeQuery = true, value = "SELECT Transaction t JOIN intention i ON t.intention_id = i.id WHERE (t.user_email = ?1 OR i.user_email = ?1) AND (date BETWEEN ?2 AND ?3)")
	List<Transaction> findDoneTransactions(String email, LocalDateTime dateFrom, LocalDateTime dateTo);
}
