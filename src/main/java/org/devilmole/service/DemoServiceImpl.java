package org.devilmole.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.mapper.primary.DemoMapper;
import org.devilmole.mapper.secondary.Demo2Mapper;
import org.devilmole.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
@Service
public class DemoServiceImpl implements DemoService {

    /**
     * actuate 标记值
     */
    @Autowired
    private CounterService counterService;
//
//
//    public DemoServiceImpl(CounterService counterService) {
//        this.counterService = counterService;
//    }

    private static Logger logger = LogManager.getLogger(DemoServiceImpl.class);
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private Demo2Mapper demo2Mapper;

    public int getSystemUserCount(){
        counterService.increment("getSystemUserCount check times");
        logger.info("here getSystemUserCount");
        logger.error("error getSystemUserCount");
        return demoMapper.getSystemUserCount();
    }

    public boolean checkSystemUser(String loginName){
        int b=demo2Mapper.newTestCustom();
        int a=demoMapper.checkSystemUser(loginName);
        logger.info(b+"------checkSystemUser------>"+a);
        if(a>1){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public void testTrans(){
        String id= UUID.randomUUID().toString();
        int a=demoMapper.newProduct(id);
        int b=demoMapper.newCombo(id,"11011");
    }

    public int createUserService(){
        return 0;
    }
    public int updateUserService(){
        return 0;
    }
    public int deleteUserService(){
        return 0;
    }
    public SystemUser getUserService(Long id){
        return null;
    }
    public List getUserPageService(){
        return null;
    }
}
