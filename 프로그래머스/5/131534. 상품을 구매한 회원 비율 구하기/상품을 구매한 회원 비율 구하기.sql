select year(sales_date) year, month(sales_date) month, count(distinct(B.user_id)) purchased_users, round(
count(distinct(B.user_id)) / (select count(*)
 from user_info 
 where year(joined) = 2021), 1)
puchased_ratio
from user_info A join online_sale B on A.user_id = B.user_id
where year(A.joined) = 2021 
group by year(sales_date), month(sales_date)
order by year, month