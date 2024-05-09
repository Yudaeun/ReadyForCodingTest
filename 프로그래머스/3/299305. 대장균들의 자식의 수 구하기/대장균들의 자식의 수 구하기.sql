select A.id,
case when B.parent_cnt is null then 0
else B.parent_cnt end child_count
from ecoli_data A left join 
(select parent_id, count(parent_id) parent_cnt
from ecoli_data
group by parent_id) B on A.id=B.parent_id
order by id