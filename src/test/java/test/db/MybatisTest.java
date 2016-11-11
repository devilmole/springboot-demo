package test.db;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.Application;
import org.devilmole.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MybatisTest {

    private static Logger logger = LogManager.getLogger(MybatisTest.class);
    @Autowired
    private DemoService demoService;

    @Autowired
    ApplicationContext ctx;

    @Test
    public void testService() throws Exception {
        DataSource datasource = ctx.getBean(DataSource.class);
        System.out.println(datasource);
        if (!(datasource instanceof HikariDataSource)) {
            System.err.println("Wrong datasource type: " + datasource.getClass().getCanonicalName());
            System.exit(-1);
        }

        boolean a=demoService.checkSystemUser("dev");
        logger.info("testService ---a------->"+a);
    }
}
