import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class files {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        PriorityQueue<Integer> worker = new PriorityQueue<>();


        for (int i = 0 ; i < n ; i++)
            worker.offer(0);

        List<Integer> finalResults = new ArrayList<>(m);

        for (int i = 0 ; i < m ; i++)
        {
            int time = scanner.nextInt();
            int size = scanner.nextInt();
            int avalTime = worker.poll();
            int activationTime = Math.max(avalTime , time);
            int deadline = activationTime + size;
            worker.offer(deadline);

            finalResults.add(deadline);
        }

        scanner.close();
        for (int res : finalResults)
        {
            System.out.println(res);
        }

    }
}
