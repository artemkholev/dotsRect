package structures;

import algorithms.AlgorithmsMethods;
import auxiliary.Rect;

public class Matrix {
    public static int[][] matrix;

    public static void generateMatrix() {
        matrix = new int[Rect.getLengthXElems()][Rect.getLengthYElems()];
        for (Rect rectangle : Rect.groupRect) {
            int indX1 = AlgorithmsMethods.binSearch(Rect.xElems,  rectangle.lowPoint.x);
            int indY1 = AlgorithmsMethods.binSearch(Rect.xElems,  rectangle.lowPoint.y);
            int indX2 = AlgorithmsMethods.binSearch(Rect.xElems,  rectangle.upPoint.x);
            int indY2 = AlgorithmsMethods.binSearch(Rect.xElems,  rectangle.upPoint.y);
        }
    }
}
