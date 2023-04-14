SELECT A.REST_ID,B.rest_name,B.food_type,B.favorites FAVORITES,B.address,round(avg(A.review_score),2) SCORE
from rest_review A join (select * from rest_info where address like '서울%') B on A.rest_id=B.rest_id
group by B.rest_id
order by score desc,favorites desc