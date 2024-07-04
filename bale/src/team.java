import java.util.*;

public class team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Map<Integer , Set<Integer>> g = new HashMap<>();

        for (int i = 0 ; i <= n ; i++)
            g.put(i , new HashSet<>());

        for (int i = 0 ; i < m ; i++)
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }

        scanner.close();

        List<List<Integer>> FinalTeams = new ArrayList<>();

        for (int i = 1 ; i <= n ; i++) {
            for (int j : g.get(i)) {
                for (int z : g.get(j)){
                    if(i < j && j < z && g.get(i).contains(z))
                    {
                        List<Integer> newTeam = Arrays.asList(i , j , z);
                        FinalTeams.add(newTeam);
                    }
                }
            }
        }
        FinalTeams.sort(Comparator.comparingInt(o -> o.get(0)));


        for (List<Integer> t : FinalTeams)
        {
            Collections.sort(t);
            for (int person : t)
            {
                System.out.print(person + " ");
            }
            System.out.println();

        }


    }
}
