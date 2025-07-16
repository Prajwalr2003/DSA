import java.util.*;

public class ReverseString {

  public static String f(String s) {
    String str[] = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = str.length - 1; i >= 0; i--) {
      sb.append(str[i]).append(" ");
    }
    return sb.toString().trim().substring(0, 1).toUpperCase() + sb.toString().toLowerCase().trim().substring(1);
  }

  public static void main(String[] args) {
    String s = "This is a string";
    String ans = f(s);
    System.out.println(ans); // String a is this

    String str = "ABC" + "abc";
    System.out.println(str);
  }
}
