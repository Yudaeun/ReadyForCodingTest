select A.year_date as year, abs(A.size_of_colony - B.max_colony) as year_dev, A.id
from (select *, year(DIFFERENTIATION_DATE) year_date
     from ecoli_data) A 
     join 
(select year_date, max(size_of_colony) max_colony
from (select *, year(DIFFERENTIATION_DATE) year_date from ecoli_data) A
group by year_date) B
on A.year_date = B.year_date
order by year, year_dev