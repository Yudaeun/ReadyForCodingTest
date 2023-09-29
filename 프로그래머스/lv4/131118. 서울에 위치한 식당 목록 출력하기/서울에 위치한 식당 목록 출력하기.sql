select A.REST_ID, A.REST_NAME, A.FOOD_TYPE,A.FAVORITES, A.ADDRESS,ROUND(AVG(B.REVIEW_SCORE),2) SCORE
from rest_info A join rest_review B on A.REST_ID=B.REST_ID
where A.address like '서울%'
group by A.rest_name
order by SCORE DESC, A.FAVORITES DESC;