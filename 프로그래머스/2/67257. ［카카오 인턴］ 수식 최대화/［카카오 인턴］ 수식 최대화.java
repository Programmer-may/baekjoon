import java.util.*;

class Solution {
    List<Long> nums = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    String[] operatorPriArr = {"*+-","*-+","+-*","+*-","-*+","-+*"};
    public long solution(String expression) {
        // 관건 1 : 어떻게 문자열을 자를 것인가?
        // 관건 2 : 자른 문자열들을 어떻게 담을 것인가?
        // 관건 3 : 연산자 우선순위 조합을 어떻게 짤것인가?
        init(expression);
        long answer = 0;
        for (String operatorPri : operatorPriArr) {
            List<Long> numsCopy = new ArrayList<>(nums);
            List<Character> operatorsCopy = new ArrayList<>(operators);
            for (char operator : operatorPri.toCharArray()) {
                for(int i = 0; i < operatorsCopy.size();){
                    char op = operatorsCopy.get(i);
                    if(op != operator) {
                        i++; 
                        continue;
                    }
                    if(op == '*') numsCopy.set(i, numsCopy.get(i) * numsCopy.get(i + 1));    
                    else if(op == '-')numsCopy.set(i, numsCopy.get(i) - numsCopy.get(i + 1)) ;
                    else if(op == '+')numsCopy.set(i, numsCopy.get(i) + numsCopy.get(i + 1)) ;

                    numsCopy.remove(i + 1);
                    operatorsCopy.remove(i);
                }
            }
            answer = Math.max(answer, Math.abs(numsCopy.get(0)));
        }
        
        return answer;
    }
    private void init(String exp) {
        for(int i = 0; i < exp.length(); ){
            int j = i;
            while(j < exp.length() && Character.isDigit(exp.charAt(j))) j ++;
            if(j != exp.length()) operators.add(exp.charAt(j)); 
            nums.add(Long.valueOf(exp.substring(i,j)));
            i = j + 1;
        }
    }
}