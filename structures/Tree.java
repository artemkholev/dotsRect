package structures;
import java.util.ArrayList;
import java.util.List;

class NodeTree {
    NodeTree left, right;
    int indStart, indEnd, val;
    NodeTree(NodeTree left, NodeTree right, int leftRange, int rightRange, int val) {
        this.left = left;
        this.right = right;
        this.indEnd = rightRange;
        this.indStart = leftRange;
        this.val = val;
    }
}

public class Tree {
    public List<NodeTree> storageHistoryTree = new ArrayList<>();

    public Tree(List<Edge> edges, int size) {
        NodeTree root = createEmptyTree(0, 0, size);
        int pos = edges.get(0).pos;
        for (Edge edge : edges) {
            if (pos != edge.pos) {
                storageHistoryTree.add(root);
                pos = edge.pos;
            }
            root = editTree(root, edge.left, edge.right, edge.start);
        }
    }

    public NodeTree createEmptyTree(int tmp, int left, int right) {
        if (right - left == 1)
            return new NodeTree(null, null, left, right, tmp);
        int mid = (left + right) / 2;
        NodeTree leftNode = createEmptyTree(tmp, left, mid),
                rightNode = createEmptyTree(tmp, mid, right);
        return new NodeTree(leftNode, rightNode, leftNode.indStart, rightNode.indEnd, leftNode.val + rightNode.val);
    }

    public NodeTree editTree(NodeTree root, int left, int right, boolean start) {
        int val = start ? 1 : -1;
        if (right >= root.indEnd && left <= root.indStart)
            return new NodeTree(root.left, root.right, root.indStart, root.indEnd, root.val + val);
        else if (right <= root.indStart || root.indEnd <= left)
            return root;
        NodeTree createNewChangeRoot = new NodeTree(root.left, root.right, root.indStart, root.indEnd, root.val);
        createNewChangeRoot.left = editTree(createNewChangeRoot.left, left, right, start);
        createNewChangeRoot.right = editTree(createNewChangeRoot.right, left, right, start);
        return createNewChangeRoot;
    }

    public int findPosInTree(int x, int y) {
        return runIntoTree(storageHistoryTree.get(x), y);
    }

    public int runIntoTree(NodeTree root, int pos) {
        if (root == null)
            return 0;
        int mid = (root.indStart + root.indEnd) / 2;
        if (pos < mid)
            return root.val + runIntoTree(root.left, pos);
        return root.val + runIntoTree(root.right, pos);
    }
}

