package org.devilmole.controller;

import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
@Controller
@Api(value = "页面跳转测试类",description = "api test")
public class ControllerExample {

    private static Logger logger = LogManager.getLogger(ControllerExample.class);
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/indexTest")
    public String home(Model model){
        System.out.println("inside");
        logger.info("inside logger");
        int a=demoService.getSystemUserCount();
        logger.debug("a-------->" + a);
        logger.info("a-----logger--->" + a);
        model.addAttribute("result",a);
        model.addAttribute("detail",a);
        return "index";
    }
}
