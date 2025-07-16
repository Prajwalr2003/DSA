public class ValidShuffleOrNot {
    
    public static boolean validShuffle(String s1, String s2, String res){

        int l1 =s1.length();
        int l2 = s2.length();
        int lr = res.length();

        
        int f=0;
        int i=0, j=0, k=0;

        if((l1+l2)!=lr){
            return false;
        }
        else{
            while(k<lr){
                if(i<l1 && s1.charAt(i)==res.charAt(k)){
                    i++;
                }
                else if(j<l2 && s2.charAt(j)==res.charAt(k)){
                    j++;
                }
                else{
                    f=1;
                    break;
                }
                k++;
            }
        }

        if(i<l1 || j<l2){
            return false;
        }
        else{
            return true;
        }
        
    }

    public static void main(String[] args){

        String s1 = "XY";
        String s2 = "12";
        String res = "1XY2";

        System.out.println(validShuffle(s1, s2, res));

    }
}
