package org.devilmole.mapper;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public interface DemoMapper {

    int getSystemUserCount();

    int newProduct(String id);

    int newCombo(String id,String code);

}
