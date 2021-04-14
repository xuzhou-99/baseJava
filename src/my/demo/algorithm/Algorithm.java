package my.demo.algorithm;

import java.io.*;
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
        String path = "C:\\Users\\xuzhou\\Desktop\\编程竞赛题目说明\\data";
//        test1(path);
        test2(path);

    }

    private static void test1(String path){

        long startTime = System.currentTimeMillis();
        System.out.println("开始计算：");

        int[][] end;
        ArrayList<int[][]> list = new ArrayList<>();

        String pathEnd = path + "/1204_end1.txt";
        for(int i = 0;i<NUM;i++){
            String path1 = path+"/1024_" +i + ".txt";
            list.add(bufferReader(path1));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("读取10个文件用时：" + (endTime-startTime));


        long start = System.currentTimeMillis();

        end = compute(list.get(0), list.get(1));

        endTime = System.currentTimeMillis();
        System.out.println("1，2文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute(end, list.get(2));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (2+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);
        start = System.currentTimeMillis();

        end = compute(end, list.get(3));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (3+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);

        start = System.currentTimeMillis();

        end = compute(end, list.get(4));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (4+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);

        start = System.currentTimeMillis();

        end = compute(end, list.get(5));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (5+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);

        start = System.currentTimeMillis();

        end = compute(end, list.get(6));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (6+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);

        start = System.currentTimeMillis();

        end = compute(end, list.get(7));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (7+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);

        start = System.currentTimeMillis();

        end = compute(end, list.get(8));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (8+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);

        start = System.currentTimeMillis();

        end = compute(end, list.get(9));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (9+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);



        start = System.currentTimeMillis();

        printWrite(pathEnd, end);

        endTime = System.currentTimeMillis();
        System.out.println("输出文件用时：" + (endTime-start));

        System.out.println("完成计算");
        System.out.println("共用时：" + (endTime-startTime));
    }

    private static void test2(String path){

        long startTime = System.currentTimeMillis();
        System.out.println("开始计算：");

        int[][] end;
        ArrayList<int[][]> list = new ArrayList<>();

        String pathEnd = path + "/1204_end2.txt";
        for(int i = 0;i<NUM;i++){
            String path1 = path+"/1024_" +i + ".txt";
            if(i==0){
                list.add(bufferReader(path1));
            }else {
                list.add(bufferReader2(path1));
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("读取10个文件用时：" + (endTime-startTime));


        end = list.get(0);

        long start = System.currentTimeMillis();

        end = compute2(end, list.get(1));

        endTime = System.currentTimeMillis();
        System.out.println("1，2文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute2(end, list.get(2));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (2+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute2(end, list.get(3));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (3+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute2(end, list.get(4));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (4+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute2(end, list.get(5));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (5+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute2(end, list.get(6));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (6+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute2(end, list.get(7));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (7+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute2(end, list.get(8));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (8+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


        start = System.currentTimeMillis();

        end = compute2(end, list.get(9));

        endTime = System.currentTimeMillis();
        System.out.println("第" + (9+1) +"个文件计算用时：" + (endTime-start));
        System.out.println(end[0][0]);


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
     */
    private static int[][] compute(int[][] a, int[][] b){
         int[][] result = new int[COUNT][COUNT];
        for(int i =0; i<COUNT; i++){
            for(int j=0; j<COUNT; j++){
                int count = 0;
                for(int k = 0; k<COUNT; k++){
                    count += a[i][k] * b[k][j];
                }
                result[i][j] = count;
            }
        }
        return result;

    }
    /**
     * 数组相乘
     * @param a 数组a
     * @param b 数组b
     */
    public static int[][] compute2(int[][] a, int[][] b){
        int[][] end = new int[COUNT][COUNT];
        for(int i =0; i<COUNT; i++){
            for(int j=0; j<COUNT; j++){
                int count = 0;
                for(int k = 0; k<COUNT; k++){
                    count += a[i][k] * b[j][k];
                }
                end[i][j] = count;
            }
        }
        return end;
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

                result[i++]= Arrays.stream(lineStr.split(",")).mapToInt(Integer::parseInt).toArray();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 读取缓存流
     * 列转行
     * @param path 文件路径
     */
    public static int[][] bufferReader2(String path){
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
                int[] split = Arrays.stream(lineStr.split(",")).mapToInt(Integer::parseInt).toArray();

                int k = 0;
                for(int s : split){
                    result[k++][i] = s;
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
