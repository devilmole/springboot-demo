package test.util;

import org.devilmole.model.SystemUser;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class Test {

    @org.junit.Test
    public void testName() throws Exception {
        SystemUser temp=new SystemUser();
        System.out.println(temp.getAge());
    }
}
