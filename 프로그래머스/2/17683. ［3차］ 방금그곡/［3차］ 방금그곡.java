import java.util.*;

class Solution {
    class Music implements Comparable<Music>{
        String name;
        String melody;
        int playTime;
        int order;
        
        Music(String name, String melody, int playTime, int order) {
            this.name = name;
            this.melody = melody;
            this.playTime = playTime;
            this.order = order;
        }
        
        @Override
        public int compareTo(Music o) {
            if (this.playTime == o.playTime) return this.order - o.order;
            return o.playTime - this.playTime;
        }
    }
    public String solution(String m, String[] musicinfos) {
        List<Music> playList = new ArrayList<>();
        PriorityQueue<Music> answer = new PriorityQueue<>();
        int order = 0;
        m = replaceSharp(m);
        
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            int startTime = calculateTime(info[0]);
            int endTime = calculateTime(info[1]);
            int playTime = endTime - startTime;
            String melody = replaceSharp(info[3]);
            
            StringBuilder fullMelody = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                fullMelody.append(melody.charAt(i % melody.length()));
            }
            
            playList.add(new Music(info[2], fullMelody.toString(), playTime, order++));
        }
        for (Music music : playList) {
            if (music.melody.contains(m)) answer.add(music);
        }
        
        return answer.size() != 0 ? answer.poll().name : "(None)" ;
    }
    private int calculateTime(String time) {
        String[] timeInfo = time.split(":");
        return Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
    }
    private String replaceSharp(String melody) {
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");
        melody = melody.replaceAll("A#", "a");
        melody = melody.replaceAll("B#", "b");
        return melody;
    }
}