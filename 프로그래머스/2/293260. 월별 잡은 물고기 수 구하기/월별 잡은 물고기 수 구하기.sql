select count(month(time)) fish_count, month(time) month
from fish_info
group by month(time)
order by month