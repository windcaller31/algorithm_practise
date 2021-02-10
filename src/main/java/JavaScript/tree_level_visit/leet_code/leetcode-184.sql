select
  d.Name as Department,
  s_0.Name as Employee,
  s.Salary as Salary
from (
  select
    DepartmentId,
    max(Salary) as Salary
  from Employee
  group by DepartmentId
)s join (
  select Salary,DepartmentId,Name
  from Employee
)s_0 on s.DepartmentId = s_0.DepartmentId and s_0.Salary = s.Salary
left join (
  select Id,Name
  from Department
)d on s.DepartmentId = d.Id
