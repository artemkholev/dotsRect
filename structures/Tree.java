package structures;
import auxiliary.Granters;
import java.util.ArrayList;
import java.util.HashMap;

public class Tree {
    public static HashMap<Integer, Tree> storage = new HashMap<>();
    public int indStart, indEnd, v, modifier;
    public Tree left, right;

    Tree (Tree elemTree) {
        v = elemTree.v;
        modifier = elemTree.modifier;
        indStart = elemTree.indStart;
        indEnd = elemTree.indEnd;
        left = elemTree.left;
        right = elemTree.right;
    }

    Tree (int start, int end) {
        this.left = this.right = null;
        this.modifier = this.v = 0;
        this.indStart = start;
        this.indEnd = end;
    }

    public static Tree generateTree(int start, int end) {
        if (start == end)
            return new Tree(start, end);
        int mid = (start + end) / 2;
        Tree left = generateTree(start, mid);
        Tree right = generateTree(mid + 1, end);
        Tree root = new Tree(left.indStart, right.indEnd);
        root.left = left;
        root.right = right;
        return root;
    }
    public static void editTree (ArrayList<Granters> granters) {
        int lastState = -1;
        for (Granters elem : granters) {
            int modifier;
            if (elem.start) modifier = 1;
            else modifier = -1;
            storage.put(elem.x, putValueTree(storage.get(lastState), elem.y1, elem.y2, modifier));
            lastState = elem.x;
        }
    }

    private static Tree putValueTree (Tree root, int start, int end, int v) {
        if (start > root.indEnd || end < root.indStart) { return root; }
        Tree newTree = new Tree(root);

        if (start <= root.indStart && end >= root.indEnd) {
            if (newTree.left != null || newTree.right != null) { newTree.modifier += v; }
            else { newTree.v += v; }
        } else {
            newTree.left = putValueTree(root.left, start, end, v);
            newTree.right = putValueTree(root.right, start, end, v);
        }
        return newTree;
    }
}

