package auxiliary;

import java.util.ArrayList;
import java.util.Collections;

public class Rect {
    public static Rect[] groupRect;
    public static ArrayList<Integer> xElems = new ArrayList<>();
    public static ArrayList<Integer> yElems = new ArrayList<>();
    public Point lowPoint;
    public Point upPoint;

    public Rect(int x1, int y1, int x2, int y2) {
        lowPoint = new Point(x1, y1);
        upPoint = new Point(x2, y2);
    }

    public static void sortXY() {
        Collections.sort(xElems);
        Collections.sort(yElems);
    }

    public static int getLengthXElems() {
        return xElems.size();
    }

    public static int getLengthYElems() {
        return yElems.size();
    }

    public static void addCords(int x1, int y1, int x2, int y2) {
        addCordX(x1);
        addCordY(y1);
        addCordX(x2);
        addCordY(y2);
        addCordX(x2 + 1);
        addCordY(y2 + 1);
    }
    public static void addCordX (int xCord) {if (!xElems.contains(xCord)) xElems.add(xCord);}
    public static void addCordY (int yCord) {if (!yElems.contains(yCord)) yElems.add(yCord);}
}