public class StringCompression {
    
    public static String stringCompression(String str){
        StringBuilder sb = new StringBuilder("");

        int count=1;
        sb.append(str.charAt(0));

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                sb.append(count);
                sb.append(str.charAt(i));
                count=1;
            }
            else{
                count++;
            }
        }
        sb.append(count);
        return sb.toString();
    }
    public static void main(String[] args){
        String str = "aaabbcccdd";

        System.out.println(stringCompression(str));
    }
}
