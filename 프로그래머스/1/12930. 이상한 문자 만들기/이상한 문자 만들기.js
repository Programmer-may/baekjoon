function solution(s) {
    var answer = '';
    let arr = s.split(" ");
    for (let a of arr) {
        for (let i = 0; i < a.length; i++) {
            if (i % 2 === 0) {
                answer += a[i].toUpperCase();
            } else {
                answer += a[i].toLowerCase();
            }
        }
        answer += " ";        
    }
    return answer.substring(0, answer.length - 1);
}