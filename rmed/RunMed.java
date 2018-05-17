/* Cycloid (Clarence Cheng, Kenny Li, Cheryl Qian)
APCS2 pd1
HW50 -- Run Run Run
2018-05-18 */

import java.util.NoSuchElementException;

public class RunMed
{
  ALHeapMin _minHeap;
  ALHeapMax _maxHeap;

  public RunMed() 
  {
    _minHeap = new ALHeapMin();
    _maxHeap = new ALHeapMax();
  }

  public void add(Integer newVal)
  {
    //if heaps are empty or new val is less than root of maxHeap
    if ((_minHeap.isEmpty() && _maxHeap.isEmpty()) ||
       (newVal < _maxHeap.peekMax()))
        _maxHeap.add(newVal);
    else
        _minHeap.add(newVal);
    
    //rebalances the tree
    if (_minHeap.size() - _maxHeap.size() > 1) 
        _maxHeap.add(_minHeap.removeMin());
    else if (_maxHeap.size() - _minHeap.size() > 1)
        _minHeap.add(_maxHeap.removeMax());
  }

  public double getMedian()
  {
    //if both heaps are empty
    if (_maxHeap.isEmpty() && _maxHeap.isEmpty())
        throw new NoSuchElementException();
    else if (_minHeap.isEmpty()) //when theres only one value
        return _maxHeap.peekMax();

    //if collection is even, median is average of the roots
    //if collection is odd, median is root of the bigger sized tree
    if (_minHeap.size() == _maxHeap.size())
        return (_minHeap.peekMin() + _maxHeap.peekMax()) / 2.0;
    else if (_minHeap.size() > _maxHeap.size())
        return _minHeap.peekMin();
    else
        return _maxHeap.peekMax();
  }
}