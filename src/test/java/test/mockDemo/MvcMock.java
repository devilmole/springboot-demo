package test.mockDemo;

import org.devilmole.Application;
import org.devilmole.controller.UserExample;
import org.devilmole.service.DemoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MvcMock {

    @Autowired
    ApplicationContext ctx;

    @InjectMocks
    private UserExample example;

    @Mock
    private DemoService demoService;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);//初始化mock对象

        Mockito.reset(demoService);
        /*
         * 如果要使用完全默认Spring Web Context, 例如不需要对Controller注入,则使用
         * WebApplicationContext mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         */
        mvc= MockMvcBuilders.standaloneSetup(example).build();

    }

    @Test
    @Rollback(false)
    public void testController() throws Exception {

        Mockito.when(demoService.getSystemUserCount()).thenReturn(201);

        mvc.perform(get("/user"))
                .andDo(print()) // 输出请求和响应信息
                .andExpect(status().isOk());
//                .andExpect(view().name("index"))
//                .andExpect(model().attribute("result",is(201)));
        Mockito.verify(demoService,Mockito.times(1)).getUserPageService();
        Mockito.verifyNoMoreInteractions(demoService);
    }

    @Test
    public void testForm() throws Exception {
//        assertThat(this.ctx.containsBean("demoService")).isTrue();
//        assertThat(this.ctx.containsBean("controllerExample")).isTrue();
    }
}
