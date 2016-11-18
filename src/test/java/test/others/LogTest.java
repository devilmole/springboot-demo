package test.others;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.Application;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2016/11/17 0017.
 */
public class LogTest {


    private static Logger logger =null;

//    @Before
    public void setUp() throws Exception {
        System.setProperty("log4j.configurationFile","log4j2.xml");
        logger = LogManager.getLogger();
    }

    //    @Rule
//    public LoggerContextRule init = new LoggerContextRule("MyTestConfig.xml");
//    @Test
    public void testLog4j2() throws Exception {
        logger.error("this is a test");
    }
}
