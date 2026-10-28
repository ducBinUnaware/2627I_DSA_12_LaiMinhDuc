import java.io.*;
import java.util.*;

public class javastringrevrese {
    
    public static boolean solve(String a){
        int i = 0;
        int j = a.length() - 1;
        while (i<=j){
            if (a.charAt(i) != a.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        if (solve(A)) System.out.print("Yes");
        else System.out.print("No");
    }
}



