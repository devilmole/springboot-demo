package org.devilmole.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
@RestController
public class WebserviceController {

    private static Logger logger = LogManager.getLogger(WebserviceController.class);

    @RequestMapping("/webserviceTest")
    public String webserviceTest(@RequestBody String source){
        System.out.println("111source---->" + source);
        logger.info("2222source---->"+source);
        return "1";
    }
}
