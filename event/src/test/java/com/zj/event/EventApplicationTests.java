package com.zj.event;

import com.zj.event.event.MyEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventApplicationTests {

    /**
     * 上下文对象
     */
    @Resource
    private ApplicationContext applicationContext;


    @Test
    public void listenerTest1(){
        MyEvent myEvent=new MyEvent(this, "小美","好无聊啊！");


        /**
         * 通过上下文对象发布监听
         * publishEvent相当于观察者模式里的notivy方法，通知listener里的事件触发
         */
        applicationContext.publishEvent(myEvent);
    }

}
