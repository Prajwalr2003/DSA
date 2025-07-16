import java.util.*;

public class ReverseAStringUsingStack {
  public static String reverseString(String str) {
    Stack<Character> stk = new Stack<>();
    int i = 0;
    while (i < str.length()) {
      stk.push(str.charAt(i));
      i++;
    }

    StringBuilder sb = new StringBuilder("");
    while (!stk.isEmpty()) {
      sb.append(stk.pop());
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "lata";
    String res = reverseString(str);
    System.out.println(res);
  }
}
