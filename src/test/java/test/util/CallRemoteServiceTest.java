package test.util;

import org.devilmole.Application;
import org.devilmole.model.SystemUser;
import org.devilmole.remote.CallRemoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CallRemoteServiceTest {
    @Autowired
    private CallRemoteService callRemoteService;

    @Test
    public void testRemoteService() throws Exception {
        SystemUser result=(SystemUser)callRemoteService.getRemoteService("http://192.168.52.112:8011/user/12365",SystemUser.class);
        System.out.println("testRemoteService--------------------------->"+result.getName());
    }
}
