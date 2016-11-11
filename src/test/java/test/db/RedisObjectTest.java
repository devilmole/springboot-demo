package test.db;

import org.devilmole.Application;
import org.devilmole.model.SystemUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class RedisObjectTest {

    @Autowired
    private RedisTemplate<String, SystemUser> redisTemplate;

    @Test
    @Rollback(false)
    public void testRedis() throws Exception {

        SystemUser user=new SystemUser(1l,"张三",21);
        redisTemplate.opsForValue().set("test1", user);
        System.out.println("-------------------------->"+redisTemplate.opsForValue().get("test1").getName());
        Assert.assertEquals(21, redisTemplate.opsForValue().get("test1").getAge());


    }
}
