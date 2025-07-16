import java.util.*;

public class MaxAreaInHistogram {
  public static int maxAreaOfHistogram(int heights[]) {
    Stack<Integer> stk = new Stack<>();

    int n = heights.length;
    int nextSmallerLeft[] = new int[n];
    int nextSmallerRight[] = new int[n];

    // Next Smaller Right
    for (int i = n - 1; i >= 0; i--) {
      while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
        stk.pop();
      }
      if (stk.isEmpty()) {
        nextSmallerRight[i] = n;
      } else {
        nextSmallerRight[i] = stk.peek();
      }
      stk.push(i);
    }

    // Next Smaller Left
    stk = new Stack<>();
    for (int i = 0; i <= n - 1; i++) {
      while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
        stk.pop();
      }
      if (stk.isEmpty()) {
        nextSmallerLeft[i] = -1;
      } else {
        nextSmallerLeft[i] = stk.peek();
      }
      stk.push(i);
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
      int area = heights[i] * (width);
      max = Math.max(max, area);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] heights = { 2, 1, 5, 6, 2, 3 };
    System.out.println("Max Area in Histogram: " + maxAreaOfHistogram(heights));
  }
}
