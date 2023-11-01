import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < a.length(); i++) {
            char check = a.charAt(i);
            
            if (check >= 'A' 
               && check <= 'Z') {
                sb.append(String.valueOf(check).toLowerCase());
            } else {
                sb.append(String.valueOf(check).toUpperCase());
            }
   
        }
        
        System.out.println(sb);
    }
}