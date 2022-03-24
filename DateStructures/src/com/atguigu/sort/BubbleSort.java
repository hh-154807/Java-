package com.atguigu.sort;


/**
 * @ author He
 * @ create 2022-03-18 18:38
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int arr[] = {3, 9, -1, 10, 20};

        //测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//S生成 [0-8000000) 数
        }
//        System.out.println(Arrays.toString(arr));

//        Date date1 = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//        String date1str = dateFormat.format(date1);
//        System.out.println("排序前的时间+"+date1str);
        long start = System.currentTimeMillis();

        bubbleSort(arr);
        long end = System.currentTimeMillis();//8.839

        System.out.println("排序花费的时间"+(end-start));


        //为了容量理解，我们把冒泡排序的演变过程，给大家展示

//        //第一趟排序就是将最大的排在最后
//        int temp = 0;//临时变量
//        for (int j = 0; j < arr.length - 1; j++) {
//            //如果起那面的数比后面的数达，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第一趟数组");
//        System.out.println(Arrays.toString(arr));
//
//        // 第二趟排序，就是将第二大的数排在倒数第二位
//        for (int j = 0; j < arr.length - 1 - 1; j++) {
//            //如果起那面的数比后面的数达，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第二趟数组");
//        System.out.println(Arrays.toString(arr));
//
//        // 第三趟排序，就是将第三大的数排在倒数第三位
//        for (int j = 0; j < arr.length - 1 - 2; j++) {
//            //如果起那面的数比后面的数达，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第三趟数组");
//        System.out.println(Arrays.toString(arr));
//
//        // 第四趟排序，就是将第4大的数排在倒数第4位
//        for (int j = 0; j < arr.length - 1 - 2; j++) {
//            //如果起那面的数比后面的数达，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第四趟数组");
//        System.out.println(Arrays.toString(arr));

    }

    // 将前面额冒泡排序算法，封装成一个方法
    // 冒泡排序 的时间复杂度 O(n^2),
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;//标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第" + (i + 1) + "趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
            if (!flag) {//在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }

    }

}
