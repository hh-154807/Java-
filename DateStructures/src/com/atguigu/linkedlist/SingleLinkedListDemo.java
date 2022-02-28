package com.atguigu.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ author He
 * @ create 2022-02-21 9:59
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        for (int i = 0; i < 10000; i++) {
//            singleLinkedList.add(new HeroNode(i,"林冲"+i,"豹子头"+i));
//        }

        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //测试一下单链表的反转
//        System.out.println("原来链表的情况~~");
//        singleLinkedList.list();
//
//		System.out.println("反转单链表~~");
//		reverseList(singleLinkedList.getHead());
//		singleLinkedList.list();

//        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
//        long start = System.currentTimeMillis();
//        reversePrint(singleLinkedList.getHead());
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);//172

        //只是数据反转输出方法
//        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
//        long start = System.currentTimeMillis();
//        test(singleLinkedList.getHead());
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);//359


        //按照编号顺序加入
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);

        //修改链表
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
//        singleLinkedList.update(new HeroNode(4, "张顺", "浪里白条"));

        //删除一个节点
//        singleLinkedList.del(4);
//        singleLinkedList.del(1);
//        singleLinkedList.del(2);
//        singleLinkedList.del(3);

        //测试  求单链表中有效节点的个数
//        HeroNode head = singleLinkedList.getHead();
//        System.out.println("有效的节点个数 " + getLength(head));

        //测试一下看看是否得到了倒数第K个节点
//        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 0);
//        System.out.println(lastIndexNode);


        //显示
        singleLinkedList.list();

    }
    //可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head){
        if(head.next==null){
            return;//空表，不能打印
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack= new Stack<>();
        HeroNode cur= head.next;
        //将链表的所有节点压入栈
        while(cur!=null){
            stack.push(cur);
            cur= cur.next;
        }
        while(stack.size()>0){
            System.out.println(stack.pop());//stack的特点是先进后出
        }
    }

    //将单链表反转
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反装，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;
            reverseHead.next=cur;//将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }


    //单数据反转
    public static void test(HeroNode head) {
        ArrayList<HeroNode> list = new ArrayList<>();
        int size = getLength(head);
        HeroNode cur = head.next;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                cur = cur.next;
            }
            list.add(cur);
            cur = head.next;
        }
        for (HeroNode heroNode : list) {
            System.out.println(heroNode);
        }
    }


    //查找单链表中的倒数第k个结点 【新浪面试题】
    //思路
    //1. 编写一个方法，接收head节点，同时接收一个index
    //2. index 表示是倒数第index个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断链表为空，返回null
        if (head.next == null) {
            return null;//没有找到
        }
        //第一次遍历得到链表的长度
        int size = getLength(head);
        //第二次遍历 size-index 位置，就是我们倒数第K个节点
        //先做一个index的校验
        if (index < 0 || index > size) {
            return null;
        }
        //定义一个辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    //方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)

    /**
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {//空
            return 0;
        }
        int length = 0;
        //定义辅助变量
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break; //
            }
            if (temp.next.no > heroNode.no) {//位置找到了，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {//不能添加，编号已经存在
            System.out.println("准备插入的英雄的编号 " + heroNode.no + " 已经存在了, 不能加入");
        } else {
            //插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("列表为空");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到了改节点
        while (true) {
            if (temp == null) {
                break;//已经遍历完了
            }
            if (temp.no == newHeroNode.no) {//找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {//没有找到
            System.out.println("没有找到编号为 " + newHeroNode.no + " 的节点，不能修改");
        }
    }

    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//是否找到
        while (true) {
            if (temp.next == null) {//已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {//找到
            temp.next = temp.next.next;
        } else {
            System.out.println("删除的节点 " + no + " 不存在。");
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将next后移，一点小心
            temp = temp.next;
        }

    }

}


//定义一个HeroNode,每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方便，重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                "'}";
    }


}
