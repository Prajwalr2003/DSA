import java.util.*;

public class ReverseStack {
  public static void pushAtBottom(Stack<Integer> stk, int data) {
    if (stk.isEmpty()) {
      stk.push(data);
      return;
    }

    int top = stk.pop();
    pushAtBottom(stk, data);
    stk.push(top);
  }

  public static void printStack(Stack<Integer> stk) {
    while (!stk.isEmpty()) {
      System.out.print(stk.pop() + " ");
    }
  }

  public static void reverseStack(Stack<Integer> stk) {
    if (stk.isEmpty()) {
      return;
    }
    int top = stk.pop();
    reverseStack(stk);
    pushAtBottom(stk, top);
  }

  public static void main(String args[]) {
    Stack<Integer> stk = new Stack<>();
    for (int i = 1; i <= 10; i++) {
      stk.push(i);
    }

    reverseStack(stk);
    printStack(stk);
  }
}
