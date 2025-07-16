import java.util.ArrayList;

public class StackUsingArrayList {
  static class Stack {
    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean isEmpty() {
      return list.size() == 0;
    }

    // Push
    public static void push(int data) {
      list.add(data);
    }

    // pop
    public static int pop() {
      int top = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      return top;
    }

    // Peek
    public static int peek() {
      return list.get(list.size() - 1);
    }
  }

  public static void main(String args[]) {
    Stack stk = new Stack();
    stk.push(1);
    stk.push(2);
    stk.push(3);
    stk.push(4);

    while (!stk.isEmpty()) {
      System.out.println(stk.peek());
      stk.pop();
    }
  }
}