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

import com.zj.rabbitmq.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicRabbitConfig.message)
public class Receiver3 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver3 : " + hello);
    }

}
