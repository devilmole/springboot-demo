package org.devilmole.mapper;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
@Component
public interface DemoMapper {

    int getSystemUserCount();

    int newProduct(String id);

    int checkSystemUser(String logName);

    int newCombo(String id,String code);

}
