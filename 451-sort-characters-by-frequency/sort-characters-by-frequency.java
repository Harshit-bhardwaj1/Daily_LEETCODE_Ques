class Solution {
    class Pair{
        int freq;
        char ch;
        Pair(int freq, char ch){
            this.freq=freq;
            this.ch=ch;
        }

    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq );
        for(char ch:map.keySet()){
            pq.add(new Pair(map.get(ch),ch));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            for(int i=0; i<p.freq; i++){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}