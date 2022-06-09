package ar.edu.unq.desapp.grupoi.backenddesappapl.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Transaction;

@Configuration
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {}
