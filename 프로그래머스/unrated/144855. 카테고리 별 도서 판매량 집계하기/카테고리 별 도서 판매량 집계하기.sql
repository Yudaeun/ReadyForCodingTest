SELECT A.category,sum(sales) total_sales
from book A join book_sales B on A.book_id=B.book_id
where date_format(B.sales_date,'%Y-%m')='2022-01'
group by A.category
order by A.category