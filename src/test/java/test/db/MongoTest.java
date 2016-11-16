package test.db;

import com.alibaba.fastjson.JSON;
import org.devilmole.Application;
import org.devilmole.domain.UserRepository;
import org.devilmole.model.SystemUser;
import org.devilmole.util.FastJson2JsonRedisSerializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MongoTest {

    @Autowired
    private UserRepository userRepository;

    private Map testMap=new HashMap();
    @Before
    public void setUp() throws Exception {

        testMap.put("name","aaaaa");
        testMap.put("uuid", UUID.randomUUID().toString());

    }

    @Test
    public void testMongoDB() throws Exception {
        SystemUser search=userRepository.findByName("didi2");
        System.out.println("--------------->"+search.getName());
        for (SystemUser temp:userRepository.findAll()) {
            System.out.println("+++++++++++++++++++++++>"+temp.getName());
        }
//        userRepository.save(new SystemUser(1L, "didi2", 30));
    }
}
