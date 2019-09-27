package com.zj.rabbitmq;

import com.zj.rabbitmq.entity.Student;
import com.zj.rabbitmq.sender.Sender1;
import com.zj.rabbitmq.sender.Sender2;
import com.zj.rabbitmq.sender.Sender3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitApplicationTests {
    @Autowired
    private Sender1 sender1;
    @Autowired
    private Sender2 sender2;
    @Autowired
    private Sender3 sender3;

    @Test
    public void test() {
        System.out.println("###############Sender1生产消息########");
        int i=0;
        while(i<10){
            sender1.send(i);
            //Thread.sleep(1000);
            i++;
        }
        System.out.println("##############Sender1生产消息结束#####");
    }

    @Test
    public void test1() {
        System.out.println("###############Sender2生产消息########");
        int i=0;
        while(i<10){
            Student student = new Student("小明", i);
            sender2.send(student);
            //Thread.sleep(1000);
            i++;
        }
        System.out.println("##############Sender2生产消息结束#####");
    }

    @Test
    public void test2() {
        System.out.println("###############Sender3生产消息########");
        int i=0;
        while(i<10){
            Student student = new Student("小明", i);
            sender3.send(i);
            //Thread.sleep(1000);
            i++;
        }
        System.out.println("##############Sender3生产消息结束#####");
    }
}

