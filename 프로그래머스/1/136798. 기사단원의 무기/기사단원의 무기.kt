class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        for (i in 1..number) {
            val result = countDivisor(i)
            when {
                result <= limit -> answer += result
                else -> answer += power
            }
        }
        return answer
    }
    
    fun countDivisor(num: Int): Int {
        val nums = mutableSetOf<Int>()
        for (i in 1..Math.sqrt(num.toDouble()).toInt()) {
            when {
                num % i == 0 -> {
                    nums.add(i)
                    nums.add(num / i)
                }
            }
        }
        return nums.size
    }
}