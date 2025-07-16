import java.util.Stack;

public class ValidParenthesis {
  public static boolean validParenthesis(String s) {
    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '[' || ch == '{') {
        stk.push(ch);
      } else if (ch == ')' || ch == ']' || ch == '}') {
        if (stk.peek() == '(' && ch == ')' || stk.peek() == '[' && ch == ']'
            || stk.peek() == '{' && ch == '}') {
          stk.pop();
        } else {
          return false;
        }
      }
    }

    if (stk.isEmpty()) {
      return true;
    }

    return false;
  }

  public static void main(String args[]) {
    String[] arr = { "({[()]})", "{(){[]}[]())}", "{({}[{}]()[[[]]])}", "()[{]}({})[{}])" };
    for (int i = 0; i < arr.length; i++) {
      boolean res = validParenthesis(arr[i]);
      System.out.println(res);
    }
  }
}
