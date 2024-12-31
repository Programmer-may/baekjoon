function solution(n) {
    const primes = new Array(n + 1).fill(true); // true로 초기화된 배열 생성
    primes[0] = primes[1] = false; // 0과 1은 소수가 아님

    for (let i = 2; i * i <= n; i++) {
        if (primes[i]) {
            for (let j = i * i; j <= n; j += i) {
                primes[j] = false; // i의 배수를 모두 제거
            }
        }
    }

    // 소수의 개수를 반환
    return primes.filter(isPrime => isPrime).length;
}