package org.devilmole.domain;

import org.devilmole.model.SystemUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public interface UserRepository extends MongoRepository<SystemUser, Long> {

    SystemUser findByName(String name);
}
