import java.util.*;

class WordLadderI {
    static class Pair{
        String first;
        int second;
        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String> set = new HashSet<>();
        for(int i=0; i<wordList.length; i++){
            set.add(wordList[i]);
        }
        
        set.remove(startWord);
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startWord, 1));
        
        while(!q.isEmpty()){
            StringBuilder s = new StringBuilder(q.peek().first);
            int steps = q.peek().second;
            q.poll();
            
            if(s.toString().equals(targetWord)) return steps;
            
            for(int i=0; i<s.length(); i++){
                char original = s.charAt(i);
                for(char ch='a'; ch<='z'; ch++){
                    s.setCharAt(i, ch);
                    String newWord = s.toString();
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.offer(new Pair(newWord, steps+1));
                    }
                }
                s.setCharAt(i, original);
            }
        }
        
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] wordList = new int[n];
        for(int i=0; i<n; i++){
            wordList[i] = sc.nextLine();
        }

        String startWord = sc.nextLine();
        String targetWord = sc.nextLine();

        System.out.println(wordLadderLength(startWord, targetWord, wordList));

        // 5
        // des
        // der
        // dfr
        // dgt
        // dfs
        // der
        // dfs
    }
}