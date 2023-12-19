import java.util.LinkedList;
import java.util.Queue;

public class Dota2 {

    // 貪心算法 + 隊列
    // 時間複雜度:O(n) 空間複雜度:O(n)
    public static String predictPartyVictory(String senate) {
        //
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int rPoll = r.poll();
            int dPoll = d.poll();
            if (rPoll < dPoll) {
                r.offer(rPoll + length); // 讓R進入下一輪，不能干擾本輪
            } else {
                d.offer(dPoll + length);
            }
        }
        return d.isEmpty() ? "R" : "D";
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));
    }

}
