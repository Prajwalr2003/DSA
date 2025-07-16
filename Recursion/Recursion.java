import java.util.*;

class Recursion{
	public static String f(int n, int k, StringBuilder s, StringBuilder res){
		int fact=1;
		for(int i=1; i<n; i++){
			fact = fact*i;
		}

		k = k-1;

		while(true){
			res.append(s.charAt(k/fact));
			s.deleteCharAt(k/fact);
			if(s.length()==0){
				break;
			}
			k = k%fact;
			fact = fact/s.length();
		}

		return res.toString();
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		StringBuilder s = new StringBuilder();
		for(int i=1; i<=n; i++){
			s.append(i);
		}
		String str = f(n, k, s, new StringBuilder());
		System.out.println(str);
	}
}