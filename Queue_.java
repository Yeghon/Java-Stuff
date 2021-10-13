import java.util.*;
import java.util.AbstractQueue;

public class Queue_<T> extends AbstractQueue<T> {

  public static void main(String[] args) {
    Queue_ queue = new Queue_<>();
    queue.add(67);
    assert queue.peek() == (Object) 67;
    //
  }

  private LinkedList<T> elements;

  public Queue_() {
    this.elements = new LinkedList<T>();
  }

  // Iterate through the elements of a queue
  @Override
  public Iterator<T> iterator() {
    return elements.iterator();
  }

  // Remove the 1st element
  @Override
  public T poll() {
    Iterator<T> iter = elements.iterator();
    T t = iter.next();
    // if not null, remove it then return it else null
    assert null != t;
    iter.remove();
    return null != t ? t : null;
  }

  // add an element to the queue
  @Override
  public boolean offer(T t) {
    if (null != t) {
      elements.add(t);
      return true;
    }
    return false;
  }

  // Get the size
  @Override
  public int size() {
    return elements.size();
  }

  // peek to see the element in the front of the queue
  @Override
  public T peek() {
    return elements.getFirst();
  }
}
