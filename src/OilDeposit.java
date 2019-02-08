import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OilDeposit {

    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream(new File("src/problemSets/OilDeposits/testcases/000_sample.in")));
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        do{
            Region r = new Region(n, m);
            for(int i=0;i<m;++i){
                String line = s.next();
                for(int j=0;j<n;++j){
                    char c = line.charAt(j);
                    if(c=='@'){
                        r.data[j][i] = 1;
                    }
                }
            }
            r.findOil();
            System.out.println(r.oilCount);

            m = s.nextInt();
            n = s.nextInt();
        } while(m!=0);
    }
}
class Region{
    int[][] data;
    int oilCount;

    public Region(int m, int n){
        data = new int[m][n];
    }

    public void findOil(){
        for(int px=0;px<data.length;++px){
            for(int py=0; py<data[0].length; ++py){
                int val = data[px][py];

                if(val==1){
                    ++oilCount;
                    expand(px, py);
                }
            }
        }
    }

    public void expand(int x, int y){
        data[x][y] = 0;
        for(int i = Math.max(0, x-1); i<= Math.min(x+1, data.length-1);++i){
            for(int j = Math.max(0, y-1); j<= Math.min(y+1, data[0].length-1);++j){
                if((i!=x || j!=y) && data[i][j]==1){
                    expand(i, j);
                }
            }
        }
    }
}