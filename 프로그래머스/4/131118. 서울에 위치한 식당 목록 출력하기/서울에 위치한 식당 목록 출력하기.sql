SELECT B.rest_id, B.rest_name, B.food_type, B.favorites, B.address, round(score,2) score
from rest_info B join (select avg(review_score) score, rest_id
                   from rest_review
                   group by rest_id) A on A.rest_id=B.rest_id
where address like '서울%'
order by score desc, B.favorites desc;