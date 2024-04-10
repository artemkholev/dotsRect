import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;

public class TastData {
    private static List<Integer> p = new ArrayList<>();

    TastData () {
        p = primeNumbers(100);
    }

    public static List<Integer> primeNumbers(int n) {
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 3; i <= n; i += 2) {
            if (isPrime(i))
                primeNumbers.add(i);
        }
        return primeNumbers;
    }
    private static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static long modPow(long base, long exponent, long modulus) {
        long result = 1;
        base %= modulus;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % modulus;
            }
            exponent >>= 1;
            base = (base * base) % modulus;
        }
        return result;
    }

    public String getTestData(int n) {
        Random random = new Random();
        String testData = n + "\n";
        for (int i = 0; i < n; i++)
            testData += ((10 * i) + " " + (10 * i) + " " + (10 * (2 * n - i)) + " " + (10 * (2 * n - i)) + "\n");
        testData += n + "\n";
        for (int i = 0; i < n; i++) {
            int pSize = p.size();
            int randKeyOne = p.get(random.nextInt(pSize));
            int randKeyTwo = p.get(random.nextInt(pSize));
            int x = (int)modPow((long) randKeyOne * i, 31, 20L * n);
            int y = (int)modPow((long) randKeyTwo * i, 31, 20L * n);
            testData += (x + " " + y + "\n");
        }
        return testData;
    }
}
