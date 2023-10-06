SELECT C.author_id,C.author_name,B.category, sum(A.sales*B.price) total_sales
from
(select book_id,sum(sales) sales from book_sales where date_format(sales_date,'%Y-%m')='2022-01' group by book_id) A
join book B on A.book_id=B.book_id
join author C on B.author_id=C.author_id
group by B.author_id, B.category
order by C.author_id, B.category desc;