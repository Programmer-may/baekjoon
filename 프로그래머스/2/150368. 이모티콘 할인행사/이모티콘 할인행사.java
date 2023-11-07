import java.util.*;

class Result implements Comparable<Result> {
    int peopleCnt;
    int totalAmount;
    
    public Result(int peopleCnt, int totalAmount){
        this.peopleCnt = peopleCnt;
        this.totalAmount = totalAmount;
    }
    
    @Override
    public int compareTo(Result other) {
        if(this.peopleCnt == other.peopleCnt) {
            return other.totalAmount - this.totalAmount;
        }
        return other.peopleCnt - this.peopleCnt;
    }
}

class Solution {
    static int[] sales = {10, 20, 30, 40};
    static int[] discountArr; 
    static PriorityQueue<Result> pq;
    public int[] solution(int[][] users, int[] emoticons) {
        discountArr = new int[emoticons.length];
        pq = new PriorityQueue<>();
        dfs(users , emoticons, 0);
        
        return new int[] {pq.peek().peopleCnt , pq.peek().totalAmount};
    }
    public void dfs(int[][] users, int[] emoticons, int lev){
        if (lev == discountArr.length) {
            int tmpTotalPrice = 0;
            int tmpJoinPeopleNum = 0;
            for (int personIdx = 0; personIdx < users.length; personIdx++) {
                int requiredDiscount = users[personIdx][0];
                int requiredPrice = users[personIdx][1];
                int tmpPersonalPrice = 0;
                for (int emoIdx = 0; emoIdx < emoticons.length; emoIdx++) {
                    if (discountArr[emoIdx] >= requiredDiscount) {
                        tmpPersonalPrice += emoticons[emoIdx] * (100 - discountArr[emoIdx]) / 100;
                    }
                }
                if (tmpPersonalPrice >= requiredPrice) tmpJoinPeopleNum++;
                else tmpTotalPrice += tmpPersonalPrice;
            }
            pq.offer(new Result(tmpJoinPeopleNum, tmpTotalPrice));
            return;
        }
        for (int i = 0; i < sales.length; i++) {
            discountArr[lev] = sales[i];
            dfs(users, emoticons, lev + 1);
        }
    }
}