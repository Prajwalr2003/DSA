import java.util.*;

public class QueueReversal {
  public static void queueReversal(Queue<Integer> q) {
    Stack<Integer> stk = new Stack<>();
    while (!q.isEmpty()) {
      stk.push(q.remove()); 
    }
    while (!stk.isEmpty()) {
      q.add(stk.pop());
    }
  }

  public static void main(String args[]) {
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);

    queueReversal(q);

    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }
}
