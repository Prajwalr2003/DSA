import java.util.*;

public class LongestCommonSubsequence {
    public static int f(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+f(i-1, j-1, s1, s2, dp);
            return dp[i][j];
        }

        dp[i][j] = Math.max(f(i-1, j, s1, s2, dp), f(i, j-1, s1, s2, dp));

        return dp[i][j];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // System.out.println(f(n-1, m-1, s1, s2, dp));

        for(int i=0; i<=n; i++) dp[i][0]=0;
        for(int j=0; j<=m; j++) dp[0][j]=0;

        for(int i=1; i<=n ;i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m ;j++){
        //         System.out.print(dp[i][j]+"  ");
        //     }
        //     System.out.println();
        // }

        StringBuilder sb = new StringBuilder();

        int i=n, j=m;

        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.insert(0, s1.charAt(i-1));
                i=i-1;
                j=j-1;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i=i-1;
            }else{
                j=j-1;
            }
        }
        System.out.println(sb.toString());
    }
}