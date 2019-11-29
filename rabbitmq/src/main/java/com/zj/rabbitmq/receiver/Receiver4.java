/**
 * Copyright (C), 2019
 * FileName: Receiver
 * Author:   zhangjian
 * Date:     2019/8/8 13:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import com.zj.rabbitmq.config.TopicRabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = TopicRabbitConfig.messages)
public class Receiver4 {
    @RabbitHandler
    public void process(String hello, Channel channel, Message message) {
        // 采用手动应答模式, 手动确认应答更为安全稳定
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("Receiver4 : " + hello);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
