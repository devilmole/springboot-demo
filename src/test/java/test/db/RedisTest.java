package test.db;

import org.devilmole.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes =Application.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("bbb", "adfasdf");
        System.out.println(stringRedisTemplate.opsForValue().get("bbb"));
        Assert.assertEquals("adfasdf", stringRedisTemplate.opsForValue().get("bbb"));


    }
}
