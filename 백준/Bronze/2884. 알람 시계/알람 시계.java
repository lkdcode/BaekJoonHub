import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        if(b>=45) System.out.printf("%d %d",a,b-45);
        else if(a==0 && b>=45) System.out.printf("%d %d",23,b-45);
        else if(a==0 && b<=45) System.out.printf("%d %d",23,15+b);
        else System.out.printf("%d %d",a-1,15+b);  
    }
}