package structures;

public class Edge {
    public int pos;
    int left, right;
    boolean start;
    public Edge(int pos, int left, int right, boolean start) {
        this.pos = pos;
        this.left = left;
        this.right = right;
        this.start = start;
    }
}
