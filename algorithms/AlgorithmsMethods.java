package algorithms;
import auxiliary.Rect;
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
            Rect.addCords(x1, y1, x2 - 1, y2 - 1);
        }
        Rect.sortXY();
    }

     public static ArrayList<String> getPointWithCount (Scanner scanner, AlgorithmsName alg) {
        ArrayList<String> timeData = new ArrayList<>();
        int count = scanner.nextInt();
        for (int i = 0; i < count; ++i) {
            int x = scanner.nextInt(),
                    y = scanner.nextInt();
            int countRect = 0;
            long start = System.nanoTime();
            if (alg.equals(AlgorithmsName.first)) {
                countRect = FirstAlgorithm.findCountPoints(x, y);
            } else if (alg.equals(AlgorithmsName.second)) {
                countRect = SecondAlgorithm.findCountPoints(x, y);
            } else {
                countRect = ThirdAlgorithm.findCountPoints(x, y);
            }
            timeData.add(String.valueOf(System.nanoTime() - start));
            System.out.print(countRect + " ");
        }
        System.out.println();
        return timeData;
    }
}
