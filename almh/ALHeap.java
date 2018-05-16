/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap; 

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeap() 
  {
    _heap = new ArrayList<Integer>();
  }

  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either 
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString() 
  {
    String retStr = "";
    for (int ele : _heap) {
        retStr += ele + " ";
    }
    return retStr;
  }//O(N)


  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
    return _heap.size() == 0;
  }//O(1)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /*****************************************************
   * add(Integer) 
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   -----------------------Procedure-----------------------
   * Adds value to the end of heap
   * Continuously swaps value with parent if value is smaller\
   to maintain heap property.
   *****************************************************/
  public void add( Integer addVal )
  {
    _heap.add(addVal);
    int i = _heap.size() - 1; //index of newly added val
    while ((i != 0) && (minOf(addVal, _heap.get((i - 1) / 2)) == addVal)) {
        swap(i, (i - 1) / 2); //swap with parent
        i = (i - 1) / 2; //new index of val
    }
  }//O(logN)


  /*****************************************************
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   -----------------------Procedure-----------------------
   * Swaps root(least element) with last element in _heap
   * Removes the old root (last element)
   * Continuously swaps new root with the minimum of the two children
   *****************************************************/
  public Integer removeMin()
  {
    if (isEmpty()) { //_heap is empty
        return null;
    }
    swap(0, _heap.size() - 1); //swaps root with last element
    int retVal = _heap.remove(_heap.size() - 1); //removes old root
    int i = 0;
    //swap if child is smaller than parent
    while ((minChildPos(i) != -1) && (_heap.get(i) > _heap.get(minChildPos(i)))) { 
        int child = minChildPos(i);
        swap(i, child);
        i = child;
    }
    return retVal;
  }//O(logN)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or 
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int minChildPos( int pos )
  {
    int left = pos * 2 + 1; //index of left child
    int right = pos * 2 + 2; //index of right child
    if (pos >= _heap.size()) {
	    return -1;
    } else if ((left >= _heap.size()) && (right >= _heap.size())) { //no children
	    return -1;
    } else if (right >= _heap.size()) { // only left child
        return left;
    } else if (minOf(_heap.get(left), _heap.get(right)) == _heap.get(left)) { //left child is min
        return left;
    } else {
      return right;  //right child is min
    }
  }//O(1)
  

  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
