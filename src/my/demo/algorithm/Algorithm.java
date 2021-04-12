package my.demo.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Algorithm
 *
 * @author xuzhou
 * @version 1.0.0
 * @date 2021/4/12 9:35
 */
public class Algorithm {


    private static final int COUNT = 1024;

    private static final int NUM = 10;


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        System.out.println("开始计算：");

        int[][] end = new int[COUNT][COUNT];
        ArrayList<int[][]> list = new ArrayList<>();
        String path = "C:\\Users\\lenovo\\Desktop\\编程竞赛题目说明\\data";
        String pathEnd = path + "/1204_end.txt";
        for(int i = 0;i<NUM;i++){
            String path1 = path+"/1024_" +i + ".txt";
            list.add(bufferReader(path1));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("读取10个文件用时：" + (endTime-startTime));


        long start = System.currentTimeMillis();

        compute(list.get(0), list.get(1), end);
//        compute2(list.get(0), list.get(1), end);

        endTime = System.currentTimeMillis();
        System.out.println("0，1文件计算用时：" + (endTime-start));


        for (int i = 2; i<NUM; i++){
            start = System.currentTimeMillis();

            compute(end, list.get(i), end);
//            compute2(end, list.get(i), end);

            endTime = System.currentTimeMillis();
            System.out.println("第" + i +"个文件计算用时：" + (endTime-start));
        }

        start = System.currentTimeMillis();

        printWrite(pathEnd, end);

        endTime = System.currentTimeMillis();
        System.out.println("输出文件用时：" + (endTime-start));

        System.out.println("完成计算");
        System.out.println("共用时：" + (endTime-startTime));

    }

    /**
     * 数组相乘
     * @param a 数组a
     * @param b 数组b
     * @param end 乘积结果
     */
    private static void compute(int[][] a, int[][] b, int[][] end){
        for(int i =0; i<COUNT; i++){
            for(int j=0; j<COUNT; j++){
                int count = 0;
                for(int k = 0; k<COUNT; k++){
                    count += a[i][k] * b[k][j];
                }
                end[i][j] = count;
            }
        }

    }
    /**
     * 数组相乘
     * @param a 数组a
     * @param b 数组b
     * @param end 乘积结果
     */
    private static void compute2(int[][] a, int[][] b, int[][] end){
        for(int i =0; i<COUNT; i++){
            for(int k = 0; k<COUNT; k++){
                int s = a[i][k];
                for(int j=0; j<COUNT; j++){
                    end[i][j] += s * b[k][j];
                }

            }
        }
    }

    /**
     * 读取缓存流
     * @param path 文件路径
     */
    public static int[][] bufferReader(String path){
        int[][] result = new int[COUNT][COUNT];

        File file = new File(path);
        try (
                // create stream
                FileReader fr = new FileReader(file);
                // create bufferStream base on stream which is exists
                BufferedReader br = new BufferedReader(fr)
        ) {
            int i = 0;
            while (true){
                // read a line
                String lineStr = br.readLine();
                if (null == lineStr){
                    // when the line is null ,the process end
                    break;
                }

                int k = 0;
                String[] split = lineStr.split(",");
                for(String s : split){
                    if(s != null){
                        result[i][k++] = Integer.parseInt(s);
                    }
                }
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 缓存流写入
     * 没有是用flush，流写完才会写入到文件中
     * @param path 文件路径
     */
    public static void printWrite(final String path, int[][] end){
        File file = new File(path);

        try (
                // create stream
                FileWriter fw = new FileWriter(file);
                // create printWrite base on stream
                PrintWriter pw = new PrintWriter(fw)
        ) {
            for(int i=0;i<COUNT;i++){
                // print a line into file
                String s = Arrays.stream(end[i]).mapToObj(Integer::toString).collect(Collectors.joining(","));
                pw.println(s);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
