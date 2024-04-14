class Solution {
    public int[] solution(int[] prices) {
           int result[] = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int second = 0;
            for (int j = i + 1; j < prices.length; j++) {
                second++;
                int nextPrice = prices[j];
                if (price > nextPrice) {
                    break;
                }
            }
            result[i] += second;
        }
        
        return result;
    }
}