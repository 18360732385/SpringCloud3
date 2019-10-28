/**
 * Copyright (C), 2019
 * FileName: MyApplicationRunner
 * Author:   zhangjian
 * Date:     2019/7/16 16:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.rabbitmq.run;

import com.zj.rabbitmq.receiver.Receiver1;
import com.zj.rabbitmq.receiver.Receiver2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 随程序一起启动的系统任务
 */
@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    Receiver1 receiver1;
    @Autowired
    Receiver2 receiver2;

    @Override
    public void run(ApplicationArguments var1) {
        List<String> nonOptionArgs = var1.getNonOptionArgs();
        System.out.println("main方法里启动的参数： "+nonOptionArgs);

        System.out.println("===========RabbitReceiver自启动==========");
        System.out.println("Receiver1地址:"+ receiver1.toString()+"");
        System.out.println("Receiver2地址:"+ receiver2.toString()+"");
        System.out.println("===========RabbitReceiver自启动结束=======");
    }
}

