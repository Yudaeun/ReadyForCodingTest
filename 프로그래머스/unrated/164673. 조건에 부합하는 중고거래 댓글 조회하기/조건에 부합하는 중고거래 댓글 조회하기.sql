SELECT a.title,a.board_id,b.reply_id,b.writer_id,b.contents,date_format(b.created_date,'%Y-%m-%d') CREATED_DATE
from used_goods_board a join used_goods_reply b
on a.board_id=b.board_id
where date_format(a.created_date,'%Y-%m')='2022-10'
order by CREATED_DATE,a.title;