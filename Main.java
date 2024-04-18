import algorithms.AlgorithmsMethods;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String time = "";
    TastData data = new TastData();

    for (int n = 1; n < 10000; n+=100) {
      String testData = data.getTestData(n);
      //first algorithm
      //time = n + " " + AlgorithmsMethods.getPointWithCount(AlgorithmsMethods.AlgorithmsName.first, testData);

      //second algorithm
      //time = n + " " + AlgorithmsMethods.getPointWithCount(AlgorithmsMethods.AlgorithmsName.second, testData);

      //third algorithm
      time = n + " " + AlgorithmsMethods.getPointWithCount(AlgorithmsMethods.AlgorithmsName.third, testData);
      System.out.println(time);
    }
  }
}

/*
4
2 2 6 8
5 4 9 10
4 0 11 6
8 2 12 12
6
2 2
12 12
10 4
5 5
2 10
2 8
*/

