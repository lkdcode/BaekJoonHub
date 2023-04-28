-- 코드를 입력하세요
SELECT
    DISTINCT(C.CAR_ID) AS 'CAR_ID'
FROM CAR_RENTAL_COMPANY_CAR AS C
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    ON C.CAR_ID = H.CAR_ID
WHERE C.CAR_TYPE = '세단'
    AND H.START_DATE LIKE '%-10-%'
ORDER BY 1 DESC
;


# CAR_ID : 자동차 아디
# CAR_TYPE : 자동차 종류
# DAILY_FEE : 일일 대여 요금
# OPTIONS : 자동차 옵션 리스트

# HISTORY_ID : 자동차 대여 기록 아디
# CAR_ID : 자동차 아디
# START_DATE : 대여 시작일
# END_DATE : 대여 종료일




