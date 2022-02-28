package com.atguigu.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ author He
 * @ create 2022-02-21 21:20
 */

//演示栈stack的基本使用
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("Tom");
        stack.add("smith");

        //出栈
        while (stack.size()>0){
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }

    }
}
