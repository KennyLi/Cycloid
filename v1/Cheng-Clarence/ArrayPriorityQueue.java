//Team Something -- Clarence Cheng, Kevin Lin
//APCS2 Pd1
//HW46 -- Arrr, There Be Priorities Here Matey . . .
//2018-05-10

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayPriorityQueue implements PriorityQueue{

  ArrayList<String> _data;

  public ArrayPriorityQueue() {//Constructor
    _data = new ArrayList<String>();
  }

  public boolean isEmpty() {return _data.size() == 0;}

  public String peekMin() {
    if (isEmpty()) throw new NoSuchElementException("Empty queue");//Throws exception if empty
    return _data.get(0);//Return front element
  }

  public String removeMin() {
    if (isEmpty()) throw new NoSuchElementException("Empty queue");//Throws exception if empty
    return _data.remove(0);//Remove and return front elm
  }

  public void add(String input) {
    for (int i = 0; i < _data.size(); i++) {//Traverse queue
      if (input.compareTo( _data.get(i) ) < 0) {//Check if position i is a valid insertion point
        _data.add(i,input);
        return;
      }
    }
    _data.add(input);//Adds at the end if no suitable spot is found
  }

  public static void main(String[] args) {
    PriorityQueue q = new ArrayPriorityQueue();
    //Adding elements
    q.add("b");
    q.add("c");
    q.add("a");
    q.add("d");
    //Testing peek and remove
    System.out.println(q.peekMin());
    while (!q.isEmpty()) {
      System.out.println(q.removeMin());
    }
    //Testing Exception Handling
    try {q.removeMin();}
    catch (Exception e) {System.out.println("Exception caught");}
  }

}
