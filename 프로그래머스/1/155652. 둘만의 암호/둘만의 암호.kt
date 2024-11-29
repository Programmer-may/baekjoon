class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val map = mutableMapOf<Char, Int>()
        val numberMap = mutableMapOf<Int, Char>()
        var idx = 1
        for (letter in 'a'..'z') {
            if (!skip.contains(letter)) {
                map[letter] = idx
                numberMap[idx++] = letter
            }
        }
        val sb = StringBuilder()
        for (letter in s) {
            var letterNum = map.get(letter)!!
            var cnt = index
            while (cnt > 0) {
                letterNum++
                if (letterNum > map.size) letterNum = 1
                if (numberMap.containsKey(letterNum)) cnt--;
            }
            sb.append(numberMap.get(letterNum)!!)
        }
        return sb.toString()
    }
}