package test.mockDemo;

import org.devilmole.Application;
import org.devilmole.controller.Example;
import org.devilmole.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
public class MvcMock {

    @InjectMocks
    private Example example;

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
    public void testExample() throws Exception {

        Mockito.when(demoService.getSystemUserCount()).thenReturn(201);

        mvc.perform(get("/"))
                .andDo(print()) // 输出请求和响应信息
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("result",hasItem(201)));
        Mockito.verify(demoService,Mockito.times(1)).getSystemUserCount();
        Mockito.verifyNoMoreInteractions(demoService);
    }
}
