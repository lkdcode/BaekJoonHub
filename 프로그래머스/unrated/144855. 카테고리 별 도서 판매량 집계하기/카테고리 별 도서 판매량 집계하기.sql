-- 코드를 입력하세요
SELECT
    book.CATEGORY,
    SUM(sales.SALES) AS '총 판매량'
FROM BOOK AS book
    JOIN BOOK_SALES AS sales
    ON book.BOOK_ID = sales.BOOK_ID
WHERE sales.SALES_DATE LIKE '%2022-01%'
GROUP BY book.CATEGORY
ORDER BY 1
;