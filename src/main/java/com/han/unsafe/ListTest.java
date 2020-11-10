package com.han.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author Han
 * @Date 2020/11/7
 */

public class ListTest {
    //arrayList 默认不是安全的，试试换成vector？
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 1; i < 11; i++) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,5));
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }
//    }


    //arrayList 默认不是安全的，试试换成vector？但不是最好的方法！
//    public static void main(String[] args) {
//        List<String> list = new Vector<>();
//        for (int i = 1; i < 11; i++) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,5));
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }
//    }


    //arrayList 默认不是安全的，如果用collections工具类？但学过JUC的话会有更好的方式！

//    public static void main(String[] args) {
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        for (int i = 1; i < 11; i++) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,5));
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }
//    }
public static void main(String[] args) {
    List<String> list = new CopyOnWriteArrayList<>();
    for (int i = 1; i < 11; i++) {
        new Thread(()->{
            list.add(UUID.randomUUID().toString().substring(0,5));
            System.out.println(list);
        },String.valueOf(i)).start();
    }
}
}
