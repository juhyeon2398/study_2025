CREATE TABLE emp02 AS SELECT * FROM emp;
SELECT * FROM emp02;

CREATE TABLE emp03 AS SELECT empno, ename FROM emp;
SELECT * FROM emp03;

CREATE TABLE emp04 AS SELECT * FROM emp WHERE deptno = 10;
SELECT * FROM emp04;

-- 문제 1
CREATE TABLE emp06 AS SELECT empno, ename, sal FROM emp;
SELECT * FROM emp06;

ALTER TABLE emp01 ADD JOB VARCHAR2(9);
SELECT * FROM emp01;

ALTER TABLE emp01 MODIFY JOB VARCHAR2(30);
DESC emp01;

ALTER TABLE emp01 DROP COLUMN JOB;
DESC emp01;

DROP TABLE emp02;

CREATE TABLE emp02 AS SELECT * FROM emp;
ALTER TABLE emp02 SET UNUSED(JOB);
SELECT * FROM emp02;

DESC user_tables;

SELECT table_name FROM user_tables ORDER BY table_name DESC;

-- 문제 9
CREATE TABLE dept_mission(dno NUMBER(2), dname VARCHAR2(14), loc VARCHAR2(13));
DESC dept_mission;
-- 문제 10
CREATE TABLE emp_mission(eno NUMBER(4), ename VARCHAR2(10), dno VARCHAR2(2));
DESC emp_mission;
-- 문제 11
ALTER TABLE emp_mission MODIFY ename VARCHAR2(25);
-- 문제 12
DROP TABLE emp_mission;
-- 문제 13
ALTER TABLE dept_mission DROP COLUMN dname;
DESC dept_mission;
-- 문제 14
ALTER TABLE dept_mission SET UNUSED (loc);
DESC dept_mission;
-- 문제 15
ALTER TABLE dept_mission DROP UNUSED COLUMNS;
DESC dept_mission;

DROP TABLE  dept01;
CREATE TABLE dept01 AS SELECT * FROM dept WHERE 1 = 0;

DESC dept01;
SELECT * FROM dept01;

INSERT INTO dept01( deptno, dname, loc) VALUES ( 10, '영업부', '부산');
SELECT * FROM dept01;

CREATE TABLE sam01(empno NUMBER(4), ename VARCHAR2(10), JOB VARCHAR2(9), sal NUMBER(7,2));
DESC sam01;

INSERT INTO sam01 VALUES(1000, '사과', '경찰', 1000);
INSERT INTO sam01 VALUES(1010, '바나나', '간호사', 1500);
INSERT INTO sam01 VALUES(1020, '오렌지', '의사', 2000);
SELECT * FROM sam01;

DESC dept;
DESC emp;
INSERT INTO sam01 VALUES(1030, '베리', '', 2500);
INSERT INTO sam01 VALUES(1040, '망고', NULL, 25000);

DROP TABLE dept02;
CREATE TABLE dept02 AS SELECT * FROM dept WHERE 1 = 0;
INSERT INTO dept02 SELECT * FROM dept;
SELECT * FROM dept02;
INSERT INTO sam01 SELECT empno, ename, JOB, sal FROM emp WHERE deptno = 10;

DROP TABLE emp01;
CREATE TABLE emp01 AS SELECT * FROM emp;
UPDATE emp01 SET deptno = 30 WHERE deptno = 10;
UPDATE emp01 SET sal = (sal*1.1) WHERE sal >=  400;

UPDATE sam01 SET sal = (sal - 5000) WHERE sal >= 10000;

SELECT * FROM emp;
SELECT * FROM emp01;
SELECT * FROM sam02;

DROP TABLE sam02;
CREATE TABLE sam02 AS SELECT ename, sal, hiredate, deptno FROM emp WHERE 1 = 0;
INSERT INTO sam02 SELECT ename, sal, hiredate, deptno FROM emp;

UPDATE sam02 SET sal = (sal+100) WHERE deptno = (SELECT deptno FROM dept WHERE loc = '인천' );

SELECT * FROM dept01;
SELECT * FROM sam02;

DELETE FROM sam01 WHERE JOB IS NULL;

DELETE FROM sam02 WHERE deptno = ( SELECT deptno FROM dept WHERE dname = '영업부');
DROP TABLE dept01;

CREATE TABLE dept01 AS SELECT * FROM dept;

DELETE FROM dept01 WHERE deptno = 40;
COMMIT;

DELETE FROM dept01 WHERE deptno = 30;

