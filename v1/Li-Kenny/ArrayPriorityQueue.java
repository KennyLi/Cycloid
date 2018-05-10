//Team Sasquatch (Henry Carver, Kenny Li)
//APCS2 Pd1
//HW46 -- Arrr, There Be Priorities Here Matey . . .
//2018-05-10

import java.util.ArrayList;

public class ArrayPriorityQueue {

    ArrayList<String> pQueue;

    public ArrayPriorityQueue() {
        pQueue = new ArrayList<String>();
    }

    public void add(String str) {
    for(int i = 0; i < pQueue.size(); i++) {
        if(str.compareTo(pQueue.get(i)) >= 0)  {
            pQueue.add(i, str);
            return;
        }
    }
    pQueue.add(str);
    }

    public boolean isEmpty() {
	return pQueue.size() == 0;
    }

    public String removeMin() {
	return pQueue.remove(pQueue.size()-1);
    }

    public String peekMin() {
	return pQueue.get(pQueue.size()-1);
    }

    public static void main(String[] args) {
    ArrayPriorityQueue pQueue = new ArrayPriorityQueue();
    pQueue.add("B");
    System.out.println(pQueue.peekMin()); //B
    pQueue.add("C");
    System.out.println(pQueue.peekMin()); //B
    pQueue.add("A");
    System.out.println(pQueue.peekMin()); //A
    pQueue.add("E");
    System.out.println(pQueue.peekMin()); //A
    pQueue.add("D");
    System.out.println(pQueue.peekMin()); //A
    System.out.println(pQueue.removeMin()); //A
    System.out.println(pQueue.removeMin()); //B
    System.out.println(pQueue.removeMin()); //C
    System.out.println(pQueue.removeMin()); //D
    System.out.println(pQueue.removeMin()); //E
    }
}
