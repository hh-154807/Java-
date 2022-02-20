package com.atguigu.sparsearray;

import com.sun.deploy.net.cookie.CookieUnavailableException;

import java.io.*;
import java.util.ArrayList;

/**
 * @ author He
 * @ create 2022-02-19 20:16
 * 1.二维数组与稀疏数组相互转换
 * 2.将稀疏数组存入硬盘和把硬盘中的稀疏数组恢复
 * */

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子，1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二位数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二位数组转稀疏数组
        //1 先遍历二维数组得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2,创建一个稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;//count用于记录是第几个非零数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出系数数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
            System.out.println();
        }
        System.out.println();

        //将稀疏数组恢复成二维数组
        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        //自己写的
//        for (int i = 0; i < sparseArray[0][2]; i++) {
//            chessArr2[sparseArray[i+1][0]][sparseArray[i+1][1]]=sparseArray[i+1][2];
//        }

        //老师写的
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组~~~~");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组保存到硬盘上
        File dest = new File("sparseArray.data");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(dest));
            for (int[] row : sparseArray) {
                for (int data : row) {
                    bw.write(data + "\t");
                }
                bw.write("\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //从硬盘中读取稀疏数组，并进行恢复
        //1.将硬盘中的数据储存到一个list中
        File dest1 = new File("sparseArray.data");
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(dest1));
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split("\t");
                for (int i = 0; i < str.length; i++) {
                    list.add(Integer.parseInt(str[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();

        //输出list数组
//        for (Integer data : list) {
//            System.out.print(data + "\t ");
//        }

        //2 用list中的数据创建稀疏数组
        int sparseArray2[][] = new int[list.get(2) + 1][3];
        int j=0;
        for (int i = 0; i < list.size(); i = i + 3) {
            sparseArray2[j][0]=list.get(i);
            sparseArray2[j][1]=list.get(i+1);
            sparseArray2[j][2]=list.get(i+2);
            j++;
        }
        System.out.println("从硬盘中读取的稀疏数组~~~~~~~");
        for (int i = 0; i < sparseArray2.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
            System.out.println();
        }
        System.out.println();

    }
}
