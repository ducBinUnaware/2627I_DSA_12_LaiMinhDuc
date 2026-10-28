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
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> res = new ArrayList<Double>();
        PriorityQueue<Integer> r = new PriorityQueue<>();
        PriorityQueue<Integer> l = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i< a.size(); i++){
            if (l.isEmpty()) l.add(a.get(i));
            else{
                if (i%2!=0){
                    if (a.get(i)>l.peek()) r.add(a.get(i));
                    else {
                        l.add(a.get(i));
                        r.add(l.poll());
                    }
                }
                else {
                    if(!r.isEmpty()){
                        if ( a.get(i)<r.peek()) l.add(a.get(i));
                        else {
                            r.add(a.get(i));
                            l.add(r.poll());
                        }
                    }
                }
            }
            
            if (i%2==0) res.add((double)l.peek());
            else res.add((double) (l.peek()+r.peek())/2);
        }
    return res;
    }

}


public class findtherunningmedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
