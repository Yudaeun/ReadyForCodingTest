SELECT history_id, car_id, date_format(start_date,'%Y-%m-%d') start_date, date_format(end_date,'%Y-%m-%d') end_date,
CASE WHEN DATEDIFF(END_DATE,START_DATE)>=29 THEN '장기 대여'
ELSE '단기 대여' END RENT_TYPE
from car_rental_company_rental_history 
where year(start_date)=2022 and month(start_date)=9
order by history_id desc;