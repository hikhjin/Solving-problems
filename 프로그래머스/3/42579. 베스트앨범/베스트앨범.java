import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playSum = new HashMap<>();
        Map<String, ArrayList<Song>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            playSum.put(genres[i], playSum.getOrDefault(genres[i], 0) + plays[i]);
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> keySet = new ArrayList<>(playSum.keySet());  
        Collections.sort(keySet, (o1, o2) -> playSum.get(o2) - playSum.get(o1));
        
        List<Integer> result = new ArrayList<>();
        
        for (String genre : keySet) {
            List<Song> songs = map.get(genre);
            Collections.sort(songs);
            
            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i).idx);
            }
        }
        
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
             
    }
}

class Song implements Comparable<Song> {
    int idx;
    int plays;
    
    public Song(int idx, int plays) {
        this.idx = idx;
        this.plays = plays;
    }
    
    @Override
    public int compareTo(Song o) {
        if (this.plays == o.plays) return Integer.compare(this.idx, o.idx); // 오름차순
        return Integer.compare(o.plays, this.plays); // 내림차순
    }
}