class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()
        var map = mutableMapOf<Char, Int>()
        for (idx in 0..s.length - 1) {
            val letter = s.get(idx)
            if (map.containsKey(letter)) {
                answer.add(idx - map[letter]!!)   
            } else {
                answer.add(-1)
            }
            map[letter] = idx
        }
        return answer.toIntArray()
    }
}