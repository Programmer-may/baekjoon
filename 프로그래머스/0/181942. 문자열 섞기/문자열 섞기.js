function solution(str1, str2) {
    let answer = ""
    for (let idx = 0; idx < str1.length; idx++) {
        answer += str1.charAt(idx)
        answer += str2.charAt(idx)
    }
    return answer;
}