class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        score.sortDescending()
        var idx = 0
        for (i in 0..score.size - m step m) {
            answer += score[i + m - 1] * m
        }
        return answer
    }
}