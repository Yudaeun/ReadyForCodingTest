select fish_count, max_length, fish_type
from 
(select fish_type, avg(length) avg_length, max(length) max_length, count(id) fish_count
from (select id, fish_type, 
      case when length is null then 10 
      else length end length
      from fish_info
) A
group by fish_type) fish_info
where avg_length>=33
order by fish_type asc;