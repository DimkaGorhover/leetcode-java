-- https://leetcode.com/problems/second-highest-salary/

SELECT
    max(Salary) as SecondHighestSalary
FROM
    Employee e2
WHERE
    e2.Salary != (
        SELECT max(e1.Salary)
        FROM Employee e1
    );


