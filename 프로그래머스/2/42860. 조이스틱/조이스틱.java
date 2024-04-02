class Solution {
    public int solution(String name) {
//         int left = 1;
//         int right = name.length() - 1;
//         int leftCnt = 0;
//         int rightCnt = 0;
//         while (left < right) {
//             if (name.charAt(left) != 'A') leftCnt++;
//             if (name.charAt(right) != 'A') rightCnt++;
//             left++;
//             right--;
//         }
//         int answer = 0;
//         if (leftCnt <= rightCnt) {
//             answer += 
//             for (int i = name.length() - 1; i >= 1; i--) {
                
//             }
            
//         } else {
//             for (int i = name.length() - 1; i >= 1; i--) {
                
//             }
//         }
        
//         return answer;
//     }
//     private int changedFirstLetter() {
        
//     }
        int answer = 0;
        int length = name.length();

        int index;
        int move = length - 1;

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }
            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }
}