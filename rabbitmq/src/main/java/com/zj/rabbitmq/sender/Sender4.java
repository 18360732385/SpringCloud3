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

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//消息生产者
public class Sender4 {
    @Autowired
//    private AmqpTemplate rabbitTemplate;
    private RabbitTemplate rabbitTemplate;

    public void send(int i) {
        String msg = "消息:"+i;
        System.out.println("Sender4_"+i+":"+msg);

//        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println("Sender4 消息发送失败" + cause + correlationData.toString());
            } else {
                //System.out.println("Sender4 消息发送成功 ");
            }
        });


        //只会匹配到topic.messages
        this.rabbitTemplate.convertAndSend("exchange","topic.messages", msg);
    }


//    @Override
//    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
//        System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s2);
//    }
//
}
