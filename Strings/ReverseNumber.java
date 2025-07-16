import java.util.Stack;

public class ReverseNumber {
  public static int f(int num) {
    int ans = 0;
    while (num > 0) {
      int lastDigit = num % 10;
      ans += lastDigit;
      num = num / 10;
      if (num > 0) {
        ans *= 10;
      }
    }

    return ans;
  }

  public static int f2(int num) {
    String str = Integer.toString(num);
    int n = str.length();
    Stack<Character> stk = new Stack<>();
    for (int i = 0; i < n; i++) {
      stk.push(str.charAt(i));
    }
    StringBuilder sb = new StringBuilder();
    while (!stk.isEmpty()) {
      sb.append(stk.pop());
    }

    return Integer.parseInt(sb.toString());
  }

  public static void main(String args[]) {
    int num = 838368364;
    System.out.println(f2(num));
    // tc = O(log10(num))
  }
}
