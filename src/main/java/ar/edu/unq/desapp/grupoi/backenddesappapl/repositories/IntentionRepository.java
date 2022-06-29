package ar.edu.unq.desapp.grupoi.backenddesappapl.repositories;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;


@Configuration
@Repository
public interface IntentionRepository extends CrudRepository<Intention, Integer> {
	
	public List<Intention> findAllByOperation(Operation operation);
	
	@Query(value = "SELECT i.* FROM intention AS i LEFT OUTER JOIN transaction t ON i.id = t.intention_id GROUP BY i.id HAVING SUM(CASE WHEN t.state = 'DONE' THEN 1 ELSE 0 END) = 0", nativeQuery = true)
	public List<Intention> findAllActives();
}
