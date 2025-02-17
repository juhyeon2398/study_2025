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
# DUAL
1. 데이터를 가공하여 확인하는 데미 테이블
# 숫자 함수
1. ABS - 절대값 ex) SELECT -10, ABS(-10) FROM dual;
2. FLOOR - 소수점 버림 ex) SELECT 34.5678, FLOOR(34.5678) FROM dual;
3. ROUND - 반올림 ex) SELECT 34.5678, ROUND(34.5678, 2) FROM dual;
4. TRUNC - 특정 자리수에서 자름 ex) SELECT TRUNC(34.5678,2), TRUNC(34.5678, -1),
                                                            TRUNC(34.5678) FROM dual;
5. MOD - 나머지 값 ex) SELECT MOD(27,2), MOD(27,5), MOD(27,7) FROM dual;
# 문자 함수
1. SUBSTR - 시작인덱스에서 문자열 자르기 ex) SUBSTR(대상, 시작 위치, 추출할 개수)
2. LENGTH - 문자열 길이
3. LOWER - 소문자 변환
4. UPPER - 대문자 변환
5. TRIM - 잘라낸 나머지 출력 (LTRIM, RTRIM)
   * SELECT TRIM(‘ Oracle ‘) FROM dual; // 공백제거
   * SELECT TRIM(‘a’ FROM ‘aaaaOracleaaaa‘) FROM dual; // 특정 문자 제거
# 날짜 함수
1. SYSDATE - 시스템 날짜를 반환
# 형변환 함수
1. DATE 데이터를 지정한 VARCHAR2 형 문자로 변환
2. TO_CHAR(날짜->문자) ex) TO_CHAR(sysdate, ‘YYYY-MM-DD’)
   * YYYY - 년도 표현(4자리)
   * YY - 년도 표현(2자리)
   * MM - 월을 숫자로 표현
   * MON - 월을 알파벳으로 표현 (시스템이 한글이면 월로 표시함)
   * DAY - 요일 표현
   * DY - 요일을 약어로 표현
3. TO_CHAR(시간->문자) ex) TO_CHAR(sysdate, ‘HH24:MI:SS’)
   * AM 또는 PM - 오전(AM), 오후(PM) 시각 표시
   * A.M 또는 P.M - 오전(A.M), 오후(P.M) 시각 표시
   * HH또는 HH12 시간(1~12)
   * HH24 - 24시간으로 표현(0~23)
   * MI - 분 표현
   * SS - 초 표현
4. TO_DATE
   * 문자열 데이터를 DATE 형으로 변환
   * ex) TO_DATE(‘20040108’,’YYYYMMDD’);
# DECODE
1. switch case 문과 같은 기능
<pre>
DECODE(표현식, 조건1, 결과1,
               조건2, 결과2,
               조건3, 결과3,
               기본결과n
       )
</pre>
# CASE
1. if else if else 와 유사한 구조 - 범위지정가능(DECODE와의 차이점)
<pre>
CASE 표현식 WHEN 조건1 THEN 결과1
            WHEN 조건1 THEN 결과1
            WHEN 조건1 THEN 결과1
            ELSE 결과n
END
</pre>
# NVL
1. NULL 값을 대체하는 값을 변환 ex) NVL(comm,0)
# 그룹 함수
1. 그룹함수(칼럼명)
2. SUM - 그룹 누적 합계
3. AVG - 그룹 평균
4. COUNT - 그룹의 개수
5. MAX - 그룹 최대값
6. MIN - 그룹 최소값
# JOIN
1. 다른 테이블의 데이터를 참조하여 필요한 데이터를 찾음
2. OUTER JOIN
   * 조인 조건에 만족하지 못하였더라도 해당 행을 나타내고 싶을 때에 사용
   * 미충족 행은 NULL로 채워짐
3. INNER JOIN
   * ON 절을 이용하여 조인 조건을 명시하여 조건에 맞는 행만 출력
# 서브 쿼리
1. 하나의 SELECT 문장의 절 안에 포함된 또 하나의 SELECT 문장
2. 서브쿼리에 그룹함수도 사용가능
3. IN 연산자
   * 서브 쿼리의 결과 중에서 하나라도 일치하면 참
   <pre>
     SELECT ename, sal , deptno 
            FROM emp 
            WHERE deptno 
            IN (SELECT DISTINCT deptno FROM emp WHERE sal>=400);
   </pre>
4. ALL 연산자
   * 서브 쿼리의 검색 결과와 모든 값이 일치하면 참
   <pre>
   SELECT ename, sal
          FROM emp
          WHERE sal > ALL (
            SELECT sal FROM emp WHERE deptno=30
          );
   </pre>
5. ANY 연산자
   * 서브 쿼리의 검색 결과와 하나 이상만 일치하면 참
   <pre>
   SELECT ename, sal
          FROM emp
          WHERE sal > ANY (
            SELECT sal FROM emp WHERE deptno=30
          );
   </pre>
# DDL
1. CREATE - 데이터베이스, 테이블등을 생성하는 역할
   <pre>
     CREATE TABLE 테이블명(
      column_name1 data_type expr...,
      column_name2 data_type
      )
   </pre>
2. ALTER - 테이블을 수정하는 역할
3. DROP - 데이터베이스, 테이블을 삭제하는 역할
4. TRUNCATE - 테이블을 초기화 시키는 역할
