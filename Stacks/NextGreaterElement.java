import java.util.*;

public class NextGreaterElement {
  public static int[] nextGreaterElement(int arr[]) {
    Stack<Integer> s = new Stack<>();
    int nextGreater[] = new int[arr.length];
    int n = arr.length;

    for (int i = n - 1; i >= 0; i--) {
      while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
        s.pop();
      }
      if (s.isEmpty()) {
        nextGreater[i] = -1;
      } else {
        nextGreater[i] = arr[s.peek()];
      }
      s.push(i);
    }

    return nextGreater;
  }

  public static void main(String[] args) {
    int arr[] = { 3, 4, 2, 0, 1, 6 };
    int[] res = nextGreaterElement(arr);
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i] + " ");
    }
  }
}
