import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue {
    List<Integer> heap;    

    public PriorityQueue(){
        heap = new ArrayList<>();
    }

    int get_node(int i){
        return (i-1)/2;
    }

    void heaptify_up(int i){
        int node = get_node(i);
        if (i > 0 && heap.get(i)<heap.get(node)){
            Collections.swap(heap, i, node);
            heaptify_up(node);
        }
    }

    void heaptify_down(int i){
        int node = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        int n = heap.size();

        if (left < n && heap.get(left) < heap.get(node)){
            node = left;
        }
        if (right < n && heap.get(right) < heap.get(node)){
            node = right;
        }

        if (node != i){
            Collections.swap(heap, i, node);

            heaptify_down(node);
        }
    }

    void insert(int k){
        heap.add(k);
        heaptify_up(heap.size()-1);
    }

    Integer pop(){
        if (heap.isEmpty()) return null;
        Collections.swap(heap, 0, heap.size()-1);
        int m = heap.remove(heap.size()-1);
        heaptify_down(0);
        return m;
    }
    
    Integer top(){
        if(!heap.isEmpty()) return heap.get(0);
        return null;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        List<Integer> numbers = new ArrayList<>(List.of(15, 5, 20, 1, 8, 10));

        numbers.forEach(i -> {pq.insert(i);});

        System.err.println(pq.pop());
        System.err.println(pq.pop());
    }
}