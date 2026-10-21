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
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int partition(List<Integer> arr,int l,int r){
        int pivot=arr.get(r);
        int i=l-1;
        for (int j=l; j<r; j++){
            if (arr.get(j) <= pivot){
                i++;
                Collections.swap(arr, i, j);
            }
        }
        i++;
        Collections.swap(arr,i,r);
        return i;
    }
    
    public static int findMedian(List<Integer> arr,int l,int r,int k) {
        if (l==r) return arr.get(k);
        int p=partition(arr, l, r);
        if (p==k) return arr.get(k);
        else if (p>k) return findMedian(arr, l, p-1, k);
        else return findMedian(arr, p+1, r, k);
    }

}

public class findTheMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.findMedian(arr,0,n-1,n/2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
