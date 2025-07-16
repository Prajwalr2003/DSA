import java.util.*;

class PalindomePartitioning{
	public static boolean possible(int ind, int lstInd, String s){
		while(ind<=lstInd){
			if(s.charAt(ind) != s.charAt(lstInd)) return false;
			ind++;
			lstInd--;
		}
		return true;
	}
	public static void f(int ind, String s, List<String> list, List<List<String>> palindromes){
		 if(ind==s.length()){
		 	palindromes.add(new ArrayList<>(list));
		 	return;
		 }

		 for(int i=ind; i<s.length(); i++){
		 	if(possible(ind, i, s)){
		 		list.add(s.substring(ind,i+1));
		 		f(i+1, s, list, palindromes);
		 		list.remove(list.size()-1);
		 	}
		 }
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		List<String> list = new ArrayList<>();
		List<List<String>> palindromes = new ArrayList<>();
		f(0, s, list, palindromes);
		for(int i=0; i<palindromes.size(); i++){
			System.out.println(palindromes.get(i));
		}
	}
}