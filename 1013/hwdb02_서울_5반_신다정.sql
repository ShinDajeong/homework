select * from employees;
select * from departments;
select * from locations;
select * from regions;
select * from countries;
select * from jobs;
select * from salgrades;
-- 1번
select concat(e.first_name, ' ', e.last_name) 'name', e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

-- 2번
select distinct(e.job_id), l.street_address
from employees e, departments d, locations l
where d.location_id = l.location_id and e.department_id = d.department_id and e.department_id = 30;

-- 3번
select concat(e.first_name, ' ', e.last_name) 'name', d.department_name, l.street_address
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id and e.commission_pct is not null;

-- 4번
select concat(e.first_name, ' ', e.last_name) 'name', d.department_name
from employees e, departments d
where e.department_id = d.department_id and (binary e.first_name like '%A%' or binary e.last_name like '%A%');

-- 5번
-- dallas..?

-- 6번
select e.employee_id 'emp#', e.first_name 'employee', m.employee_id 'mgr#' , m.first_name 'manager'
from employees e inner join employees m
on e.manager_id = m.employee_id;

-- 7번
select e.first_name, j.job_title, d.department_name, e.salary, s.grade
from employees e, jobs j, departments d, salgrades s
where e.job_id = j.job_id and e.department_id = d.department_id 
and e.salary between s.losal and hisal;

-- 8번
select last_name, hire_date
from employees
where hire_date >  (select hire_date
					from employees
					where last_name = 'Smith');
                    
-- 9번
select e.first_name, e.hire_date, m.first_name, m.hire_date
from employees e, employees m
where e.manager_id = m.employee_id and e.hire_date < m.hire_date;

-- 10번
select concat(first_name, ' ', last_name), hire_date
from employees
where department_id in (select department_id
						from employees
						where last_name = 'Smith');

-- 11번
select employee_id, concat(first_name, ' ', last_name), salary
from employees 
where salary > (select avg(salary)
				from employees)
order by salary desc;

-- 12번
select employee_id, concat(first_name, ' ', last_name) 'name'
from employees
where department_id in (select department_id
						from departments
						where department_name like binary '%T%');

-- 13번
select employee_id, concat(first_name, ' ', last_name) 'name', salary
from employees
where department_id in (select department_id
						from employees
						where (binary first_name like '%T%' or binary last_name like '%T%') 
						and salary > (select avg(salary) from employees));
                        
-- 14번 
select employee_id, concat(first_name, ' ', last_name) 'name', salary
from employees
where salary > all (select e.salary
					from employees e, jobs j
					where e.job_id = j.job_id and j.job_title like '%Clerk%');

-- 15번
select concat(e.first_name, ' ', e.last_name) 'name', department_name
from employees e, departments d
where e.department_id = d.department_id
and (salary, commission_pct) in (select salary, commission_pct
								from employees
								where department_id in (select d.department_id
														from departments d, locations l
														where d.location_id = l.location_id and l.city = 'New York'));







