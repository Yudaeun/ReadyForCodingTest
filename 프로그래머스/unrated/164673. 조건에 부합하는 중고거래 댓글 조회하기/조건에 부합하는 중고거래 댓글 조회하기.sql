SELECT A.title,A.board_id,B.reply_id,B.writer_id,B.contents,date_format(B.created_date,'%Y-%m-%d') CREATED_DATE
from used_goods_board A join used_goods_reply B on A.board_id=B.board_id
where year(A.created_date)=2022 and month(A.created_date)=10
order by B.created_date,A.title;