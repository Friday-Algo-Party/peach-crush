# [p2798 블랙잭](https://www.acmicpc.net/problem/2798)
## 문제
- N장의 카드 중 3장의 카드를 골라 그 합이 M을 넘지 않으면서 M과 최대한 가깝게 만들기

## 입력
- 카드 수 N (3 <= N <= 100)
- 카드 합 기준 M (10 <= M <= 300000)

## 출력
- M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합

## 풀이
- minDiff : M과 sum의 최소 차이
- result : M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합
1. 앞에서부터 순서대로 카드 3개를 골라서 합 구하기
2. 합이 M보다 작으면 합과 M의 차이가 minDiff보다 작은지 비교
3. 작으면 minDiff와 result값 변경
4. 최종적으로 구해진 result 값 출력