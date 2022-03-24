package com.atguigu.recursion;

/**
 * @ author He
 * @ create 2022-03-18 10:36
 */
public class RecursionTest {
    public static void main(String[] args) {

        //通过打印问题回顾递归调用机制
        //test(4);
        //test1(4);
        System.out.println(factorial(3));
    }

    //打印问题
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }
    public static void test1(int n) {
        if (n > 2) {
            test1(n - 1);
        }else {
            System.out.println("n=" + n);
        }
    }

    //阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }}

}
