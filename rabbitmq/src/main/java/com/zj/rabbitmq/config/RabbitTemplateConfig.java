///**
// * Copyright (C), 2019
// * FileName: RabbitTemplateConfig
// * Author:   zhangjian
// * Date:     2019/11/29 15:46
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.zj.rabbitmq.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//
///**
// * 定制化amqp模版
// *
// * ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
// * ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack
// */
//@Configuration
//public class RabbitTemplateConfig {
//    @Resource
//    private RabbitTemplate rabbitTemplate;
//
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        Logger log = LoggerFactory.getLogger(RabbitTemplate.class);
//
//        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
//        rabbitTemplate.setMandatory(true);
//
//        // 消息返回, yml需要配置 publisher-returns: true
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
//            String correlationId = message.getMessageProperties().getMessageId();
//            log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
//        });
//
//        // 消息确认, yml需要配置 publisher-confirms: true
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if (ack) {
//                 log.debug("消息发送到exchange成功,id: {}", correlationData.getId());
//            } else {
//                log.debug("消息发送到exchange失败,原因: {}", cause);
//            }
//        });
//
//        return rabbitTemplate;
//    }
//}
//
