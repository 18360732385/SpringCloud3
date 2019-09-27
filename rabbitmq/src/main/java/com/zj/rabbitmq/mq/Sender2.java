/**
 * Copyright (C), 2019
 * FileName: Sender
 * Author:   zhangjian
 * Date:     2019/5/22 17:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.rabbitmq.mq;

import com.zj.rabbitmq.entity.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//消息生产者
public class Sender2 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    //发送send2只会匹配到topic.messages
    public void send(Student student) {
        String msg = "消息:"+student;
        System.out.println("Sender2_:"+":"+msg);
        this.rabbitTemplate.convertAndSend("exchange","topic.messages", msg);
    }
}
