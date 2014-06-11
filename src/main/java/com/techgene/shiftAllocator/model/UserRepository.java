
package com.techgene.shiftAllocator.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techgene.shiftAllocator.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
