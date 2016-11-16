package test.db;

import org.devilmole.Application;
import org.devilmole.model.SystemUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@Transactional
public class RedisObjectTest {

    @Autowired
    private RedisTemplate redisTemplate;

    SystemUser user=new SystemUser(1l,"张三",21);

    @Autowired
    private HttpSession session;
    @Before
    public void setUp() throws Exception {
        redisTemplate.opsForValue().set("test1", user);
        session.setAttribute("users",user);
    }
    @Test
//    @Rollback(false)
    public void testRedis() throws Exception {
        System.out.println("-------------------------->"+session.getAttribute("users"));
        System.out.println("-------------------------->"+redisTemplate.opsForValue().get("test1"));
//        System.out.println("-------------------------->"+redisTemplate.opsForHash().get("test1","age"));
        Assert.assertEquals(21, ((SystemUser)redisTemplate.opsForValue().get("test1")).getAge());
    }
}
