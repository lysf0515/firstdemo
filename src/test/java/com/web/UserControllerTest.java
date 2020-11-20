package com.web;


import com.alibaba.fastjson.JSON;
import com.pojo.dto.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:main.xml","classpath:webmvc.xml"})
@WebAppConfiguration    //基于web的，请求启动一个web容器
public class UserControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;

    @Before
    public void before() {
        //创建mockMvc对象
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void list() throws Exception {
        MockHttpServletRequestBuilder requestBuilder
                = MockMvcRequestBuilders.get("http://127.0.0.1:8080/users");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();           //获取响应
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Message message = JSON.parseObject(contentAsString, Message.class);
        Assert.assertNotNull(message.getData());
        Assert.assertEquals("0000",message.getCode());
    }
}
