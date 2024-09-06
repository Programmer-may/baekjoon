class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        var n = num.toLong() // Int 대신 Long으로 변경

        while (answer < 500) {
            if (n == 1L) return answer
            if (n % 2 == 0L) {
                n = n / 2
            } else {
                n = n * 3 + 1
            }
            answer++
        }
        return -1
    }
}
