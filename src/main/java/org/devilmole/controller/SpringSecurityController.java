package org.devilmole.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
@Controller
public class SpringSecurityController {
    @Autowired
    private DemoService demoService;

    private static Logger logger = LogManager.getLogger(SpringSecurityController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        int a=demoService.getSystemUserCount();
        logger.error("a----------------------------------->"+a);
        model.addAttribute("testAtt",a);
        return "index";
    }

    @PreAuthorize("@demoServiceImpl.checkSystemUser(#logName)")
    @RequestMapping("/index2")
    public String index2(Model model, @RequestParam("logName") String logName) {
        int a=demoService.getSystemUserCount();
        logger.error("logName------->"+logName);
        logger.error("a----------------------------------->"+a);
        model.addAttribute("testAtt",a);
        return "index";
    }


}
