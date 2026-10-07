import java.io.*;
import java.util.*;
class Student {
    public Integer id;
    public String name;
    public Double gpa;
    
    public Student(int id, String name,double gpa){
        this.id=id;
        this.name=name;
        this.gpa=gpa;
    }
    
    public void getName(){
        System.out.println(name);
    }
}

class StudentCoparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        if(Double.compare(s1.gpa, s2.gpa)==0){
            if(s1.name.compareTo(s2.name)==0){
                return Integer.compare(s1.id, s2.id);
            }
            return s1.name.compareTo(s2.name);
        }
        return Double.compare(s2.gpa, s1.gpa);
    }
}
public class JAVASORTSolution {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n =Integer.parseInt(st.nextToken());
        List<Student> students = new ArrayList<>();
        for (int i=0; i<n;i++){
            st = new StringTokenizer(bf.readLine());
            students.add(new Student(Integer.parseInt(st.nextToken()), st.nextToken(), Double.parseDouble(st.nextToken())));
        }
        Collections.sort(students, new StudentCoparator());
        
        students.forEach(s -> s.getName());
    }
}
