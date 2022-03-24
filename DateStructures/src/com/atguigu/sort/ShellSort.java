package com.atguigu.sort;

/**
 * @ author He
 * @ create 2022-03-20 10:30
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//S生成 [0-8000000) 数
        }

        long start = System.currentTimeMillis();

       // shellSort(arr);
        shellSort2(arr);

        long end = System.currentTimeMillis();//0.015  80w 0.111  800W //1.464  8000W //26.269

        System.out.println("排序花费的时间" + (end - start));
//        System.out.println(Arrays.toString(arr));
    }


    // 使用逐步推导的方式来编写希尔排序
    public static void shellSort(int[] arr) {
        int temp = 0;
//        int count=0;
        // 根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共gap组，每组个元素），步长是gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            count++;
//            System.out.println("希尔排序"+count+"轮情况=" + Arrays.toString(arr));
        }


//        //希尔排序第一轮
//        // 因为第1轮排序，是将10个数据分成了 5组
//        for (int i = 5; i < arr.length; i++) {
//            //遍历各组中所有的元素（共有五组，每组2个元素），步长是五
//            for (int j = i - 5; j >= 0; j -= 5) {
//                // 如果当前元素大于加上步长后的那个元素，说明交换
//                if (arr[j] > arr[j + 5]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序一轮情况=" + Arrays.toString(arr));
//
//        //希尔排序第二轮
//        // 因为第2轮排序，是将10个数据分成了 5/2=2组
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素（共有五组，每组2个元素），步长是2
//            for (int j = i - 2; j >= 0; j -= 2) {
//                // 如果当前元素大于加上步长后的那个元素，说明交换
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序二轮情况=" + Arrays.toString(arr));
//
//        //希尔排序第三轮
//        // 因为第3轮排序，是将10个数据分成了 2/2=1组
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有的元素（共有五组，每组2个元素），步长是2
//            for (int j = i - 1; j >= 0; j -= 1) {
//                // 如果当前元素大于加上步长后的那个元素，说明交换
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序三轮情况=" + Arrays.toString(arr));
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                //如果后一个数小于前一个数
                if (arr[j] < arr[j - gap]) {
                    //后一个数小于前一个数，把前一个数移到后一个数的位置
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动，一直前一个数移到后一个数的位置，直到位置确定
                        arr[j] = arr[j - gap];
                        //每次减一个步长
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j]=temp;
                }

            }


        }
    }


}




