SAVEPOINT c1;
DELETE FROM dept01 WHERE deptno = 20;

SAVEPOINT c2;
DELETE FROM dept01 WHERE deptno = 10;

SELECT * FROM dept01;

ROLLBACK;

DESC user_constraints;
SELECT constraint_name, constraint_type, table_name FROM user_constraints;
select * from user_cons_columns;

drop table emp04;
create table emp04 ( empno number(4) not null,
                            ename varchar2(10) not null,
                            job varchar2(9),
                            deptno number(2)
                            );
                            
insert into emp04 values(null,null,'영업부', 30);

DROP TABLE usertable;
CREATE TABLE usertable(
    userno NUMBER PRIMARY KEY,
    userid VARCHAR2(20) NOT NULL UNIQUE,
    userpw VARCHAR2(20) NOT NULL, 
    usertel VARCHAR2(20) UNIQUE, 
    usermembership VARCHAR2(10) CHECK( usermembership IN ('gold', 'silver', 'bronze')),
    useremail VARCHAR2(20) UNIQUE,
    userpoint NUMBER DEFAULT 1000, 
    joindate DATE DEFAULT sysdate
    );
    
 DESC usertable;
 

INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (1, 'id01', '1111', '010-1111-1111', 'gold', 'id01@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (2, 'id02', '1111', '010-1111-2222', 'silver', 'id02@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (3, 'id03', '1111', '010-1111-3333', 'bronze', 'id03@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (4, 'id04', '1111', '010-1111-4444', 'gold', 'id04@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (5, 'id05', '1111', '010-1111-5555', 'silver', 'id05@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (6, 'id06', '1111', '010-1111-6666', 'bronze', 'id06@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (7, 'id07', '1111', '010-1111-7777', 'gold', 'id07@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (8, 'id08', '1111', '010-1111-8888', 'silver', 'id08@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (9, 'id09', '1111', '010-1111-9999', 'bronze', 'id09@aa.com');
INSERT INTO usertable (userno, userid, userpw, usertel, usermembership, useremail) VALUES (10, 'id10', '1111', '010-1111-0000', 'gold', 'id10@aa.com');
COMMIT;

SELECT * FROM usertable;


--1) userNo 이 5 이상인 회원을 검색하시오.
SELECT * FROM usertable WHERE userno >= 5;

--2) userNo 이 3 ~ 7 사이인 회원을 검색하시오.
SELECT * FROM usertable WHERE userno BETWEEN 3 AND 7;

--3) userTel 마지막 4자리가 '5555' 인 회원을 검색하시오.
SELECT * FROM usertable WHERE substr(usertel, -4) = '5555';

--4) userMembership 이 'gold' 인 회원의 userPoint 평균을 출력하시오. 
SELECT AVG(userpoint) FROM usertable GROUP BY usermembership HAVING usermembership = 'gold';

--5) userId 가 'id03' 인 회원의 joinDate 를 '2019/10/28/'로 수정하시오.
UPDATE usertable SET joindate = '2019/10/28' WHERE userid = 'id03';
SELECT * FROM usertable WHERE userid = 'id03';

--6) userMembership 이 'gold' 인 회원들의 userPoint 를 모두 3배 증가시키시오.
UPDATE usertable SET userpoint = userpoint*3 WHERE usermembership = 'gold';
SELECT * FROM usertable WHERE usermembership = 'gold';

--7) userId 가 'id08' 인 회원의 userPw 를 '2222'로 수정하시오.
UPDATE usertable SET userpw = '2222' WHERE userid = 'id08';
SELECT * FROM usertable WHERE userid = 'id08';

--8) userMembership 이 'bronze' 인 회원들 중에서 userPoint 가 1000 이상인 회원들의 
--    userMembership 을 'silver'로 수정하시오.
SELECT * FROM usertable WHERE usermembership = 'bronze';
UPDATE usertable SET usermembership = 'silver' WHERE usermembership = 'bronze' AND userpoint >= 1000;

--9) userNo 가 5 인 회원을 삭제하시오.
DELETE FROM usertable WHERE userno = 5;

SELECT * FROM usertable;

DESC usertable;
DESC user_constraints;
SELECT * FROM user_cons_columns WHERE table_name = 'USERTABLE';

create table book( 
bookid number PRIMARY key,
bookname varchar2(50),
publisher varchar2(50),
price number
);

create table customer ( 
customerid number PRIMARY key,
name varchar2(20),
address varchar2(50),
phone varchar2(20)
);

