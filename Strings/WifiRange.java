public class WifiRange {
    String wifiRange(int N, String S, int X) 
    { 
        StringBuilder sb = new StringBuilder(S);
        int i=0; 
        while(i<N)
        {
            if(S.charAt(i)=='1')
            {
                int j=i, k=i;
                while(i+X<N && j<i+X)
                {
                    sb.setCharAt(j+1, '*');
                    j++;
                }
                i = i+X;
                int z=k;
                while(k-X>=0 && z>k-X)
                {
                    sb.setCharAt(z-1, '#');
                    z--;
                }
            }
            i++;
        }
        return sb.toString();
        // for(i=0; i<N; i++)
        // {
        //     if(sb.charAt(i) != '1')
        //     {
        //         return false;
        //     }
        // }
        // return true;
    }

    public static void main(String[] args)
    {
        String S = "010101010";
        int X = 2;
        int N = S.length();
        WifiRange wifiRangeObj = new WifiRange();
        String result = wifiRangeObj.wifiRange(N, S, X);
        System.out.println(result);
    }
}
