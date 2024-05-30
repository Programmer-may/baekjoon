import java.util.*;

class Solution {
    class Music {
        int num;
        int plays;

        Music(int num, int plays) {
            this.num = num;
            this.plays = plays;
        }
    }
    class Genre {
        String name;
        int playTimes;

        Genre(String name, int playTimes) {
            this.name = name;
            this.playTimes = playTimes;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playTimePerGenre = new HashMap<>();
        Map<String, PriorityQueue<Music>> playTimePerMusic = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playTimePerGenre.put(genres[i], playTimePerGenre.getOrDefault(genres[i], 0) + plays[i]);
            playTimePerMusic.putIfAbsent(genres[i], new PriorityQueue<Music>((o1, o2) -> o2.plays - o1.plays));
            playTimePerMusic.get(genres[i]).add(new Music(i, plays[i]));
        }
        PriorityQueue<Genre> pq = new PriorityQueue<>((o1, o2) -> o2.playTimes - o1.playTimes);
        for (String genre : playTimePerGenre.keySet()) {
            pq.add(new Genre(genre, playTimePerGenre.get(genre)));
        }
        List<Integer> answerArr = new ArrayList<>();
        while (!pq.isEmpty()) {
            Genre genre = pq.poll();
            if (playTimePerMusic.get(genre.name).size() >= 2) {
                Music music1 = playTimePerMusic.get(genre.name).poll();
                Music music2 = playTimePerMusic.get(genre.name).poll();
                if (music1.plays != music2.plays) {
                    answerArr.add(music1.num);
                    answerArr.add(music2.num);
                } else {
                    if (music1.num < music2.num) {
                        answerArr.add(music1.num);
                        answerArr.add(music2.num);
                    } else {
                        answerArr.add(music2.num);
                        answerArr.add(music1.num);
                    }
                }

            } else {
                answerArr.add(playTimePerMusic.get(genre.name).poll().num);
            }
        }
        int[] answer = new int[answerArr.size()];
        int idx = 0;
        for (int num : answerArr) {
            answer[idx++] = num;
        }
        return answer;
    }
}