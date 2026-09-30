import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;
        int m = h1.size();
        int n = h2.size();
        int k = h3.size();
        if (m==0 || n==0 || k==0) return 0;
        
        for (int i=0; i<m; i++) sum1+=(long)h1.get(i);
        
        for (int i=0; i<n; i++) sum2+=(long)h2.get(i);
        
        for (int i=0; i<k ; i++) sum3+=(long)h3.get(i);
        
        int i = 0;
        int j=0;
        int t=0;

        while (i<m && j<n && t<k){
            if ( sum1 == sum2 && sum2==sum3) return (int) sum1;
            
            if (sum1>=sum2 && sum1>=sum3){ sum1-=(long)h1.get(i); i++;}
            else if (sum2>=sum1 && sum2>=sum3) {sum2-=(long)h2.get(j); j++;}
            else {sum3-=(long)h3.get(t); t++;}
        }
        return 0;
    }   

}

public class EqualStacks{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
