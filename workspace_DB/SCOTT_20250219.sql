create table dept_copy as select * from dept;
create table emp_copy as select * from emp;
select * from dept_copy;

create view emp_view30 as
select empno, ename, deptno from emp_copy where deptno= 30;

create view emp_view20 as
select empno,ename,deptno,mgr from emp_copy where deptno = 20;
select * from emp_view30;

insert into emp_view30
values (1111, 'AAAA',30);
insert into emp_view30 values(8000,'김천사',30);

select * from emp_view30;

create or Replace view emp_view(사원번호, 사원명, 급여, 부서번호) as select empno,ename,sal, deptno from emp_copy;
select * from emp_view where 부서번호 =30;

create view sal_view as
select dname, Max(sal) "maxsal" ,Min(sal) "minsal" from emp_copy join dept_copy on emp_copy.deptno = dept_copy.deptno group by dname;

select * from sal_view;

create or REPLACE view view_hire as
select empno,ename,hiredate from emp order by hiredate;

select rownum, empno,ename,hiredate from view_hire;

select rownum,empno, ename, sal from ( select empno,ename,sal from emp order by sal desc) where rownum <= 3;

create sequence dept_deptno_seq INCREMENT by 10 start with 10;
select dept_deptno_seq.nextval from dual;
select dept_deptno_seq.currval from dual;

create sequence emp_seq;

DROP TABLE EMP01;

create table emp01(
empno number(4) PRIMARY key,
ename varchar2(10),
hiredate date);
insert into emp01 values( EMP_SEQ.nextval, '이씨',sysdate);
select * from emp01;

create table emp01 as select * from emp;

SELECT TABLE_NAME, INDEX_NAME, COLUMN_NAME

FROM USER_IND_COLUMNS
WHERE TABLE_NAME IN('EMP', 'EMP01');

insert into emp01 select * from emp01;
insert into emp01(empno,ename) values (1111, '홍길동' );
select count(*) from emp01;
select * from emp01;
select DISTINCT empno, ename from emp01 where ename ='홍길동';
drop index index_name;
create index index_name on emp01(ename);
