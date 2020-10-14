select
sum ( case when deapartment_id = 50 then salary else 0 end ) max50,
avg ( case when deapartment_id = 60 then salary else 0 end ) agv60,
max ( case when deapartment_id = 90 then salary else 0 end ) max90,
min ( case when deapartment_id = 90 then salary else 0 end ) min90
from employees;

select
sum( case when department_id=50 then salary end ) sum50,
avg( case when department_id=60 then salary end ) avg60
from employees;

select * from employees;



select
sum( case when department_id=50 then salary end ) sum50,
avg( case when department_id=60 then salary end ) avg60,
max( case when department_id=90 then salary end ) max90,
min( case when department_id=90 then salary end ) min90
from employees;

-- 1번
select e.ename, e.sal, d.dname
from emp e, dept d
where e.deptno = d.deptno;

-- 2.
select d.dname
from emp e, dept d
where e.deptno = d.deptno
and e.ename = 'KING';

-- 3.
select e.ename, d.deptno, d.dname, e.sal
from emp e right outer join dept d
on e.deptno = d.deptno;

select d.deptno, d.dname, e.ename, e.sal
from dept d inner join emp e
on e.deptno = d.deptno;

select e.ename, d.deptno, d.dname, e.sal
from emp e right join dept d
on e.deptno = d.deptno;

-- 4.
select concat(e.ename,'의 매니저는 ' ,m.ename, '이다')
from emp e, emp m
where e.mgr = m.empno;

-- 5.
select e.ename, d.dname, e.sal, e.job
from emp e, dept d
where e.deptno = d.deptno and 
e.job = (select job
			from emp
			where ename = 'SCOTT');

select e.ename, d.dname, e.sal, e.job
from emp e, dept d, (select job from emp where ename = 'SCOTT') j
where e.deptno = d.deptno 
	and e.job = j.job;
    
-- 6.
select empno, ename, hiredate, sal
from emp
where deptno = (select deptno
				from emp
				where ename = 'SCOTT');
                
-- 7
select e.empno, e.ename, e.hiredate, e.sal
from emp e
where e.sal > (select avg(sal)
				from emp);

-- 8
select e.empno, e.ename, e.hiredate, e.sal, d.dname
from emp e, dept d
where e.deptno = d.deptno 
and e.job in (select job from emp where deptno = 30)
order by e.sal desc; 

-- 9.
select e.empno, e.ename, e.hiredate, e.sal, d.dname, e.job
from emp e, dept d
where e.deptno = d.DEPTNO
and e.deptno = 10
and e.job not in (select job from emp where deptno = 30);

-- 10.
select e.empno, e.ename, e.sal
from emp e
where e.sal in (select distinct sal from emp where ename in ('KING', 'JAMES'));

-- 11.
select e.empno, e.ename, e.sal
from emp e
where e.sal > (select max(sal) from emp where deptno = 30);

-- 12.


-- 13.
select e.empno, e.ename, e.sal, year(e.hiredate)
from emp e
where year(e.hiredate) = (select year(hiredate)
							from emp
							where ename = 'ALLEN');
