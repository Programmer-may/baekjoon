function solution(food) {
    let answer = '';
    for (let i = 1; i < food.length; i++) {
        let num = Math.floor(food[i] / 2);
        for (let j = 0; j < num; j++) {
            answer += i;
        }
    }
    const reverse = answer.split('').reverse().join('');
    answer += 0;
    answer += reverse;
    return answer;
}