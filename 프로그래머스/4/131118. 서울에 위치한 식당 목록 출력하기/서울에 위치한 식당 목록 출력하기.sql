SELECT A.rest_id, A.rest_name, A.food_type, A.favorites,
A.address, round(B.score,2) score 
from rest_info A join (select avg(review_score) score, rest_id from rest_review group by rest_id) B on A.rest_id=B.rest_id 
where A.address like '서울%'
order by score desc, A.favorites desc;