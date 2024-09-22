class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        
        for (int i = 0; i < n; i++) {
            // 각 숫자를 OR 연산 후 이진수로 변환
            String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // n 길이 맞추기 위해 왼쪽에 0을 채운다
            binaryString = String.format("%" + n + "s", binaryString).replace(' ', '0');
            
            // 이진수 문자열을 #과 공백으로 변환
            result[i] = binaryString.replace('1', '#').replace('0', ' ');
        }
        
        return result;
    }
}