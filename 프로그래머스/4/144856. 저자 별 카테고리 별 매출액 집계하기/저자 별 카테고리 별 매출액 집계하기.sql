SELECT 
    B.AUTHOR_ID,
    B.AUTHOR_NAME,
    A.CATEGORY,
    SUM(C.SALES * PRICE) AS TOTAL_SALES
FROM
    BOOK A,
    AUTHOR B,
    (SELECT *
    FROM BOOK_SALES
    WHERE TO_CHAR(SALES_DATE, 'YYYY-MM-DD') LIKE ('2022-01%')) C
WHERE
    A.AUTHOR_ID = B.AUTHOR_ID AND A.BOOK_ID = C.BOOK_ID
GROUP BY
   B.AUTHOR_ID, B.AUTHOR_NAME, A.CATEGORY
ORDER BY   
    1 , 3 DESC