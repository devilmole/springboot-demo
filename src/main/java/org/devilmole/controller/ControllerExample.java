package org.devilmole.controller;

import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
@Controller
@Api(value = "页面跳转测试类",description = "api test")
public class ControllerExample {

    private Logger logger = LogManager.getLogger(ControllerExample.class);
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/indexTest")
    public String home(Model model,HttpSession session){
        session.setAttribute("self etst","adfas阿凡达");
        session.setAttribute("test","dabg啊啊");
        System.out.println("inside");
        logger.info("inside logger");
        int a=demoService.getSystemUserCount();
        logger.debug("a-------->" + a);
        logger.error("a-----logger--->" + a);
        model.addAttribute("result",a);
        model.addAttribute("detail",a);
        return "index";
    }

    @RequestMapping(value = "/LeafTest")
    public String LeafTest(Model model,HttpSession session){
        int a=demoService.getSystemUserCount();
        model.addAttribute("result",a);
        model.addAttribute("detail",a);
        return "devilmole/test";
    }
}
