select
    p.FirstName,
    p.LastName,
    a.City,
    a.State
from Person p
left join Address a on a.PersonId = p.PersonId