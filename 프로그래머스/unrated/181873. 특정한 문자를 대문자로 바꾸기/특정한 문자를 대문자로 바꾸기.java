class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        for (char letter : my_string.toCharArray()) {
            if (letter == alp.charAt(0)) {
                sb.append((char)(letter - 32));
            } else {
                sb.append(letter);
            }
        }
        return sb.toString();
    }
}