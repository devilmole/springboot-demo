package org.devilmole.excute;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/15 0015.
 */
@Component
@Order(value = 2)
public class StartUpRunner2 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("StartUpRunner2----------------------->>>");
    }
}
