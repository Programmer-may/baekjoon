function solution(s, n) {
    var answer = '';
    for (let c of s) {
        if (c == ' ') {
            answer += c;
        } else {
            let code = c.charCodeAt(0)
            code = porceedNumber(code, n);
            answer +=  String.fromCharCode(code);   
        }
    }
    return answer;
}

function porceedNumber(c, n) {
    let r = c + n;
    if (c >= 97 && c <= 122) {
        if (r > 122) {
            r = 97 + (r - 123);
        }  
    } else {
        if (r > 90) {
            r = 65 + (r - 91);
        }
    }
    return r;
}