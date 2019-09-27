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

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//消息生产者
public class Sender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    //发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息，
    public void send(int i) {
        String msg = "消息:"+i;
        System.out.println("Sender1_"+i+":"+msg);
        this.rabbitTemplate.convertAndSend("exchange","topic.message", msg);
    }
}
