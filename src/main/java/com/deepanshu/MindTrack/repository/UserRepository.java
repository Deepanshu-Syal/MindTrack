package com.deepanshu.MindTrack.repository;
import com.deepanshu.MindTrack.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);

    User deleteByUserName(String username);
}
