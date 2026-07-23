class Solution {
    static class Pair{
        String word;
        int level;
        Pair(String word,int level){
            this.word=word;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashSet<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String word=curr.word;
            int level=curr.level;

            if(word.equals(endWord)){
                return level;
            }
            char[] arr=word.toCharArray();
            for(int i=0;i<arr.length;i++){
                char original=arr[i];
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String new_word=new String(arr);
                    if(set.contains(new_word)){
                        q.add(new Pair(new_word,level+1));
                        set.remove(new_word);
                    }
                }
                arr[i]=original;
            }
        }
        return 0;
    }
}