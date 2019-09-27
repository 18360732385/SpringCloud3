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
package com.zj.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//消息生产者
public class Sender3 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String msg = "消息:"+i;
        System.out.println("Sender3_"+i+":"+msg);
        //s1代表的routing_key写啥都没有用，都会发送到fanout.A、B、C三个队列，这就是广播
        this.rabbitTemplate.convertAndSend("fanoutExchange","topic.message", msg);
    }
}
