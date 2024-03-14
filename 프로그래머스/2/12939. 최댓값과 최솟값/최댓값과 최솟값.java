import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int max = Arrays.stream(Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray())
            .max().getAsInt();

        int min = Arrays.stream(Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray())
            .min().getAsInt();
        return min + " " + max;
    }
}