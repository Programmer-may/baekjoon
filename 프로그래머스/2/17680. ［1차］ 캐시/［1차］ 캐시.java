import java.util.*;

class Solution {
    final int HIT = 1;
    final int MISS = 5;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new LinkedList<>();
        if (cacheSize == 0) {
            return cities.length * MISS;
        }
        for (String city : cities) {
            city = city.toLowerCase();
            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += HIT;
            } else {
                if(cache.size() == cacheSize) {
                    cache.remove(0);
                    cache.add(city);
                    answer += MISS;
                } else {
                    cache.add(city);
                    answer += MISS;
                }
            }
        }
        return answer;
    }
}