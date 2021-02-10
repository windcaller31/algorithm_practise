select
  t.Request_at as `Cancellation Rate`,
  round((sum(case t.Status when 'completed' then 0 else 1 end )/count(t.Id)),2) as `Day`
from (
  select *
  from Trips
  where client_id not in (select Users_Id from Users where banned = "yes" and role = "client")
  and request_at >= "2013-10-01" and request_at <= "2013-10-03"
)t
group by t.Request_at
order by t.Request_at asc
