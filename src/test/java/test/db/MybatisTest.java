package test.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.Application;
import org.devilmole.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MybatisTest {

    private static Logger logger = LogManager.getLogger(MybatisTest.class);
    @Autowired
    private DemoService demoService;

    @Test
    public void testService() throws Exception {
        boolean a=demoService.checkSystemUser("dev");
        logger.info("testService ---a------->"+a);
    }
}
