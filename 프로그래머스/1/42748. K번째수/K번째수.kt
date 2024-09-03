class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map { command ->
        val (i, j, k) = command
        array.sliceArray((i - 1) until j)  // i-1부터 j까지 슬라이스
            .sortedArray()[k - 1]           // 정렬 후 k번째 요소 추출
        }.toIntArray()
    }
}