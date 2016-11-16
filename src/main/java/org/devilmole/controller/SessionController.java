package org.devilmole.controller;

import org.devilmole.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
@RestController
public class SessionController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/session")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid2", uid.toString());
        System.out.println("------------------------------uid->"+session.getAttribute("uid2"));
        System.out.println("------------------------------uid2->"+session.getCreationTime());
        return uid.toString();
    }
}
