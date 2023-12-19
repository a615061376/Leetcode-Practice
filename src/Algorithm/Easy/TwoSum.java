package Algorithm.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] solution(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : numbers) {
            int complement = target - numbers[i];

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No solution!");

    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(solution(array, 6)));
    }
}
