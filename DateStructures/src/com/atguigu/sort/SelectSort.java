package com.atguigu.sort;

/**
 * @ author He
 * @ create 2022-03-18 19:34
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};


        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//S生成 [0-8000000) 数
        }

        long start = System.currentTimeMillis();

        selectSort(arr);

        long end = System.currentTimeMillis();//1.947

        System.out.println("排序花费的时间"+(end-start));

//        System.out.println(Arrays.toString(arr));



    }

    //选择排序
    public static void selectSort(int[] arr) {


        //在推导的过程，我们发现了规律，因此，可以使用for来解决
        //选择排序时间复杂度是 O(n^2)

        for (int j = 0; j < arr.length-1; j++) {
            int minIdex = j;
            int min = arr[j];
            for (int i = j+1; i < arr.length; i++) {
                if (min > arr[i]) {//说明假定的最小值，并不是最小
                    min = arr[i]; //重置min
                    minIdex = i;//重置minIndex
                }
            }
            //将最小值，放在arr[0],交换
            if(minIdex!=j){
                arr[minIdex] = arr[j];
                arr[j] = min;
            }
        }






        //使用逐步推导的方式来，讲解选择排序
        //第1轮
        //原始的数组 ： 	101, 34, 119, 1
        //第一轮排序 :   	1, 34, 119, 101
        //算法 先简单--》 做复杂， 就是可以把一个复杂的算法，拆分成简单的问题-》逐步解决

//        //第1轮
//        int minIdex = 0;
//        int min = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (min > arr[i]) {//说明假定的最小值，并不是最小
//                min = arr[i]; //重置min
//                minIdex = i;//重置minIndex
//            }
//        }
//        //将最小值，放在arr[0],交换
//        if(minIdex!=0){
//            arr[minIdex] = arr[0];
//            arr[0] = min;
//        }
//        System.out.println("第一轮后~~");
//        System.out.println(Arrays.toString(arr));
//
//        //第2轮
//        minIdex = 1;
//        min = arr[1];
//        for (int i = 1 + 1; i < arr.length; i++) {
//            if (min > arr[i]) {//说明假定的最小值，并不是最小
//                min = arr[i]; //重置min
//                minIdex = i;//重置minIndex
//            }
//        }
//        //将最小值，放在arr[0],交换
//        if(minIdex!=1){
//            arr[minIdex] = arr[1];
//            arr[1] = min;
//        }
//        System.out.println("第二轮后~~");
//        System.out.println(Arrays.toString(arr));
//
//        //第3轮
//        minIdex = 2;
//        min = arr[2];
//        for (int i = 2 + 1; i < arr.length; i++) {
//            if (min > arr[i]) {//说明假定的最小值，并不是最小
//                min = arr[i]; //重置min
//                minIdex = i;//重置minIndex
//            }
//        }
//        //将最小值，放在arr[0],交换
//        if(minIdex!=2){
//            arr[minIdex] = arr[2];
//            arr[2] = min;
//        }
//        System.out.println("第三轮后~~");
//        System.out.println(Arrays.toString(arr));

    }


}
