import algorithms.AlgorithmsMethods;
import auxiliary.Rect;
import structures.Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    AlgorithmsMethods.getRect(in);
    //without preparation
    ArrayList<String> time =  AlgorithmsMethods.getPointWithCount(in, AlgorithmsMethods.AlgorithmsName.first);
    //with preparation
    Matrix.generateMatrix();
//    ArrayList<String> time = getPointWithCount(in, Algorithms.second);
    //with preparation
//    ArrayList<String> time = getPointWithCount(in, Algorithms.third);

//    TastData tests = new TastData();
//    tests.countIteration = 20;
//    tests.count = 10;
//    for (int i = 0; i < tests.countIteration; i++) {
//      //param
//      tests.maxX = i * 1000L;
//      tests.maxY = i * 1000L;
//      tests.width = i * 10L;
//      tests.high = i * 10L;
//
//      //generate tests
//      tests.generateRect();
//      tests.generatePoints();
//
//      //start algorithms
//      long process = TimeWork.measureTime(() -> { startAlgorithms(); });
//      time.add(tests.getmaxCordX() + " " + tests.getmaxCordY() + ", " + process);
//    }
    for (String s : time) {
        System.out.println(s);
    }
    in.close();
  }
}

/*
4
2 2 6 8
5 4 9 10
4 0 11 6
8 2 12 12
6
2 2 -> 1
12 12 -> 0
10 4 -> 2
5 5 -> 3
2 10 -> 0
2 8 -> 0
*/
