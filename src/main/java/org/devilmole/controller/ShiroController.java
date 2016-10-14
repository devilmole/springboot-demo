package org.devilmole.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
@Controller
public class ShiroController {

    @Autowired
    private DemoService demoService;

    private static Logger logger = LogManager.getLogger(ShiroController.class);

    @RequestMapping("/shiro/index")
    public String shiroIndex(){
        System.out.println("test");
        System.out.println("test2");
        return "index";
    }

}
