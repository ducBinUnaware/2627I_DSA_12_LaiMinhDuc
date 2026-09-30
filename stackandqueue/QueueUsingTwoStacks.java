import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class QueueUsingTwoStacks {
    Stack<Integer> st1=new Stack<>();
    Stack<Integer> st2=new Stack<>();
    int q;

    void enqueue(int x){
        if (st1.isEmpty() && st2.isEmpty()){
             st2.push(x);
             return;
        } 
        st1.push(x);
    }

    void dequeue(){
        if (st2.size() <=1){
            if (!st2.isEmpty()) st2.pop();
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        else {
            st2.pop();
        }

    }

    int top(){
        return st2.peek();
    }


    void nhap(){
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String line=br.readLine();
            if (line==null) return;
            StringTokenizer st=new StringTokenizer(line);
            
        q=Integer.parseInt(st.nextToken());
        for (int i=0; i<q; i++){
            line=br.readLine();
            if (line==null) break;
            st=new StringTokenizer(line);
            int type= Integer.parseInt(st.nextToken());
            if (type==1) enqueue(Integer.parseInt(st.nextToken()));
            else if (type==2) dequeue();
            else System.out.println(top());
        }
        }   
        catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks s= new QueueUsingTwoStacks();
        s.nhap();
    }  
}

