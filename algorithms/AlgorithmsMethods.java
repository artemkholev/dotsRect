package algorithms;
import auxiliary.Rect;
import auxiliary.TreePreparation;
import structures.Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgorithmsMethods {
    public enum AlgorithmsName {
        first, second, third
    }

    public static int binSearch (ArrayList<Integer> array, int key) {
        int l = 0, r = array.size() - 1;
        while (l + 1 != r) {
            int mid = (r + l) / 2;
            if (key < array.get(mid))
                r = mid;
            else
                l = mid;
        }
        return l;
    }

    public static void getRect(Scanner scanner) {
        int countRect = scanner.nextInt();
        Rect.groupRect = new Rect[countRect];

        for (int i = 0; i < Rect.groupRect.length; ++i) {
            int x1 = scanner.nextInt(),
                y1 = scanner.nextInt(),
                x2 = scanner.nextInt(),
                y2 = scanner.nextInt();
            Rect.groupRect[i] = new Rect(x1, y1, x2 - 1, y2 - 1);
            Rect.addCords(x1, y1, x2, y2);
        }
        Rect.sortXY();
    }

    private static void preparedDataAlgorithms(AlgorithmsName alg, Scanner in) {
        //save data rect for future actions
        if (alg.equals(AlgorithmsName.first)) {
            int countRect = in.nextInt();
            Rect.groupRect = new Rect[countRect];
            for (int i = 0; i < Rect.groupRect.length; ++i) {
                int x1 = in.nextInt(),
                    y1 = in.nextInt(),
                    x2 = in.nextInt(),
                    y2 = in.nextInt();
                Rect.groupRect[i] = new Rect(x1, y1, x2 - 1, y2 - 1);
            }
        } else if (alg.equals(AlgorithmsName.second)) {
            AlgorithmsMethods.getRect(in);
            Matrix.generateMatrix();
        } else if (alg.equals(AlgorithmsName.third)) {
            AlgorithmsMethods.getRect(in);
            TreePreparation.generateTreePreparation();
        }
    }

     public static String getPointWithCount (AlgorithmsName alg, String testData) {
        Scanner in = new Scanner(testData);
        String time = "";

        long startPrepared = System.nanoTime();
        preparedDataAlgorithms(alg, in);//if it is second or third algorithm need to prepare data for find count
        time += String.valueOf(System.nanoTime() - startPrepared);

        int count = in.nextInt();
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            int x = in.nextInt(),
                y = in.nextInt();
            int countRect = 0;
            if (alg.equals(AlgorithmsName.first)) {
                countRect = FirstAlgorithm.findCountPoints(x, y);
            } else if (alg.equals(AlgorithmsName.second)) {
                countRect = SecondAlgorithm.findCountPoints(x, y);
            } else {
                countRect = TreePreparation.getQuantity(x, y);
            }
//            System.out.print(countRect + " ");
        }
        time += (" " + String.valueOf(System.nanoTime() - start));
//        System.out.println();
        return time;
    }
}
