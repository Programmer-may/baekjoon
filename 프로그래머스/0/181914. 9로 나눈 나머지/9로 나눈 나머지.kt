class Solution {
    fun solution(number: String): Int {
        return number.map { it - '0' }.sum() % 9
    }
}