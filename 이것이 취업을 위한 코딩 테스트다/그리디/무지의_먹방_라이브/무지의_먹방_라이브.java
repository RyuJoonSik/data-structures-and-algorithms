import java.util.*;

class Food implements Comparable<Food> {
    int time;
    int index;
    
    Food(int time, int index) {
        this.time = time;
        this.index = index;
    }
    
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        long sum = 0;
        for (int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        
        if (sum <= k) return -1;
        
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }
        
        sum = 0;
        long previous = 0;
        long length = food_times.length;
        
        while (sum + ((pq.peek().time - previous) * length) <= k) {
            int now = pq.poll().time;
            sum += (now - previous) * length;
            length -= 1;
            previous = now;
        }
        
        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        Collections.sort(result, new Comparator<Food>() {
            public int compare(Food a, Food b) {
                return Integer.compare(a.index, b.index);
            }
        });
        
        return result.get((int) ((k - sum) % length)).index;
    }
}