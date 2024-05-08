select id,
case when ranking<=count(*) over()*0.25 then 'CRITICAL'
when ranking<=count(*) over()*0.5 then 'HIGH'
when ranking<=count(*) over()*0.75 then 'MEDIUM'
else 'LOW'
end COLONY_NAME
from 
(select *, rank() over (order by size_of_colony desc) ranking 
from ecoli_data) ecoli_data
order by id;