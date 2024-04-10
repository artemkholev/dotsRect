package structures;

import algorithms.AlgorithmsMethods;
import auxiliary.Rect;

import java.util.Arrays;

public class Matrix {
    public static int[][] matrix;

    public static void generateMatrix() {
        matrix = new int[Rect.getLengthXElems()][Rect.getLengthYElems()];

        for (int[] row : matrix) {
            Arrays.fill(row, 0);
        }

        for (Rect rectangle : Rect.groupRect) {
            int indX1 = AlgorithmsMethods.binSearch(Rect.xElems,  rectangle.lowPoint.x);
            int indY1 = AlgorithmsMethods.binSearch(Rect.xElems,  rectangle.lowPoint.y);
            int indX2 = AlgorithmsMethods.binSearch(Rect.xElems,  rectangle.upPoint.x);
            int indY2 = AlgorithmsMethods.binSearch(Rect.xElems,  rectangle.upPoint.y);

            for (int x = indX1; x <= indX2; x++) {
                for (int y = indY1; y <= indY2; y++) {
                    matrix[x][y]++;
                }
            }
        }


    }
}
