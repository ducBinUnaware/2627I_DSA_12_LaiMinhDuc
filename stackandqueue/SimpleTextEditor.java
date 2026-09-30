import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SimpleTextEditor {
    StringBuffer str=new StringBuffer("");
    Stack<StringBuffer> st1=new Stack<>();
    int q;

    void append(String w){
        st1.push(new StringBuffer(str));
        str.append(w);
    }

    void delete(int k){
        st1.push(new StringBuffer(str));
        str.delete(str.length()-k, str.length());
    }


    void printK(int k){
        System.out.println(str.charAt(k-1));
    }

    void undo(){
        if (!st1.isEmpty()) str=new StringBuffer(st1.pop());
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
            if (type==1) append(st.nextToken());
            else if (type==2) delete(Integer.parseInt(st.nextToken()));
            else if (type==3) printK(Integer.parseInt(st.nextToken()));
            else undo();
        }
        }   
        catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        SimpleTextEditor s= new SimpleTextEditor();
        s.nhap();
    }  
}
