import java.util.*;
public class Main{
    public static void main(String[] args){
        int a,b;
        Scanner scan = new Scanner(System.in);
        
        a = scan.nextInt();
        b = scan.nextInt();
        
        if (a>b) {
            System.out.print(">");
        }
        else if (a<b)
        {
            System.out.print("<");
        }
        else
        {
            System.out.print("==");
        }
            
    }
}