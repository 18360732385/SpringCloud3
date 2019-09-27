/**
 * Copyright (C), 2019
 * FileName: Student
 * Author:   zhangjian
 * Date:     2019/7/25 14:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.rabbitmq.entity;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age){
        this.name=name;
        this.age=age;
    }

    public void setName(String name){
        this.name=name;

    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "student [name="+name+" , "+"age="+age+"]";
    }

}
