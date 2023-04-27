-- 코드를 입력하세요
SELECT 
    book.BOOK_ID,
    author.AUTHOR_NAME,
    DATE_FORMAT(book.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK AS book
    JOIN AUTHOR AS author
    ON book.AUTHOR_ID = author.AUTHOR_ID
WHERE CATEGORY = '경제'
ORDER BY 3
;