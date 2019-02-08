import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Speeding {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        LinkedList<Pair<Integer, Integer>> nSegments = new LinkedList<>();
        LinkedList<Pair<Integer, Integer>> mSegments =  new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int length = s.nextInt();
            int speed = s.nextInt();
            Pair<Integer, Integer> integerIntegerPair = new Pair<>(length, speed);
            nSegments.add(integerIntegerPair);
        }

        for (int i = 0; i < m; i++) {
            int length = s.nextInt();
            int speed = s.nextInt();
            Pair<Integer, Integer> integerIntegerPair = new Pair<>(length, speed);
            mSegments.add(integerIntegerPair);
        }

        int max=0;
        while(nSegments.size()!=0){
            max = Math.max(max, compareNext(nSegments, mSegments));
        }

        System.out.println(max);
    }

    public static Pair<Integer, Integer> compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
        int i = p1.getKey() < p2.getKey() ? 0 : (p1.getKey()==p2.getKey() ? 2 : 1);
        int diff = p2.getValue() - p1.getValue();
        return new Pair<>(i, diff);
    }

    static int compareNext(LinkedList<Pair<Integer, Integer>> n, LinkedList<Pair<Integer, Integer>> m) {
        Pair<Integer, Integer> nPoll = n.poll();
        Pair<Integer, Integer> mPoll = m.poll();
        Pair<Integer, Integer> compare = compare(nPoll, mPoll);
        if (compare.getKey() == 0) {
            Pair<Integer, Integer> pair = new Pair<>(mPoll.getKey() - nPoll.getKey(), mPoll.getValue());
            m.addFirst(pair);
        } else if (compare.getKey() == 1) {
            Pair<Integer, Integer> pair = new Pair<>(nPoll.getKey() - mPoll.getKey(), nPoll.getValue());
            n.addFirst(pair);
        }
        return compare.getValue();
    }


}

class Pair<T, K> {
    T a;
    K b;

    public Pair(T a, K b){
        this.a = a;
        this.b = b;
    }

    T getKey() {
        return a;
    }

    K getValue(){
        return b;
    }

}
