public class LC44_BestTimeToBuyAndSellStock {


    // Naive approach
    public int maxProfitSolution(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (profit < prices[j] - prices[i]) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }

    public int maxProfitSolution2 (int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    public int maxProfitSolution3(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        // higtest profit in 0~i
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }
}
