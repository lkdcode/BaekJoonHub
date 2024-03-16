class Solution {
    public int[] solution(String s) {
        
        int zeroCountByRemove = 0;
        int count = 0;

        while (true) {
            if (s.equals("1")) break;
            int zeroCount = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '0') zeroCount++;
            }

            zeroCountByRemove += zeroCount;
            s = Integer.toBinaryString(s.length() - zeroCount);
            count++;
        }
        
        return new int[]{count, zeroCountByRemove};
    }
}