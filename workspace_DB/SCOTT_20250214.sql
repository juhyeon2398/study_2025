select * from emp;
SELECT * FROM dept;

--문제1
select empno,ename,sal from emp where sal<= 300;

--문제2
select empno,ename,sal from emp where ename = '오지호';

--문제3
select empno,ename, sal from emp where sal in(250, 300, 500);
select empno,ename, sal from emp where sal=250 or sal = 300 or sal = 500;

--문제4
select empno,ename, sal from emp where sal NOT in(250, 300, 500);
select empno,ename, sal from emp where sal != 250 and sal != 300 and sal ! = 500;

--문제5
select empno, ename from emp where ename like '%기%' OR ename like '김%';

--문제6
select * from emp where mgr is null;

--문제7
select empno,ename,job,hiredate from emp order by hiredate desc;

--문제8
select deptno,empno,ename,job,hiredate from emp order by deptno, hiredate;