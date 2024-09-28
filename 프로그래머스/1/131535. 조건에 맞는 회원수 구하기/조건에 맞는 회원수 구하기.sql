SELECT count(distinct(user_id)) users
from user_info
where year(joined)=2021 and age between 20 and 29