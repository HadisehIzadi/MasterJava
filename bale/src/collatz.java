import java.util.Scanner;
public class collatz {
    public static void main(String[] args) {



                Scanner scanner = new Scanner(System.in);

                long n = scanner.nextLong();

                int steps = collatzStepsCounter(n);

                System.out.println(steps);

                scanner.close();
            }

            public static int collatzStepsCounter(long n) {
                int stepsCount = 0;

                while (n != 1) {
                    if (n % 2 == 0) {
                        n /= 2;
                    } else {

                        n = n + 1;
                    }
                    stepsCount++;
                }
                return stepsCount;
            }



}
