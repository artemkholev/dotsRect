package algorithms;

import auxiliary.Rect;

public class FirstAlgorithm {
    public static int findCountPoints(int x, int y) {
        int count = 0;
        for (int i = 0; i < Rect.groupRect.length; ++i) {
            int x1 = Rect.groupRect[i].lowPoint.x, y1 = Rect.groupRect[i].lowPoint.y;
            int x2 = Rect.groupRect[i].upPoint.x, y2 = Rect.groupRect[i].upPoint.y;
            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                count++;
            }
        }
        return count;
    }
}
