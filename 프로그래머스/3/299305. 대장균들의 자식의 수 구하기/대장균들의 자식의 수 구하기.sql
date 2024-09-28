select id, case when B.parent_id is null then 0
            else B.cnt end child_count
from ecoli_data A left join
(select parent_id, count(*) cnt
from ecoli_data
group by parent_id) B on A.id=B.parent_id
order by id