package algorithms;

import auxiliary.Rect;
import structures.Matrix;

public class SecondAlgorithm {
    public static int findCountPoints(int x, int y) {
        int indX = AlgorithmsMethods.binSearch(Rect.xElems, x);
        int indY = AlgorithmsMethods.binSearch(Rect.yElems, y);
        return Matrix.matrix[indX][indY];
    }
}
