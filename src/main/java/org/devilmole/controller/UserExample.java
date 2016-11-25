package org.devilmole.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.devilmole.model.SystemUser;
import org.devilmole.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
@RestController
@RequestMapping("/user")
@Api(value = "接口测试类",description = "api test")
public class UserExample {

    private static Logger logger = LogManager.getLogger(UserExample.class);
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create something.", notes = "Returns the URL of the new resource in the Location header.")
    public void createUser(@RequestParam("param1") String param1,
                              HttpServletRequest request,
                              HttpServletResponse response,
                              HttpSession session){
        System.out.println("createUser param1----->" + param1);
        demoService.createUserService();
        Long id=new Random().nextLong();
//        response.setHeader("Location", request.getRequestURL().append("/").append(id).toString());
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a USER resource.", notes = "You have to provide a valid hotel ID in the URL and in the payload. The ID attribute can not be updated.")
    public SystemUser getUser(@ApiParam(value = "The ID of the existing user resource.", required = true)
                           @PathVariable("id") Long id,
                           HttpServletRequest request, HttpServletResponse response){
        System.out.println("getUser id----->" + id);
        SystemUser user=demoService.getUserService(id);
        return user;
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all users.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 10)")
    public List getAllUser(@ApiParam(value = "The page number (zero-based)", required = true)
                            @RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
                                 @ApiParam(value = "Tha page size", required = true)
                            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size,
                                 HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        System.out.println("userName-------- in session");
        session.setAttribute("userName", UUID.randomUUID().toString());
        List list=demoService.getUserPageService();
        return list;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a USER resource.", notes = "You have to provide a valid hotel ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateUser(@ApiParam(value = "The ID of the existing user resource.", required = true)
                               @PathVariable("id") Long id,
                           @RequestBody SystemUser user,
                           HttpServletRequest request, HttpServletResponse response){
        System.out.println("updateUser id----->" + id);
        demoService.updateUserService();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a USER resource.", notes = "You have to provide a valid hotel ID in the URL and in the payload. The ID attribute can not be updated.")
    public void deleteUser(@ApiParam(value = "The ID of the existing user resource.", required = true)
                           @PathVariable("id") Long id,
                           HttpServletRequest request, HttpServletResponse response){
        System.out.println("deleteUser id----->" + id);
        demoService.deleteUserService();
    }

}
