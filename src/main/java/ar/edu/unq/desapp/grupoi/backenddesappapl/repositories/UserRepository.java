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
	
	//
	@Query(nativeQuery=true, value = "UPDATE User SET operations = operations + 1, reputation_points = reputation_points + ?3 WHERE email = '?1' OR email = '?2'" )
	void addOperation(String userEmailA, String userEmailB, Integer points);
	
	@Query(nativeQuery=true, value = "UPDATE User SET reputation_points = reputation_points ?2 WHERE email = '?1'")
	void updateUserReputationPoints(String userEmail, String reputationPointsOperation);
}
