package com.atguigu.josephu;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * @ author He
 * @ create 2022-02-28 15:16
 */
public class Josephu {
    public static void main(String[] args) {
        //测试环形链表和遍历是否Ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(25);//加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试小孩出圈
        circleSingleLinkedList.countBoy(1,2,25);
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);

    //添加小孩的节点，构建一个环形的链表
    public void add(int nums) {
        //nums做一个数据检验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用一个for循环创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环形
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩");
        }
        //因为first不能动，因此我们仍然使用一个复制指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号" + curBoy.getNo());
            if (curBoy.getNext() == first) {//遍历完毕
                break;
            }
            curBoy = curBoy.getNext();//curBoy后移
        }
    }

    //根据用户的思路，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        //创建一个辅助指针帮助完成小孩出圈
        Boy helper = first;
        //需求创建一个辅助指针helper，事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {//说明helper指向了最后小孩的节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m-1次，然后出圈,
        //循环操作，直到圈中只有一个节点
        while (true) {
            if (helper == first) {//说明只有一个节点
                break;
            }
            //让first和helper指针同时移动countNum-1次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向的节点就是要出圈的小孩节点
            System.out.println("小孩" + first.getNo() + "出圈");
            //这是将first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号" + first.getNo());
    }

}


//创建一个boy类，表示一个节点
class Boy {
    private int no; //编号
    private Boy next;//指向下一个节点,默认为null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
