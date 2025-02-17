select * from emp;
select * from dept;

-- 문제 1
select * from emp where SUBSTR(hiredate, 4, 2) = 10;
-- 문제 2
select * from emp where SUBSTR(hiredate, 1, 2) = '03';
-- 문제 3 (데이터 길이가 다를 수 있으므로 음수로 뒤에서 검색)
select * from emp where SUBSTR(ename,  -1) = '기';
-- 문제 4
select empno, ename, job, sal, 
decode(job, '부장', sal*1.05,
                '과장', sal*1.1,
                '대리', sal*1.15,
                '사원', sal*1.2) as upsal 
                from emp where job not in('차장', '사장');
-- 문제 5
select hiredate, TO_CHAR(hiredate, 'YYYY / MON') "CDATE" from emp;

-- ==================== GROUP by 문제 ====================

-- 그룹함수 문제
-- 문제 1
select max(sal) "Maximum",min(sal) "Mnimum",sum(sal) "Sum",ROUND(AVG(sal))  "Average" from emp;
-- 문제 2
select JOB, max(sal) "Maximum",min(sal) "Mnimum",sum(sal) "Sum",ROUND(AVG(sal))  "Average" from emp GROUP by JOB;
-- 문제 3
select job, count(job) from emp group by job;
-- 문제 4
select sum(count(comm)) from emp group by comm HAVING comm != 0;
-- 문제 5
select Max(sal) - min(sal) "차액" from emp;
-- 문제 6
select job, min(sal) "차액" from emp GROUP by job HAVING min(sal) >= 500 order by min(sal) desc;
-- 문제 7
select deptno , count(*) "Number Of People", round(avg(sal),2)  from emp GROUP by deptno order by deptno;
-- 문제 8
select decode(deptno, 10, '경리부',20, '인사부',30, '영업부',40, '전산부') "Dname",
        decode(deptno, 10, '서울',20, '인천',30, '용인',40, '수원') "Location",
        count(deptno) "Number Of People",
        round(avg(sal),2) "Sal"
        from emp GROUP by deptno;
        
-- ==================================================
CREATE TABLE DEPT01(DEPTNO NUMBER(2), DNAME VARCHAR2(14));
INSERT INTO dept01 VALUES(10, 'ACCOUNTING');
INSERT INTO dept01 VALUES(20, 'RESEARCH');
        
CREATE TABLE DEPT02( DEPTNO NUMBER(2), DNAME VARCHAR2(14));
INSERT INTO dept02 VALUES(10, 'ACCOUNTING');
INSERT INTO dept02 VALUES(30, 'SALES');

SELECT * FROM dept01;
SELECT * FROM dept02;

select * from dept01 INNER join dept02 on dept01.deptno = dept02.deptno;

-- ==================== JOIN 문제 ====================

-- 문제 1
SELECT emp.ename, emp.hiredate FROM EMP JOIN DEPT ON dept.deptno = emp.deptno WHERE dept.dname = '경리부';

-- 문제 2
SELECT emp.ename, emp.sal FROM EMP JOIN DEPT ON dept.deptno = emp.deptno WHERE dept.loc = '인천';

-- ==================== 서브 쿼리 문제 ====================
-- 문제 1
select * from emp where job =  (select job from emp where ename = '김사랑');
-- 문제 2
select ename,sal from emp where sal >=  (select sal from emp where ename = '김사랑');
-- 문제 3
select ename, sal from emp where deptno = (select deptno from dept where loc = '용인');
-- 문제 4
select ename, sal from emp where MGR = (select empno from emp where ename = '장동건');
-- 문제 5
select * from emp where sal in (select MAX(sal) from emp group by deptno);
-- 문제 6
SELECT * FROM DEPT WHERE DEPTNO IN ( SELECT DEPTNO FROM EMP WHERE JOB='과장');
-- 문제 7
select ename, sal, job from emp where sal > all(select Max(sal) from emp GROUP by job having job = '과장');
-- 문제 8
select ename, sal, job from emp where sal > any(select min(sal) from emp GROUP by job having job = '과장') order by sal desc;

-- ==================== DDL 문제 ====================
SELECT rowid, empno, ename FROM emp;


create table EMP01 ( empno number, ename VARCHAR2(10), height number(3), address VARCHAR2(20), phone number(11));

select * from emp01;