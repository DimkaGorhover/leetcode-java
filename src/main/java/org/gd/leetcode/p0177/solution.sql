-- https://leetcode.com/problems/nth-highest-salary/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

    DECLARE counter INT DEFAULT 0;
    SET counter = (SELECT count(distinct Salary) FROM Employee);

    IF counter < N THEN
        RETURN (
            select null as Salary
        );
    END IF;

  RETURN (
      SELECT Salary
      FROM (SELECT DISTINCT e.Salary as Salary FROM Employee e ORDER BY e.Salary DESC LIMIT N) as T
      ORDER BY Salary ASC LIMIT 1

  );
END
