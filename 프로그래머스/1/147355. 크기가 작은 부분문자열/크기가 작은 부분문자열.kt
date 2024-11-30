class Solution {
    fun solution(t: String, p: String): Int {
        var answer = 0
        val maxLength = p.length
        val targetNum = p.toLong()
        for (start in 0..t.length - maxLength) {
            val num = t.substring(start, start + maxLength).toLong()
            if (num <= targetNum) answer++
        }
        return answer
    }
}