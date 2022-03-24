package com.atguigu.hashtab;

import java.util.Scanner;

/**
 * @ author He
 * @ create 2022-03-23 14:12
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建一个哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("a:添加雇员");
            System.out.println("l:显示雇员");
            System.out.println("f:查找雇员");
            System.out.println("e:退出系统");
            key = scanner.next();

            switch (key) {
                case "a":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "l":
                    hashTab.list();
                    break;
                case "f":
                    System.out.println("请输入查找的id");
                    int MemId = scanner.nextInt();
                    hashTab.findEmpById(MemId);
                    break;
                case "e":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }

    }


}

//创建HashTab 管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListsArr;
    private int size;//表示有多少条链表

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListsArr = new EmpLinkedList[size];
        //？留一个坑, 这时不要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListsArr[i] = new EmpLinkedList();
        }

    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id得到该员工应该添加到那条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListsArr[empLinkedListNo].add(emp);
    }

    //遍历所有链表,遍历hashtab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListsArr[i].list(i + 1);
        }
    }

    //编写一个散列函数，使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }

    //根据id查找雇员
    public void findEmpById(int id){
        //使用散列函数确定到那条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListsArr[empLinkedListNo].findEmpById(id);
        if(emp!=null){//找到
            System.out.println("在"+(empLinkedListNo+1)+"条链表中找到雇员"+id);
        }else{
            System.out.println("没有找到");
        }
    }

}


//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;//默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

//创建EmpLinkedList，表示链表

class EmpLinkedList {
    //头指针，指向第一个雇员，因此我们这个链表的head，时直接指向第一个emp
    private Emp head;//默认为空


    //添加雇员到链表
    //说明
    //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
    //   因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        //如果时添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {//到链表的最后
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将emp 加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) { //说明链表为空
            System.out.println("第" + no + "条链表为空");
            return;
        }
        System.out.print("第" + no + "条链表的信息为");
        Emp curEmp = head;//辅助指针
        while (true) {
            System.out.println("=>id=" + curEmp.id + "名字为" + curEmp.name);
            if (curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next;//后移遍历
        }

    }

    //根据查找雇员
    //如果查找到就返回Emp，如果没找到就返回null;
    public Emp findEmpById(int id) {
        //判断是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {//找到
                break;//这时curEmp就指向要查找的雇员
            }
            if (curEmp.next == null) {//说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

}