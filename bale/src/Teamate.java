import java.util.*;

public class Teamate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // تعداد افراد
        int m = scanner.nextInt(); // تعداد ارتباطات

        // ایجاد گراف برای ذخیره تعاملات
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        scanner.close();

        List<List<Integer>> teams = new ArrayList<>();

        // پیدا کردن تمام ترکیب های ممکن سه نفره
        for (int i = 1; i <= n; i++) {
            for (int j : graph.get(i)) {
                for (int k : graph.get(j)) {
                    if (i < j && j < k && graph.get(i).contains(k)) {
                        List<Integer> team = Arrays.asList(i, j, k);
                        teams.add(team);
                    }
                }
            }
        }

        // مرتب سازی تیم ها بر اساس عضو اول
        teams.sort(Comparator.comparingInt(o -> o.get(0)));

        // چاپ تیم ها
        for (List<Integer> team : teams) {
            Collections.sort(team);
            for (int member : team) {
                System.out.print(member + " ");
            }
            System.out.println();
        }
    }
}
