import java.util.*;

class WordLadderII {
    public static ArrayList<ArrayList<String>> findSequences(String startWord,
        String targetWord, String[] wordList) {

        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        if(!set.contains(targetWord)) return new ArrayList<>();
        
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> initial = new ArrayList<>();
        initial.add(startWord);
        q.offer(initial);
        
        ArrayList<ArrayList<String>> sequences = new ArrayList<>();
        
        while(!q.isEmpty()){
            int size = q.size();
            Set<String> vis = new HashSet<>();
            while(size > 0){
                ArrayList<String> seq = q.poll();
                StringBuilder word = new StringBuilder(seq.get(seq.size()-1));
                if(word.toString().equals(targetWord)){
                    if(sequences.size() == 0){
                        sequences.add(new ArrayList<>(seq));
                    }
                    else if(sequences.get(0).size() == seq.size()){
                        sequences.add(new ArrayList<>(seq));
                    }
                }
                
                for(int i=0; i<word.length(); i++){
                    char original = word.charAt(i);
                    for(char ch='a'; ch<='z'; ch++){
                        if(ch == original) continue;
                        
                        word.setCharAt(i, ch);
                        String newWord = word.toString();
                        
                        if(set.contains(newWord)){
                            vis.add(newWord);
                            
                            ArrayList<String> newSeq = new ArrayList<>(seq);
                            newSeq.add(newWord);
                            
                            q.offer(newSeq);
                        }
                    }
                    word.setCharAt(i, original);
                }
                size--;
            }
            
            set.removeAll(vis);
        }
        
        return sequences;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] wordList = new String[n];
        for(int i=0; i<n; i++){
            wordList[i] = sc.nextLine();
        }

        String startWord = sc.nextLine();
        String targetWord = sc.nextLine();

        ArrayList<ArrayList<String>> ans = findSequences(startWord, targetWord, wordList);
        System.out.println(ans);

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