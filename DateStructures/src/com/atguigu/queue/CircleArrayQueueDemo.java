package com.atguigu.queue;

import java.util.Scanner;

/**
 * @ author He
 * @ create 2022-02-20 11:36
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建一个队列
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列队列");
            System.out.println("g(get):从队列取出数据队列");
            System.out.println("h(head):先查看队列头的数据");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("队列头数据是" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}


//使用数组模拟队列-编写一个ArrayQueue类
class CircleArrayQueue {
    private int maxSize; // 表示数组的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    //创建队列的构造器
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = 0;//指向队列尾部，指向队列尾的数据（就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否能满
        if (isFull()) {
            System.out.println("队列满不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，数据出队列
    public int getQueue() {
        //判断数据是否空
        if (isEmpty()) {
            //抛异常
            throw new RuntimeException("队列为空，不能取数据");
        }
        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }


    //显示队列的头数据，注意不是取数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }

}