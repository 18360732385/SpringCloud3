/**
 * Copyright (C), 2019
 * FileName: MyEvent
 * Author:   zhangjian
 * Date:     2019/7/12 20:18
 * Description: 自定义事件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.event.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件，继承ApplicationEvent
 */
public class MyEvent extends ApplicationEvent {
    private String name;
    private String msg;

    //在自定义事件的构造方法中除了第一个source参数，其他参数都可以去自定义
    public MyEvent(Object source,String name,String msg) {
        super(source);
        this.msg=msg;
        this.name=name;

        this.printMsg(msg);
    }

    /**
     * 自定义监听器触发的透传打印方法
     * @param msg
     */
    public void printMsg(String msg) {
        System.out.println(name+"发朋友圈:" + msg);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
