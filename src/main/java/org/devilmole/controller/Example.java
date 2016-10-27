package org.devilmole.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
@Controller
public class Example {

    private static Logger logger = LogManager.getLogger(Example.class);
    @Autowired
    private DemoService demoService;

    @RequestMapping("/")
    public String home(Model model){
        System.out.println("inside");
        logger.info("inside logger");
        int a=demoService.getSystemUserCount();
        logger.debug("a-------->" + a);
        logger.info("a-----logger--->" + a);
        model.addAttribute("result",a);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        logger.trace("test---->");
        demoService.testTrans();
        return "done";
    }

}
