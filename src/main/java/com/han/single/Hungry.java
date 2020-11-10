package com.han.single;

// 饿汉式单例
public class Hungry {

    // 可能会浪费空间


    private Hungry(){

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }

}
