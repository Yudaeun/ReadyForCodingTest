SELECT distinct(A.car_id) car_id
from car_rental_company_car A join car_rental_company_rental_history B on A.car_id=B.car_id
where A.car_type='세단' and B.start_date>='2022-10-01'
order by car_id desc;