package mx.com.parrot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.com.parrot.entity.User;



@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByEmail(String email);
}
