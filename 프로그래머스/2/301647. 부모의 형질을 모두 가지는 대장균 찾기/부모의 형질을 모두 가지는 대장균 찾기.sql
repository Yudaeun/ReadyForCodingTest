select A.id,A.genotype,B.parent_genotype
from ecoli_data A left join (select genotype parent_genotype, id from ecoli_data) B on A.parent_id=B.id
where B.parent_genotype & A.genotype = B.parent_genotype
order by A.id