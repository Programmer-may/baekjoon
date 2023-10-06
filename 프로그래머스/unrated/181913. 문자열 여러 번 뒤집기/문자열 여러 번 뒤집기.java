import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();
        for(int i =0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            while(s<e){
                char tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++;
                e--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char alp : arr){
            sb.append(alp);
        }
        return sb.toString();
    }
}