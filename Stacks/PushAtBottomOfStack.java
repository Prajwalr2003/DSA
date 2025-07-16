import java.util.*;

public class PushAtBottomOfStack {

  public static void pushAtBottomStack(Stack<Integer> s, int data) {
    Stack<Integer> stk = new Stack<>();
    while (!s.isEmpty()) {
      stk.push(s.pop());
    }

    s.push(data);

    while (!stk.isEmpty()) {
      s.push(stk.pop());
    }
  }

  public static void pushAtBottomRecursion(Stack<Integer> s, int data) {
    if (s.isEmpty()) {
      s.push(data);
      return;
    }

    int top = s.pop();
    pushAtBottomRecursion(s, data);
    s.push(top);
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);

    // pushAtBottomRecursion(s, 4);
    pushAtBottomStack(s, 4);

    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }
}
