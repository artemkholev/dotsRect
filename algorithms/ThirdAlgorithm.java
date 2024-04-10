package algorithms;

import auxiliary.Rect;
import structures.Tree;

import java.util.ArrayList;

public class ThirdAlgorithm {
    public static int getCountIntersection(int x , int y) {
        if (x > Rect.xElems.get(Rect.xElems.size() - 1) ||
            y > Rect.yElems.get(Rect.yElems.size() - 1))
            return 0;

        int indX = AlgorithmsMethods.binSearch(Rect.xElems, x),
            indY = AlgorithmsMethods.binSearch(Rect.yElems, y);

//        ArrayList<Integer> elemsXStorage = new ArrayList<>(Tree.storage.keySet());
//        int posInStorage = AlgorithmsMethods.binSearch(elemsXStorage, indX);
//        int keyPosTree = elemsXStorage.get(posInStorage);
        return getResult(Tree.storage.get(indX), indY, 0);
    }

    public static int getResult (Tree tree, int y, int count) {
        if (tree.left == null && tree.right == null) return tree.v + count;
        else {
            if (y >= tree.left.indStart && y <= tree.left.indEnd) { count += getResult(tree.left, y, count); }
            else { count += getResult(tree.right, y, count); }
        }
        return count + tree.modifier;
    }

    public static int findCountPoints(int x, int y) {
        return getCountIntersection(x, y);
    }
}
