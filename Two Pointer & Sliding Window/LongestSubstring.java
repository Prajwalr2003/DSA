import java.util.HashMap;

public class LongestSubstring {

    // Brute Force
    public static int longestSubstring(String str){
        HashMap<Character, Integer> map = new HashMap<>(256);
        int n = str.length();
        int maxLen = 0;
        for(int i=0 ;i<n; i++){
            map.clear();
            for(int j=i; j<n; j++){
                char ch = str.charAt(j);
                if(map.containsKey(ch)){
                    break;
                }

                map.put(ch, j);
                maxLen = Math.max(maxLen, j-i+1);
            }
        }

        return maxLen;
    }

    // Better Solution or Optimal Solution
    public static int longestSubstring2(String str){
        HashMap<Character, Integer> map = new HashMap<>(256);
        int n = str.length();
        int l=0, r=0, maxLen=0;

        while(r<n){
            if(map.containsKey(str.charAt(r))){
                if(map.get(str.charAt(r))>=l){
                    l = map.get(str.charAt(r))+1;
                }
            }

            map.put(str.charAt(r), r);
            maxLen = Math.max(maxLen, r-l+1);

            r++;
        }

        return maxLen;
    }

    public static void main(String args[]){
        String str = "abcabcbb";
        int ans = longestSubstring2(str);
        System.out.println(ans);
    }
}
