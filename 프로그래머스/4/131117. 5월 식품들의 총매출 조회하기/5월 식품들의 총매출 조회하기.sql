SELECT A.product_id, A.product_name, sum(B.amount) * A.price total_sales
from food_product A join food_order B on A.product_id = B.product_id
where year(B.produce_date) = 2022 and month(B.produce_date) = 5
group by A.product_id
order by total_sales desc, A.product_id