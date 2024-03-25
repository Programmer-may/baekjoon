import java.util.*;

class Solution {
    public String solution(String p) {
        // char[] arr = p.toCharArray();
        // char[] answer = new char[p.length()];
        // Stack<Integer> stack = new Stack<>();
        // for (int i = 0; i < arr.length; i++) {
        //     if(arr[i] == '(') {
        //         stack.add(i);
        //     } else {
        //         if(!stack.isEmpty()) {
        //             int idx = stack.pop();
        //             answer[idx] = '(';
        //             answer[i] = ')';
        //         } else {
        //             answer[i] = '(';
        //         }
        //     }
        // }
        // if(!stack.isEmpty()) {
        //     for (int idx : stack) answer[idx] = ')';
        // }
        // StringBuilder sb = new StringBuilder();
        // for (char c : answer) {
        //     sb.append(c);
        // }
        // return sb.toString();
        if (checkRightString(p)) return p;
        else return process(p);
    }
    private String process(String p) {
        if (p.length() == 0) return p;
        else {
            StringBuilder sb = new StringBuilder();
            char[] arr = p.toCharArray();
            int flag = 0;
            String u = "";
            String v = "";
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(') flag++;
                else flag--;
                if (flag == 0) {
                    u = p.substring(0, i + 1);
                    v = p.substring(i + 1);
                    break;
                }
            }
            if (checkRightString(u)) {
                sb.append(u);
                sb.append(process(v));
                return sb.toString();
            } else {
                sb.append('(');
                sb.append(process(v));
                sb.append(')');
                String trimmedU = u.substring(1, u.length() - 1);
                for (char c : trimmedU.toCharArray()) {
                    if (c == '(') sb.append(')');
                    else sb.append('(');
                }
                return sb.toString();
            }
        }
    }

    private boolean checkRightString(String p) {
        char[] arr = p.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') stack.add(i);
            else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}