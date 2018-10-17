select
  d.Name as Department,
  e.Name as Employee,
  e.Salary as Salary
from Employee e,Department d
where e.DepartmentId = d.Id
AND (
  select count(distinct Salary)
  from Employee
  where DepartmentId = d.Id and Salary > e.Salary
)<3
