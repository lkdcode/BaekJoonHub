-- 코드를 입력하세요
SELECT COUNT(USER_ID) AS "USERS"
FROM USER_INFO
WHERE AGE >= 20 AND AGE < 30
AND JOINED LIKE '2021%'
;