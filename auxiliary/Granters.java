package auxiliary;
import algorithms.AlgorithmsMethods;

import java.util.ArrayList;
import java.util.Comparator;

public class Granters {
    public static ArrayList<Granters> granters = new ArrayList<>();
    public int x;
    public int y1;
    public int y2;
    public boolean start;

    Granters(boolean start, int x, int y1, int y2) {
        this.x = AlgorithmsMethods.binSearch(Rect.xElems, x);
        this.y1 = AlgorithmsMethods.binSearch(Rect.yElems, y1);
        this.y2 = AlgorithmsMethods.binSearch(Rect.yElems, y2);
        this.start = start;
    }

    public static void fill() {
        for (Rect rectangle : Rect.groupRect) {
            granters.add(new Granters(true, rectangle.lowPoint.x, rectangle.lowPoint.y, rectangle.upPoint.y));
            granters.add(new Granters(false, rectangle.upPoint.x + 1, rectangle.lowPoint.y, rectangle.upPoint.y));
        }
        Granters.granters.sort(Comparator.comparingInt(o -> o.x));
    }
}
