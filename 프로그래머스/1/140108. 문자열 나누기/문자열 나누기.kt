class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var i = 0
        while (i < s.length) {
            val letter = s.get(i)
            var sameCnt = 1
            var notSameCnt = 0
            while (sameCnt != notSameCnt && i < s.length - 1) {
                val nextLetter = s.get(++i)
                when {
                    letter == nextLetter -> sameCnt++
                    else -> notSameCnt++
                }
            }
            answer++
            i++
        }
        return answer
    }
}