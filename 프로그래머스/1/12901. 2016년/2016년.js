function solution(a, b) {
    const days = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    const arr = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
    let idx = 5;
    let month = 1;
    for (let day of days) {
        for (let d = 1; d <= day; d++) {
            if (idx >= 7) idx = 0;
            if (month === a && d === b) {
                return arr[idx];
            }
            idx++;
        }
        month++;
    }
    
    return answer;
}