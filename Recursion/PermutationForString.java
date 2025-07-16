import java.util.*;

class PermutationForString{
	public static void f(int ind, StringBuilder s, StringBuilder sb, List<String> permutations){
		if(ind == s.length()){
			permutations.add(sb.toString());
			return;
		}

		for(int i=ind; i<s.length(); i++){
			sb.append(s.charAt(i));
			s = swap(ind,i, s);
			f(ind+1, s, sb, permutations);
			sb.deleteCharAt(sb.length()-1);
			s = swap(ind,i, s);
		}
	}

	public static StringBuilder swap(int i, int j, StringBuilder s){
		char temp = s.charAt(i);
		s.setCharAt(i, s.charAt(j));
		s.setCharAt(j, temp);
		return s;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> permutations = new ArrayList<>();
		StringBuilder s = new StringBuilder();
		for(int i=1; i<=n; i++){
			s.append(i);
		}		
		f(0, s, new StringBuilder(), permutations);
		for(int i=0; i<permutations.size();i++){
			System.out.println(permutations.get(i));
		}
	}
}