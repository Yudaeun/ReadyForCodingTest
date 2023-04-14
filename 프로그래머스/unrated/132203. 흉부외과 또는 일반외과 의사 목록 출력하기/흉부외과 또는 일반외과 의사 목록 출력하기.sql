SELECT dr_name,dr_id,mcdp_cd,date_format(hire_ymd,'%Y-%m-%d') hire_ymd
FROM DOCTOR
WHERE MCDP_CD in ('CS','GS')
order by hire_ymd desc,dr_name;