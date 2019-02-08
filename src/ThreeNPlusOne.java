import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ThreeNPlusOne {

    static HashMap<Integer, Integer> colatzNumbers;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);

        int i = s.nextInt();
        int j = s.nextInt();
        colatzNumbers = new HashMap<>();

        int max = 0;
        for (int x = i; x <= j;++x){
            max = Math.max(max, calculateColatz(x));
        }
        System.out.println(max);
    }

    public static int calculateColatz(int n) {
        if (colatzNumbers.containsKey(n)) {
            return colatzNumbers.get(n);
        }

        if (n == 1)
            return 1;

        int m;
        if (n % 2 == 0) {
            m = calculateColatz(n / 2) + 1;
        } else {
            m = calculateColatz(3 * n + 1) + 1;
        }
        colatzNumbers.put(n, m);
        return m;
    }
}
