package ar.edu.unq.desapp.grupoi.backenddesappapl.repositories;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.IntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;


@Configuration
@Repository
public interface IntentionRepository extends CrudRepository<Intention, Integer> {
	
	public List<Intention> findAllByOperation(Operation operation);
}
