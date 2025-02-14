user scott    // 계정
identified by tiger; // password
select ename || `is a` || job 칼럼을 연결할떄 || 사용COMCAT으로도 가능

# 데이터형
1. NUMBER - 숫자형
2. DATE - 날짜형
3. VARCHAR2 - 문자형
   * char -> 정적데이터형
# DISTINCT
1. select DISTINCT deptno from emp; - 중복제거
2. 중복을 제거할 컬럼 앞에서 사용
# WHERE
1. SELECT * column1, column2 FROM 테이블명 WHERE 조건절
2. 날짜나 문자열은 ''로 사용한다.
3. 테이블내 데이터는 대소문자 구별함
4. BETWEEN 'A' AND 'B' -> A와 B 사이 결과
# LIKE
1. 검색하고자하는 값을 정확히 모를때 사용
2. EX) SELECT * FROM emp WHERE ename LIKE
3. ‘김%’; -> '김'으로 시작하는 모든 데이터
4. ‘%기%’를 사용하면 해당 데이터가 있는 모든 데이터 출력
5. '_' 는 갯수 제한을 둘때에 사용
6. 조건이 여러개 일 경우 완성된 조건식으로 연결하여야함
# NULL
1. = 기호로 비교가 불가
2. IS NULL로 데이터 출력
3. IS NOT NULL -> NULL 이 아닌데이터
# ORDER BY (오름/내림 차순)
1. ORDER BY는 제일 마지막에 붙는다.
2. DESC - 내림차순
   * SELECT * FROM emp ORDER BY sal DESC;
3. ASC - 오름차순 (디폴트값이라 생략가능)
   * SELECT * FROM emp ORDER BY sal
