SELECT B.user_id,B.nickname,sum(A.price) total_sales
from used_goods_board A join used_goods_user B on A.writer_id=B.user_id
where A.status='DONE'
group by A.writer_id
having sum(A.price)>=700000
order by total_sales