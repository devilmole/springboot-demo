package org.devilmole.domain;

import org.devilmole.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);
}
