package test.db;

import org.devilmole.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private HttpSession session;

    @Test
    public void testRedis() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("bbb", "adfasdf");
        session.setAttribute("username","1231313123afda");
        Assert.assertEquals("adfasdf", stringRedisTemplate.opsForValue().get("bbb"));


    }
}
