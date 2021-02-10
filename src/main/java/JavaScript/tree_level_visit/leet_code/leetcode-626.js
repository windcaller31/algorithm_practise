select * from (
  select id-1 as id ,student from seat where mod(id,2)=0
  union
  select id+1 as id ,student from seat where mod(id,2)=1 and id <> (select max(id) from seat)
  union
  select id as id ,student from seat where mod(id,2)=1 and id = (select max(id) from seat)
)t order by t.id
