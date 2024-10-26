import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        generateWords("", 0); // 사전 단어 생성
        Collections.sort(dictionary); // 사전 순으로 정렬
        
        return dictionary.indexOf(word) + 1; // 위치는 1부터 시작하므로 +1
    }
    
    private void generateWords(String current, int depth) {
        if (depth > 5) return; // 길이가 5를 넘으면 종료
        
        if (!current.isEmpty()) {
            dictionary.add(current); // 사전에 단어 추가
        }
        
        for (char vowel : vowels) {
            generateWords(current + vowel, depth + 1); // 다음 글자 추가하여 재귀 호출
        }
    }
}