package test.db;

import org.devilmole.Application;
import org.devilmole.domain.UserRepository;
import org.devilmole.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes =Application.class)
public class MongoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testMongoDB() throws Exception {
        System.out.println(userRepository);
        userRepository.save(new User(1L, "didi", 30));
    }
}
