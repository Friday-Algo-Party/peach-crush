# [N과 M(4)](https://www.acmicpc.net/problem/15652)
## 문제
자연수 N과 M이 주어졌을 때 아래 조건을 만족하는 길이가 M인 수열 구하기
- 1부터 N까지 자연수 중에서 M개를 고른 수열
- 중복 가능
- 고른 수열은 비내림차순이어야 함

## 입력
- N : 수열에 포함될 수 있는 수의 최대 값
- M : 수열의 길이
- 1 <= M <= N <= 8
- N, M은 자연수

## 출력
- 한 줄에 하나씩 문제의 조건을 만족하는 수열 출력
- 중복되는 수열을 반복 출력하면 X
- 각 수열은 공백으로 구분해서 출력
- 수열은 사전 순으로 증가하는 순서로 출력

## 풀이
- 백트래킹 사용
```java
static void findSequence(int idx, int depth) {
    if (depth == M) {
        for (int i = 0; i < M; i++) {
            sb.append(sequence[i]).append(" ");
        }
        sb.append("\n");
    } else {
        for (int i = idx; i <= N; i++) {
            sequence[depth] = i;
            findSequence(i, depth + 1);
        }
    }
}
```

ex) 4 2

1. `findSequence(1, 0)` -> 1
2. `findSequence(1, 1)` -> 1 1
3. `findSequence(1, 2)` -> 출력 1 1
4. `findSequence(2, 1)` -> 1 2
5. `findSequence(2, 2)` -> 출력 1 2
6. `findSequence(3, 1)` -> 1 3
7. `findSequence(3, 2)` -> 출력 1 3
8. `findSequence(4, 1)` -> 1 4
9. `findSequence(4, 2)` -> 출력 1 4
10. `findSequence(2, 0)` -> 2 4
11. `findSequence(2, 1)` -> 2 2
12. `findSequence(2, 2)` -> 출력 2 2
13. `findSequence(3, 1)` -> 2 3
14. `findSequence(3, 2)` -> 출력 2 3
15. `findSequence(4, 1)` -> 2 4
16. `findSequence(4, 2)` -> 출력 2 4
17. `findSequence(3, 0)` -> 3 4
18. `findSequence(3, 1)` -> 3 3
19. `findSequence(3, 2)` -> 출력 3 3
20. `findSequence(4, 1)` -> 3 4
21. `findSequence(4, 2)` -> 출력 3 4
22. `findSequence(4, 0)` -> 4 4
23. `findSequence(4, 1)` -> 4 4
24. `findSequence(4, 2)` -> 출력 4 4