class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        answer = answer.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "")
        //answer = answer.replaceAll("[^0-9a-z-_.]", "")
                .replaceAll("\\.++", ".");
        sb.append(answer);
        if (sb.length() != 0){
            if (sb.charAt(0) == '.') sb.deleteCharAt(0);
        }
        if (sb.length() != 0){
            if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.length() == 0) sb.append('a');
        if (sb.length() >= 16) sb.delete(15, sb.length());
        if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        if (sb.length() <= 2) {
            char lastChar = sb.charAt(sb.length() - 1);
            for (int i = sb.length(); i < 3; i++) {
                sb.append(lastChar);
            }
        }
        return sb.toString();
    }
}