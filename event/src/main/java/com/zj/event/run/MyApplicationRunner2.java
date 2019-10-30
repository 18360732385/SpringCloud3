/**
 * Copyright (C), 2019
 * FileName: MyApplicationRunner2
 * Author:   zhangjian
 * Date:     2019/7/12 23:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.event.run;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class MyApplicationRunner2 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments var1) throws Exception{
        System.out.println("MyApplicationRunner2!");
    }
}
