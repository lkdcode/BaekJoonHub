class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int numberOneCount = 0;
        for (int i = 0; i < binary.length(); i++) {
            char ch = binary.charAt(i);
            if (ch == '1') numberOneCount++;
        }

        int index = 1;
        while (true) {
            int target = n + index++;
            String targetBinary = Integer.toBinaryString(target);
            int targetNumberOneCount = 0;
            for (int i = 0; i < targetBinary.length(); i++) {
                char ch = targetBinary.charAt(i);
                if (ch == '1') targetNumberOneCount++;
            }
            if (numberOneCount == targetNumberOneCount) {
                return target;
            }
        }
    }
}