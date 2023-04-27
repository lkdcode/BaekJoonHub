-- 코드를 입력하세요
SELECT 
    hour(DATETIME) AS 'HOUR',
    count(*) as 'COUNT'
FROM ANIMAL_OUTS
WHERE hour(DATETIME) BETWEEN 9 AND 20
GROUP BY hour
ORDER BY hour
;