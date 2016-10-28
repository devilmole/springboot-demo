package org.devilmole.service;

import org.devilmole.model.SystemUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
@Component
public interface DemoService {

    int getSystemUserCount();

    boolean checkSystemUser(String loginName);

    void testTrans();

    int createUserService();
    int updateUserService();
    int deleteUserService();
    SystemUser getUserService(Long id);
    List getUserPageService();
}
