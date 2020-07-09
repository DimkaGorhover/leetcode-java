-- Slow
select Email from (
    select p1.Email, count(1) as num
    from Person p1
    group by p1.Email
) s
where s.num > 1;

-- Fast
select Email
from Person
group by Email
having count(1) > 1