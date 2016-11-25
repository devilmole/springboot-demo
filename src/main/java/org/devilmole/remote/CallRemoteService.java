package org.devilmole.remote;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
@Service
public class CallRemoteService<T> {

    private Logger logger = LogManager.getLogger(CallRemoteService.class);

    private final RestTemplate restTemplate;

    public CallRemoteService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * 泛型 get 方法
     * @param url
     * @param objectClass
     * @return
     */
    public T getRemoteService(String url,Class<T> objectClass){
        return this.restTemplate.getForObject(url,objectClass);
    }
//
//    public void postRemoteService(String url, Class<T> objectClass, Map params){
//        this.restTemplate.postForObject(url,objectClass,params);
//    }


}