create table orders ( 
orderid  number PRIMARY key,
customerid  NUMBER REFERENCES customer(customerid),
bookid  NUMBER REFERENCES book(bookid),
saleprice NUMBER,
orderdate date
);

insert into book values (1, '축구의역사', '굿스포츠', 7000);
insert into book values (2, '축구아는여자', '나무수', 13000);
insert into book values (3, '축구의이해', '대한미디어', 22000);
insert into book values (4, '골프바이블', '대한미디어', 35000);
insert into book values (5, '피겨교본', '굿스포츠', 6000);
insert into book values (6, '역도단계별기술', '굿스포츠', 6000);
insert into book values (7, '야구의추억', '이상미디어', 20000);
insert into book values (8, '야구를부탁해', '이상미디어', 13000);
insert into book values (9, '올림픽이야기', '삼성당', 7500);
insert into book values (10, '올림픽챔피언', '피어슨', 13000);

insert into customer values (1, '박지성', '영국 맨체스터', '010-0000-0000');
insert into customer values (2, '김연아', '대한민국 서울', '010-1111-1111');
insert into customer values (3, '장미란', '대한민국 강원도', '010-2222-2222');
insert into customer values (4, '추신수', '미국 텍사스', '010-4444-4444');
insert into customer values (5, '박세리', '대한민국 대전', '010-5555-5555');

insert into orders values (1, 1, 1, 6000, '2014-07-01');
insert into orders values (2, 1, 3, 21000, '2014-07-03');
insert into orders values (3, 2, 5, 8000, '2014-07-03');
insert into orders values (4, 3, 6, 6000, '2014-07-04');
insert into orders values (5, 4, 7, 20000, '2014-07-07');
insert into orders values (6, 1, 2, 12000, '2014-07-07');
insert into orders values (7, 4, 8, 13000, '2014-07-07');
insert into orders values (8, 3, 10, 12000, '2014-07-08');
insert into orders values (9, 2, 10, 7000, '2014-07-09');
insert into orders values (10, 3, 8, 13000, '2014-07-10');

commit;

select * from book;
select * from customer;
select * from orders;
--4. bookid가 1인 책의 이름을 출력하시오.
select bookname from book where bookid = 1 ;
--5. 가격이 20000원 이상인 책의 이름을 모두 출력하시오.
select bookname from book where price >= 20000;
--6. 출판사 중복을 제거하여 출력하시오.
select DISTINCT(publisher) from book;
--7. 총 판매된 책의 가격을 구하고, 컬럼명을 '총판매액'으로 출력하시오.
select * from orders;
--8. 박지성의 총 구매액을 구하시오.
select sum(saleprice) from orders 
    where customerid = (
        select customerid from customer where name = '박지성' 
    );
--9. 박지성의 구매한 도서 수를 구하시오.
select count(*) from orders 
    where customerid = (
        select customerid from customer where name = '박지성' 
    );
--10. 2014년 7월 4일부터 7월 7일 사이에 주문 받은 주문 정보를 출력하시오. (+@ 기간 제외 정보 출력)
select * from customer 
        inner join orders on customer.customerid = orders.customerid 
        inner join book on book.bookid = orders.bookid  
        where orderdate BETWEEN '14/07/04' and '14/07/07' ;
        
--11. 주문한 적이 없는 고객의 이름을 출력하시오.
select name from customer where customerid = all(select customerid from orders);
--12. 박지성이 구매한 도서의 출판사 수(중복없이)를 출력하시오.
select count(book.publisher) from book 
        inner join orders on book.bookid = orders.bookid  
        inner join customer on customer.customerid = orders.customerid
        where name = '박지성';
        
select count(*) from orders 
        group by customerid
        HAVING customerid = (
        select customerid from customer where name = '박지성');
        
--13. 고객의 모든 이름과 고객별 총 구매액을 함께 출력하시오.
SELECT name, sum(orders.saleprice) FROM customer
    left OUTER JOIN orders 
    on orders.customerid = customer.customerid group by name;
--13-1. 구매 내역이 있는 고객의 이름과 고객별 총 구매액을 함께 출력하시오.
select name, sum(orders.saleprice)  from customer 
    JOIN orders on orders.customerid = customer.customerid 
    GROUP by orders.customerid, name ;

--13-2. 고객의 모든 이름과 고객별 총 구매액을 함께 출력하되 구매 내역이 없는 고객의 구매 금액은 0으로 출력하시오.
SELECT name, NVL(sum(orders.saleprice),0) FROM customer
    left OUTER JOIN orders 
    on orders.customerid = customer.customerid group by name;
