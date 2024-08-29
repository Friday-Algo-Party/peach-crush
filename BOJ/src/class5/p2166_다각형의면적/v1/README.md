# [다각형의 면적](https://www.acmicpc.net/problem/2166)
## 문제
다각형의 면적 구하기

## 입력
- N : 점의 개수
- x, y : 좌표
- x, y는 절대값이 100000을 넘지 않는 정수

## 출력
- 다각형의 면적 출력
- 소수점 아래 둘째 자리에서 반올림하여 첫째 자리까지 출력
- 
## 풀이
- [신발끈 공식 사용](https://namu.wiki/w/%EC%8B%A0%EB%B0%9C%EB%81%88%20%EA%B3%B5%EC%8B%9D)
- `|(x1y2 + x2y3 + ... + xny1) - (x2y1 + x3y2 + ... x1yn)| / 2`
- 소수점 둘째 자리에서 반올림한 값 출력 : `System.out.printf("%.1f", result);`