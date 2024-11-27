class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        val queue1 = ArrayDeque(cards1.asList())
        val queue2 = ArrayDeque(cards2.asList())
        val goalQueue = ArrayDeque(goal.asList())

        while (goalQueue.isNotEmpty()) {
            val currentGoal = goalQueue.removeFirst()

            when {
                queue1.isNotEmpty() && currentGoal == queue1.first() -> queue1.removeFirst()
                queue2.isNotEmpty() && currentGoal == queue2.first() -> queue2.removeFirst()
                else -> return "No"
            }
        }
        return "Yes"
    }
}