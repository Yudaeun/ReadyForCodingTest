-- 코드를 입력하세요
SELECT DISTINCT(B.CAR_ID)
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A 
JOIN CAR_RENTAL_COMPANY_CAR B
ON A.CAR_ID=B.CAR_ID
WHERE B.CAR_TYPE='세단' and MONTH(A.START_DATE)=10
ORDER BY A.CAR_ID DESC