CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE m int;
Set m = N-1;
  RETURN (
    select
      s.Salary
    from (select distinct(Salary) from Employee)s
    order by Salary desc
    limit m,1
  );
END
