SELECT b.product_id,a.product_name,(sum(amount)*a.price) TOTAL_SALES
from food_product a join food_order b on a.product_id=b.product_id
where b.produce_date>='2022-05-01' and b.produce_date<'2022-06-01'
group by b.product_id
order by TOTAL_SALES DESC,b.product_id;