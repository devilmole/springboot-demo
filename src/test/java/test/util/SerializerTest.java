package test.util;

import com.alibaba.fastjson.JSON;
import org.devilmole.model.SystemUser;
import org.junit.Test;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class SerializerTest {

    @Test
    public void testSerializer() throws Exception {
        SystemUser user=new SystemUser(1l,"张三",21);
        byte[] by=JSON.toJSONString(user).getBytes("UTF-8");
        String after= new String(by, "UTF-8");
        System.out.println("---------------------------->"+after);
        SystemUser done=JSON.parseObject(after,SystemUser.class);
        System.out.println("---------------------------->"+done.getName());
//        System.out.println(serializer.serialize(source));

    }
}
