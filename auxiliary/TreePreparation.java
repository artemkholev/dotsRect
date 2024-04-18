package auxiliary;

import structures.Edge;
import structures.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TreePreparation {
    static Tree tree = null;
    static ArrayList<Integer> xElems = new ArrayList<>();
    static ArrayList<Integer> yElems = new ArrayList<>();

    public static int binSearch(Integer num, List<Integer> array){
        int left = 0;
        int right = array.size();

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (array.get(mid) <= num)
                left = ++mid;
            else
                right = mid;
        }
        return --left;
    }

    public static void addCordX(int xCord) {
        if (!xElems.contains(xCord))
            xElems.add(xCord);
    }
    public static void addCordY(int yCord) {
        if (!yElems.contains(yCord))
            yElems.add(yCord);
    }

    public static void addEdges(List<Edge> edges, int x, int y1, int y2, boolean start) {
        Edge newEdge = new Edge(binSearch(x, xElems), binSearch(y1, yElems), binSearch(y2, yElems), start);
        edges.add(newEdge);
    }

    public static void generateTreePreparation () {
        if (Rect.groupRect.length == 0) return;

        for (Rect rect : Rect.groupRect) {
            addCordX(rect.lowPoint.x);
            addCordX(rect.upPoint.x + 1);
            addCordY(rect.lowPoint.y);
            addCordY(rect.upPoint.y + 1);
        }
        Collections.sort(xElems);
        Collections.sort(yElems);

        List<Edge> edges = new ArrayList<>();


        for (Rect rect : Rect.groupRect) {
            addEdges(edges, rect.lowPoint.x, rect.lowPoint.y, rect.upPoint.y + 1, true);
            addEdges(edges, rect.upPoint.x + 1, rect.lowPoint.y, rect.upPoint.y + 1, false);
        }
        edges.sort(new EdgesComparator());
        tree = new Tree(edges, yElems.size());
    }

    public static class EdgesComparator implements Comparator<Edge> {
        public int compare(Edge firstEdge, Edge secondEdge) {
            return firstEdge.pos - secondEdge.pos;
        }
    }

    public static int getQuantity(int x, int y){
        if (xElems.isEmpty())
            return 0;
        int xCompress = binSearch(x, xElems),
                yCompress = binSearch(y, yElems);
        if (xCompress == -1 || yCompress == -1 || tree.storageHistoryTree.size() <= xCompress)
            return 0;
        return tree.findPosInTree(xCompress, yCompress);
    }
}
