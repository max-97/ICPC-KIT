import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Bicoloring {

    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream(new File("src/problemSets/bicoloring/testcases/001_sample.in")));
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node());
        }

        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            Node nA = nodes.get(a);
            Node nB = nodes.get(b);

            nA.addNeighbor(nB);
            nB.addNeighbor(nA);
        }

        Node start = nodes.get(0);
        LinkedList<Node> openSet = new LinkedList<>();
        openSet.add(start);
        start.setColor(1);

        while(!openSet.isEmpty()) {
            Node nextNode = openSet.poll();
            int nextColor = (nextNode.getColor() + 1) % 2;
            HashSet<Node> neighbors = nextNode.getNeighbors();
            for (Node neighbor : neighbors) {
                if (neighbor.getColor() == -1) {
                    neighbor.setColor(nextColor);
                    openSet.add(neighbor);
                } else if (neighbor.getColor() != nextColor){
                    System.out.println("NOT BICOLORABLE.");
                    return;
                }
            }
        }
        System.out.println("BICOLORABLE.");
    }
}

class Node {
    HashSet<Node> neighbors;
    int color;

    public Node() {
        color = -1;
        neighbors = new HashSet<>();
    }

    public void addNeighbor(Node n) {
        neighbors.add(n);
    }

    public HashSet<Node> getNeighbors() {
        return neighbors;
    }

    void setColor(int i) {
        color = i;
    }

    int getColor() {
        return color;
    }
}