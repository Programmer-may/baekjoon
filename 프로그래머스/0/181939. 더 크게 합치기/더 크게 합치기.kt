class Solution {
    fun solution(a: Int, b: Int): Int {
        var strA = a.toString()
        var strB = b.toString()
        if (a == b) return (strA + strB).toInt()
        var mergeAB = (strA + strB).toInt()
        var mergeBA = (strB + strA).toInt()
        if (mergeAB > mergeBA) return mergeAB
        return mergeBA
    }
}