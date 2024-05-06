select count(id) fish_count,max(length) max_length, fish_type
from 
(select id, fish_type, case when
length<=10 then 10
else length end length
from fish_info) fish_info
group by fish_type
having avg(length)>=33
order by fish_type asc;