class Solution {
    fun solution(angle: Int): Int {
        if (angle.equals(90)) return 2
        else if (angle.compareTo(90) < 0) return 1
        else if (angle.compareTo(90) > 0 && angle.compareTo(180) < 0) return 3
        else return 4
    }
}