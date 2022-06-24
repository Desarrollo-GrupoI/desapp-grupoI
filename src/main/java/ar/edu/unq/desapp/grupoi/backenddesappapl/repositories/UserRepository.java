package ar.edu.unq.desapp.grupoi.backenddesappapl.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;

@Configuration
@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE User SET operations = operations + 1 WHERE email = ?1 OR email = ?2")
	void addOperation(String emailA, String emailB);
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE User SET reputation_points = reputation_points + ?2 WHERE email = ?1")
	void addReputationPoints(String email, Integer reputationPointsOperation);
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE User SET reputation_points = reputation_points + ?3 WHERE email = ?1 OR email = ?2")
	void addReputationPoints(String emailA, String emailB, Integer reputationPointsOperation);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE User SET reputation_points = reputation_points - ?2 WHERE email = ?1")
	void removeReputationPoints(String email, Integer reputationPointsOperation);
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE User SET reputation_points = reputation_points - ?3 WHERE email = ?1 OR email = ?2")
	void removeReputationPoints(String emailA, String emailB, Integer reputationPointsOperation);
}
