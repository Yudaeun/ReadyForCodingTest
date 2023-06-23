SELECT car_id, round((sum(datediff(end_date,start_date)))/count(car_id)+1,1) average_duration
from car_rental_company_rental_history
group by car_id
having (sum(datediff(end_date,start_date)))/count(car_id)+1>=7
order by average_duration desc, car_id desc