/**
 * Copyright (C), 2019
 * FileName: MyLisenter
 * Author:   zhangjian
 * Date:     2019/7/12 20:26
 * Description: 自定义监听器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.event.listener;

import com.zj.event.event.ListenerEvent;
import com.zj.event.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义监听事件，实现ApplicationListener
 */
@Component
public class MyLisenter implements ApplicationListener<MyEvent> {
    private List<ListenerEvent> list = new ArrayList<>();

    /**
     * 对监听到的事件进行处理
     * @param myEvent
     */
    @Override
    public void onApplicationEvent(MyEvent myEvent) {

        //监听到MyEvent事件后，做的处理
        System.out.println(this.toString()+"监听到"+myEvent.getName()
                +",回复："+"我来陪你玩");

    }
}
