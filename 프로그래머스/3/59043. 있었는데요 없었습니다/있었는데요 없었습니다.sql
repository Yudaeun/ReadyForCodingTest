SELECT A.animal_id, A.name
from animal_ins A join animal_outs B on A.animal_id = B.animal_id
where B.datetime < A.datetime
order by A.datetime