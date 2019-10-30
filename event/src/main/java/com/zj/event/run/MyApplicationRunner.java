/**
 * Copyright (C), 2019
 * FileName: MyApplicationRunner
 * Author:   zhangjian
 * Date:     2019/7/12 23:48
 * Description: 开机自启
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.event.run;

import com.zj.event.event.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments var1) throws Exception{
        System.out.println("MyApplicationRunner1启动");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (i<=3) {
                    MyEvent myEvent = new MyEvent(this, "小" + i, i + "");
                    applicationContext.publishEvent(myEvent);
                    i++;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        }).start();
        /**
         **这里run（）方法，会直接运行，还是一条主线程。runner2只能等待runner1全部运行完才会运行；
         **而start（）方法才是真正的多线程开启方式，runner1和runner2几乎一起运行
         */
        System.out.println("MyApplicationRunner1结束");
    }
}
