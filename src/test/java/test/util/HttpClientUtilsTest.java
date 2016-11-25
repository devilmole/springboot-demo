package test.util;

import org.devilmole.remote.HttpClientTool;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
public class HttpClientUtilsTest {

    @Test
    public void testHttpClient() throws Exception {
        Map params=new HashMap<>();
        params.put("param1","param1 test ---->");
//        String result= HttpClientTool.getMethodGetResponse("https://www.baidu.com/");
        //http://192.168.52.112:8011/user/12365

        String result=HttpClientTool.getMethodPostResponse("http://localhost:8011/user",params);

        System.out.println("result--------------->" + result);
    }
}
