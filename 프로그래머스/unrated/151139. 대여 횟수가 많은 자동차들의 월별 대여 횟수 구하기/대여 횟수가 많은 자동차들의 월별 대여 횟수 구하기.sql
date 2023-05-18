select month(start_date) MONTH, CAR_ID, count(*) RECORDS
from car_rental_company_rental_history
where car_id in
(SELECT car_id
from car_rental_company_rental_history
where start_date>='2022-08-01' and start_date<'2022-11-01'
group by car_id
having count(*)>=5) and start_date>='2022-08-01' and start_date<'2022-11-01'
group by month(start_date),car_id
order by MONTH,car_id desc;