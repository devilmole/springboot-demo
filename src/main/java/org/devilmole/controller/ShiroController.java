package org.devilmole.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
@Controller
public class ShiroController {

    @Autowired
    private DemoService demoService;

    private static Logger logger = LogManager.getLogger(ShiroController.class);


}
