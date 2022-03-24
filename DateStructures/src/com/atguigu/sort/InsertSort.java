package com.atguigu.sort;

/**
 * @ author He
 * @ create 2022-03-18 20:16
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//S生成 [0-8000000) 数
        }

        long start = System.currentTimeMillis();

        insertSort(arr);

        long end = System.currentTimeMillis();//0.0645  //80W 49.662

        System.out.println("排序花费的时间"+(end-start));

    }

    //插入排序
    public static void insertSort(int[] arr){
        int insertVal=0;
        int insertIndex=0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length ; i++) {
            insertVal=arr[i];
            insertIndex =i-1;//即arr[1]的前面这个数的下标

            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到, insertIndex + 1
            //举例：理解不了，我们一会 debug
            //判断是否需要重置
            if(insertIndex+1==i){
                arr[insertIndex+1]=insertVal;
            }

//            System.out.println("第"+i+"轮插入后");
//            System.out.println(Arrays.toString(arr));
        }




        //使用逐步推到的方式来讲解，便于来理解

        //第1轮 {101, 34, 119, 1};  => {34, 101, 119, 1}

        //{101, 34, 119, 1}; => {101,101,119,1}
//        //定义待插入的数
//        int insertVal=arr[1];
//        int insertIndex=1-1;//即arr[1]的前面这个数的下标
//
//        //给insertVal 找到插入的位置
//        //说明
//        //1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
//        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
//        //3. 就需要将 arr[insertIndex] 后移
//        while (insertIndex>=0 && insertVal<arr[insertIndex]){
//            arr[insertIndex+1]=arr[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到, insertIndex + 1
//        //举例：理解不了，我们一会 debug
//        arr[insertIndex+1]=insertVal;
//        System.out.println("第一轮插入后");
//        System.out.println(Arrays.toString(arr));
//
//        //第二轮
//        //定义待插入的数
//        insertVal=arr[2];
//        insertIndex=2-1;//即arr[2]的前面这个数的下标
//
//        //给insertVal 找到插入的位置
//        //说明
//        //1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
//        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
//        //3. 就需要将 arr[insertIndex] 后移
//        while (insertIndex>=0 && insertVal<arr[insertIndex]){
//            arr[insertIndex+1]=arr[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到, insertIndex + 1
//        //举例：理解不了，我们一会 debug
//        arr[insertIndex+1]=insertVal;
//        System.out.println("第二轮插入后");
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮
//        //定义待插入的数
//        insertVal=arr[3];
//        insertIndex=3-1;//即arr[3]的前面这个数的下标
//
//        //给insertVal 找到插入的位置
//        //说明
//        //1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
//        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
//        //3. 就需要将 arr[insertIndex] 后移
//        while (insertIndex>=0 && insertVal<arr[insertIndex]){
//            arr[insertIndex+1]=arr[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到, insertIndex + 1
//        //举例：理解不了，我们一会 debug
//        arr[insertIndex+1]=insertVal;
//        System.out.println("第二轮插入后");
//        System.out.println(Arrays.toString(arr));
    }
}
