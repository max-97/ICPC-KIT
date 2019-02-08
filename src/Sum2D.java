import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sum2D {

    static int[][] values;
    static int[][] rects;

    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream(new File("src/problemSets/Sum2D/testcases/000_sample.in")));
        Scanner s = new Scanner(System.in);

        int w = s.nextInt();
        int h = s.nextInt();
        int q = s.nextInt();

        values = new int[w][h];
        rects = new int[q][4];

        for(int j = 0; j<h; ++j){
            for(int i=0;i<w;++i){
                if(i==0){
                    values[i][j] = j == 0 ? s.nextInt() : s.nextInt() + values[w-1][j-1];
                }
                else{
                    values[i][j] = s.nextInt() + values[i-1][j];
                }
            }
        }

        for(int i=0;i<q;++i) {
            for (int j = 0; j < 4; ++j) {
                rects[i][j] = s.nextInt() - 1;
            }
        }

        for(int i=0;i<q;++i){
            int xmin = Math.min(rects[i][0], rects[i][2]);
            int ymin = Math.min(rects[i][1], rects[i][3]);
            int xmax = Math.max(rects[i][0], rects[i][2]);
            int ymax = Math.max(rects[i][1], rects[i][3]);

            int sum=0;
            for(int y=ymin;y<=ymax;++y){
                if(xmin==0){
                    if(y!=0){
                        sum += values[xmax][y] - values[w-1][y-1];
                    }
                    else{
                        sum += values[xmax][y];
                    }
                }
                else{
                    sum += values[xmax][y] - values[xmin-1][y];
                }
            }

            System.out.println(sum);
        }
    }
}
