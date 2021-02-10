update salary set sex = ( case sex when 'f' then 'm' else 'f' end; )


# Write your MySQL query statement below
select
  cinema.id,
  cinema.movie,
  cinema.description,
  cinema.rating
from  cinema
where mod(cinema.id,2) = 1 and cinema.description != 'boring'
order by cinema.rating desc


select
  t1.FirstName,
  t1.LastName,
  t2.City,
  t2.State
from (
  (
    select
      Person.FirstName,
      Person.LastName,
      Person.PersonId
    from Person
  )t1 left join (
    select
      Address.PersonId,
      Address.City,
      Address.State
    from Address
  )t2 on t1.PersonId = t2.PersonId
)
