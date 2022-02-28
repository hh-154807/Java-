package com.atguigu;

/**
 * @ author He
 * @ create 2022-02-28 9:11
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        //测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
//
//        doubleLinkedList.list();

//        System.out.println("修改测试");
//        HeroNode2 hero5 = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.update(hero5);
//        System.out.println("修改后的链表");
//        doubleLinkedList.list();
//
//        System.out.println("删除测试");
//        doubleLinkedList.del(3);
//        doubleLinkedList.list();

        System.out.println("按编号插入测试");
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //添加一个节点到双向链表的最后
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode2 temp = head;
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
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //双向链表按照编号添加
    public void addByOrder(HeroNode2 heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了

        HeroNode2 temp = head;
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
            if (temp.next != null) {
                heroNode.next = temp.next;
                temp.next.pre = heroNode;
                temp.next = heroNode;
                heroNode.pre = temp;

            } else {
                heroNode.next = temp.next;
                temp.next = heroNode;
                heroNode.pre = temp;
            }

        }
    }


    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("列表为空");
            return;
        }

        //修改一个节点的内容，可以看到双线链表的节点内容修改和前面单向链表一样
        HeroNode2 temp = head.next;
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

    //从双向链表中删除一个节点
    public void del(int no) {

        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//是否找到
        while (true) {
            if (temp == null) {//已经到链表的最后节点的next
                break;
            }
            if (temp.no == no) {
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {//找到
            temp.pre.next = temp.next;
            //可能删除节点为最后一个
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
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
        HeroNode2 temp = head.next;
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

//定义一个HeroNode2,每个HeroNode2对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指向前一个节点，默认为null

    //构造器
    public HeroNode2(int no, String name, String nickName) {
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
