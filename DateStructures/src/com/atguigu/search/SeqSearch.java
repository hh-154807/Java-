package com.atguigu.search;

/**
 * @ author He
 * @ create 2022-03-21 15:15
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 344, 89};
        int index=seqSearh(arr,-11);
        if(index==-1){
            System.out.println("没有找到到");
        }else {
            System.out.println("找到，下标为=" + index);
        }
    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearh(int[] arr,int value){
        //线性查找十逐一比对
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }

}
