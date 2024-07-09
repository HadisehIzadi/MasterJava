import java.util.HashMap;
import java.util.Map;

public class mjority {
    private  static int findMajor(int[] nums)
    {
        HashMap<Integer , Integer> majMap = new HashMap<>();
        for (int num : nums)
        {
            majMap.put(num , majMap.getOrDefault(num , 0) +1);

        }
        int MinRes = -2;
        int counMax = 0;

        for (Map.Entry<Integer , Integer> e :
                majMap.entrySet() ) {
            if(e.getValue() > counMax)
            {
                counMax = e.getValue();
                MinRes = e.getKey();

            }

        }

        if(counMax >= (nums.length/2) )
            return MinRes;
        else
            return -2;
    }

    public static void main(String[] args)
    {
        int nums[] = {2, 1, 1, 3, 2, 1, 1};
        int res = findMajor(nums);
        System.out.println("result : " + res);
    }
}
