package ar.edu.unq.desapp.grupoi.backenddesappapl.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.IntentionBuySell;


@Configuration
@Repository
public interface IntentionBuySellRepository extends CrudRepository<IntentionBuySell, Long> {}
