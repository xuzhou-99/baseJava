package my.demo.algorithm;

import java.util.List;

/**
 * CalclateThread
 *
 * @author xuzhou
 * @version 1.0.0
 * @date 2021/4/13 23:48
 */
public class CalclateThread extends Thread{
    static List<int[][]> list;
    private int[][] a;
    private int[][] b;

    private int index;

    public CalclateThread(int[][] a, int[][] b, int index) {
        this.a = a;
        this.b = b;
        this.index = index;
    }

    @Override
    public void run() {
        list.add(new int[1024][1024]);
        int[][] end = new int[1024][1024];
        for(int i =0; i<1024; i++){
            for(int j=0; j<1024; j++){
                int count = 0;
                for(int k = 0; k<1024; k++){
                    count += a[i][k] * b[i][k];
                }
                end[i][j] = count;
            }
        }
        list.add(index, end);
    }
}
