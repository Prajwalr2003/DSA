import java.util.Stack;

class DuplicateParentheses {
  public static boolean duplicateParentheses(String s) {
    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == ')') {
        int count = 0;
        while (stk.peek() != '(') {
          stk.pop();
          count++;
        }
        if (count < 1) {
          return true;
        } else {
          stk.pop();
        }
      } else {
        stk.push(ch);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String[] s = { "(((a+(b)))+(c+d))", "((((a)+(b))+c+d))", "((a+b)+(c+d))", "(((a+b))+c)" };
    for (int i = 0; i < s.length; i++) {
      boolean res = duplicateParentheses(s[i]);
      System.out.print(res + " ");
    }
  }
}
