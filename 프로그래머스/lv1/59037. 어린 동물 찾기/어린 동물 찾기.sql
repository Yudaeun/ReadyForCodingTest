SELECT ANIMAL_ID, NAME
from animal_ins
where intake_condition != 'Aged'
order by animal_id;